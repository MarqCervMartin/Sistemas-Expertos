package com.example.appico.ui.home;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.appico.ConexionSQLiteHelper;
import com.example.appico.R;
import com.example.appico.asignaturasdb.Asignatura;
import com.example.appico.utilidades.DBLocalEstatica;
import com.example.appico.utilidades.Utilidades;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    DBLocalEstatica dbLocal = new DBLocalEstatica();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        final TextView txtDocentes = root.findViewById(R.id.informacionTxt);
        final TextView txtAsignatura = root.findViewById(R.id.asignaturaTxt);
        //String desplegar = consulta();
        final String docentes = consultaDocente();
        final String asignaturas = consultaAsignaturas();
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
                txtDocentes.setText(docentes);
                txtAsignatura.setText(asignaturas);
            }
        });

        return root;
    }

    private String consultaAsignaturas() {
        /*
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(getContext(), "ico_bd", null, 1);
        String desplegar="";
        //consultar
        conn = new ConexionSQLiteHelper(getContext(), "ico_bd",null,1);
        SQLiteDatabase db = conn.getReadableDatabase();
        try{
            //SELECT * FROM docente;
            Cursor cursor = db.rawQuery("SELECT * FROM "+Utilidades.TABLA_ASIGNATURA,null);
            while(cursor.moveToNext()){
                desplegar+="\nID "+cursor.getInt(0);
                desplegar+=" Matricula: "+cursor.getString(1);
                desplegar+=" Nombre: "+cursor.getString(2);
                desplegar+=" Creditos: "+cursor.getInt(3);
                desplegar+=" Turno: "+cursor.getString(4);
                desplegar+=" IDdocente: "+cursor.getInt(5);
                desplegar+=" DiaUno: "+cursor.getString(6);
                desplegar+=" HI: "+cursor.getString(7);
                desplegar+=" HS: "+cursor.getString(8);
                desplegar+=" Duracion: "+cursor.getFloat(9);
                desplegar+=" DiaDos: "+cursor.getString(10);
                desplegar+=" HI2: "+cursor.getString(11);
                desplegar+=" HS2: "+cursor.getString(12);
                desplegar+=" Duracion2: "+cursor.getFloat(13);
            }
            return desplegar;
            //System.out.println(desplegar);
        }catch (Exception e){
            Toast.makeText(getContext(),"Problema al cargar las asignaturas",Toast.LENGTH_SHORT).show();
            return "No se cargo las asignaturas";
        }*/
        String desplegar="";
        for(Asignatura a: dbLocal.getArray_asignaturas()){
            desplegar+="\nID "+a.getId();
            desplegar+=" Matricula: "+a.getMatricula();
            desplegar+=" Nombre: "+a.getNombre();
            desplegar+=" Creditos: "+a.getCreditos();
            desplegar+=" Turno: "+a.getTurno();
            desplegar+=" IDdocente: "+a.getDocente_id();
            desplegar+=" DiaUno: "+a.getDia_uno();
            desplegar+=" HI: "+a.getHora_inicio_dia_uno();
            desplegar+=" HS: "+a.getHora_salida_dia_uno();
            desplegar+=" Duracion: "+a.getDuracion_dia_uno();
            desplegar+=" DiaDos: "+a.getDia_dos();
            desplegar+=" HI2: "+a.getHora_inicio_dia_dos();
            desplegar+=" HS2: "+a.getHora_salida_dia_dos();
            desplegar+=" Duracion2: "+a.getDuracion_dia_dos();
            desplegar+="\n";
        }
        return desplegar;
    }

    private String consultaDocente() {
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(getContext(), "ico_bd", null, 1);
        String desplegar="";
        //consultar
        conn = new ConexionSQLiteHelper(getContext(), "ico_bd",null,1);
        SQLiteDatabase db = conn.getReadableDatabase();
        try{
            //SELECT * FROM docente;
            Cursor cursor = db.rawQuery("SELECT * FROM "+Utilidades.TABLA_DOCENTE,null);
            while(cursor.moveToNext()){
                desplegar+="\nID "+cursor.getInt(0);
                desplegar+=" Nombre: "+cursor.getString(4);
                desplegar+=" "+cursor.getString(1);
                desplegar+=" "+cursor.getString(2);
                desplegar+=" "+cursor.getString(3);
            }
            return desplegar;

        }catch (Exception e){
            Toast.makeText(getContext(),"Problema al cargar los docentes",Toast.LENGTH_SHORT).show();
            return "No se cargo los docentos";
        }
    }
}