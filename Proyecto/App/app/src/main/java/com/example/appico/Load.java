package com.example.appico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appico.agmodelo.Funciones;
import com.example.appico.agmodelo.Materia;
import com.example.appico.asignaturasdb.Asignatura;
import com.example.appico.utilidades.DBLocalEstatica;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class Load extends AppCompatActivity {

    DBLocalEstatica dblocal = new DBLocalEstatica();
    private ArrayList<Asignatura> arrayAsignaturas = new ArrayList<>();
    //Funciones funcionesClase = new Funciones();
    Funciones F = new Funciones();

    TextView pre;
    TextView nom;
    TextView ape;
    TextView cue;
    TextView tut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
        pre = (TextView) findViewById(R.id.inputsGenetico);
        nom = (TextView) findViewById(R.id.nombreLoad);
        ape = (TextView) findViewById(R.id.apellidoLoad);
        cue = (TextView) findViewById(R.id.cuentaLoad);
        tut = (TextView) findViewById(R.id.tutorLoad);

        ArrayList<String> Materias = (ArrayList<String>) getIntent().getSerializableExtra("ListaMaterias");
        Intent intent = this.getIntent();
        Bundle extra = intent.getExtras();
        String name = extra.getString("Name");
        String surname = extra.getString("Surname");
        String account = extra.getString("Cuenta");
        String tutor = extra.getString("Tutor");
        nom.setText(name);
        ape.setText(surname);
        cue.setText(account);
        tut.setText(tutor);
        pre.setText("Materias: "+Materias);
        Toast.makeText(getApplicationContext(),"Nombre: "+name, Toast.LENGTH_SHORT).show();

        generarHorarioEntrada(Materias);

        try {
            ejecutarAG();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

    private void generarHorarioEntrada(ArrayList<String> Materias) {
        for(int i=0;i<Materias.size();i++){
            for(Asignatura a : dblocal.getArray_asignaturas()){
                if(Materias.get(i).equals(a.getNombre())){
                    if(a.getDia_dos()!=null){
                        arrayAsignaturas.add(a);
                    }
                }
            }
        }

        pre.setText("");
        pre.setText(arrayAsignaturas.toString());
        F.setAsig(arrayAsignaturas);
    }

    private void ejecutarAG() throws IOException, ParseException {
        // TODO code application logic here
        ArrayList<Materia> SRE;
        ArrayList<Materia> MejorPadre;
        ArrayList<Materia> Niño;
        boolean Factible = false;
        float AptitudDeNiño = 0;
        //Funciones F = new Funciones();
        SRE = F.DiccionarioGen();
        //Toast.makeText(getApplicationContext(),"Tamaño diccionario: "+SRE.size(), Toast.LENGTH_SHORT).show();

        MejorPadre = F.generar_padre(8, SRE);
        System.out.println("\n\n");
        System.out.println("Padre");
        for(Materia Obj : MejorPadre){
            System.out.println(Obj.toString());
        }
        float MejorAptitud = F.aptitud(MejorPadre);
        System.out.println("Aptitud de Padre: " + MejorAptitud);
        int Reps = 0;
        while(true){
            Reps++;
            Niño = F.Mutar(MejorPadre);
            AptitudDeNiño = F.aptitud(Niño);
            Factible = F.Factibilidad(Niño);
            if(Reps == 10000){
                break;
            }
            if(Factible == false){
                continue;
            }
            if(AptitudDeNiño > MejorAptitud){
                continue;
            }
            if(AptitudDeNiño <= 3){
                break;
            }
            MejorAptitud = AptitudDeNiño;
            MejorPadre = Niño;
        }
        System.out.println("\n\n");
        System.out.println("Mejor Horario en " + Reps + " Iteraciones");
        for(Materia Obj : Niño){
            System.out.println(Obj.toString());
        }

        System.out.println("Aptitud : " + AptitudDeNiño);
        F.MostrarConjetura(Niño);

        if(Reps == 10000){
            System.out.println("ADVERTENCIA: El ESTE  HORARIO PUEDE TENER MATERIAS CRUZADAS, INTENTA METER MENOS MATERIAS.");
        }
        if(F.Factibilidad(Niño) == true){
            System.out.println("EN ESTE HORARIO NO SE CRUZAN MATERIAS");

            Intent resumen = new Intent(Load.this, ResumenHorario.class);
            resumen.putExtra("Horario", Niño.toString());
            startActivity(resumen);

        }else{
            System.out.println("EN ESTE HORARIO SE CRUZAN MATERIAS");
        }
    }
}