package com.example.appico;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.diegodobelo.expandingview.ExpandingItem;
import com.diegodobelo.expandingview.ExpandingList;
import com.example.appico.utilidades.DBLocalEstatica;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Objects;

public class Formulario extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    //lista expandible
    private ExpandingList mExpandingList;
    //bd local
    DBLocalEstatica db = new DBLocalEstatica();
    int contadorMaterias = 0;
    ArrayList<String> Semestres = new ArrayList<>();
    //componentes
    TextView comprobar;
    EditText nombreEtxt;
    EditText apellidosEtxt;
    EditText numeroDeCuentaEtxt;
    EditText tutorEtxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        //Spinner materias de un semestre
        Spinner semestrePrincipal = findViewById(R.id.semestrePrincipal);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.semestres, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        semestrePrincipal.setAdapter(adapter);
        semestrePrincipal.setOnItemSelectedListener(this);
        //floating action next
        FloatingActionButton next = findViewById(R.id.nextSummary);
        //componentees
        comprobar = (TextView) findViewById(R.id.TxtComprobar);
        nombreEtxt = (EditText) findViewById(R.id.name);
        apellidosEtxt = (EditText) findViewById(R.id.surname);
        numeroDeCuentaEtxt = (EditText) findViewById(R.id.ncuenta);
        tutorEtxt = (EditText) findViewById(R.id.tutor);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent load = new Intent(Formulario.this, Load.class);
                //startActivity(load);
                if(contadorMaterias >=12){
                    Toast.makeText(getApplicationContext(), "Hay "+contadorMaterias+" materias solo hasta 11", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Seleccionaste "+contadorMaterias+" materias", Toast.LENGTH_SHORT).show();
                    comprobar.setText(Semestres.toString());
                    //envio de formulario a load
                    if(nombreEtxt.getText().toString().isEmpty() || apellidosEtxt.getText().toString().isEmpty() || numeroDeCuentaEtxt.getText().toString().isEmpty()
                            || tutorEtxt.getText().toString().isEmpty()){
                        Toast.makeText(getApplicationContext(),"Completa los campos", Toast.LENGTH_SHORT).show();
                    }else{
                        Intent load = new Intent(Formulario.this, Load.class);
                        load.putExtra("Name", nombreEtxt.getText().toString());
                        load.putExtra("Surname", apellidosEtxt.getText().toString());
                        load.putExtra("Cuenta", numeroDeCuentaEtxt.getText().toString());
                        load.putExtra("Tutor", tutorEtxt.getText().toString());
                        load.putExtra("ListaMaterias", Semestres);
                        startActivity(load);
                    }

                }

            }
        });

    }
    private void createItems() {
        addItem("John", new String[]{"House", "Boat", "Candy", "Collection", "Sport", "Ball", "Head"}, R.color.pink, R.drawable.ic_menu_laptop);
        addItem("Mary", new String[]{"Dog", "Horse", "Boat"}, R.color.blue, R.drawable.ic_menu_laptop);
        addItem("Ana", new String[]{"Cat"}, R.color.purple, R.drawable.ic_menu_laptop);
        addItem("Peter", new String[]{"Parrot", "Elephant", "Coffee"}, R.color.yellow, R.drawable.ic_menu_laptop);
        addItem("Joseph", new String[]{}, R.color.orange, R.drawable.ic_menu_laptop);
        addItem("Paul", new String[]{"Golf", "Football"}, R.color.green, R.drawable.ic_menu_laptop);
        addItem("Larry", new String[]{"Ferrari", "Mazda", "Honda", "Toyota", "Fiat"}, R.color.blue, R.drawable.ic_menu_laptop);
        addItem("Moe", new String[]{"Beans", "Rice", "Meat"}, R.color.yellow, R.drawable.ic_menu_laptop);
        addItem("Bart", new String[]{"Hamburger", "Ice cream", "Candy"}, R.color.purple, R.drawable.ic_menu_laptop);
    }
    private void addItem(final String title, final String[] subItems, int colorRes, int iconRes) {
        //Let's create an item with R.layout.expanding_layout
        final ExpandingItem item = mExpandingList.createNewItem(R.layout.expanding_layout);

        //If item creation is successful, let's configure it
        if (item != null) {
            item.setIndicatorColorRes(colorRes);
            item.setIndicatorIconRes(iconRes);
            //It is possible to get any view inside the inflated layout. Let's set the text in the item
            ((TextView) item.findViewById(R.id.title)).setText(title);

            //We can create items in batch.
            item.createSubItems(subItems.length);
            for (int i = 0; i < item.getSubItemsCount(); i++) {
                //Let's get the created sub item by its index
                final View view = item.getSubItemView(i);

                //Let's set some values in
                configureSubItem(item, view, subItems[i]);
                Semestres.add(subItems[i]);
            }
            //contamos las materias
            contadorMaterias+=item.getSubItemsCount();
            item.findViewById(R.id.add_more_sub_items).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showInsertDialog(new OnItemCreated() {
                        @Override
                        public void itemCreated(String title) {
                            View newSubItem = item.createSubItem();
                            configureSubItem(item, newSubItem, title);
                        }
                    });
                }
            });

            item.findViewById(R.id.remove_item).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mExpandingList.removeItem(item);
                    //quitamos en el contador de materias si se removio
                    contadorMaterias-=item.getSubItemsCount();
                    Toast.makeText(getApplicationContext(), "Removido "+title, Toast.LENGTH_SHORT).show();

                }
            });

            /*
            item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    item.getSubItemView(0);
                    Toast.makeText(getApplicationContext(), "que pedo"+item.getSubItemView(view.get), Toast.LENGTH_SHORT).show();

                }
            });*/

        }
    }

    private void configureSubItem(final ExpandingItem item, final View view, final String subTitle) {
        ((TextView) view.findViewById(R.id.sub_title)).setText(subTitle);
        view.findViewById(R.id.remove_sub_item).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Removido "+ subTitle, Toast.LENGTH_SHORT).show();
                item.removeSubItem(view);
                //quitamos una unidad
                contadorMaterias-=1;
                for(int i=0;i<Semestres.size();i++){
                    if(Semestres.get(i).equals(subTitle)){
                        Semestres.remove(i);
                    }
                }
            }
        });
    }

    private void showInsertDialog(final OnItemCreated positive) {
        final EditText text = new EditText(this);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(text);
        builder.setTitle(R.string.enter_title);
        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                positive.itemCreated(text.getText().toString());
            }
        });
        builder.setNegativeButton(android.R.string.cancel, null);
        builder.show();
    }

    interface OnItemCreated {
        void itemCreated(String title);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();
        //crear lista
        mExpandingList = findViewById(R.id.expanding_list_main);
        if(contadorMaterias > 16){
            Toast.makeText(adapterView.getContext(), "Solo Puedes cargar 11 materias maximo", Toast.LENGTH_SHORT).show();
        }else{
            switch (text) {
                case "Segundo TM":
                    crearSegundoTM();
                    break;
                case "Segundo TV":
                    crearSegundoTV();
                    break;
                case "Cuarto TM":
                    crearCuartoTM();
                    break;
                case "Cuarto TV":
                    crearCuartoTV();
                    break;
                case "Sexto TM":
                    crearSextoTM();
                    break;
                case "Sexto TV":
                    crearSextoTV();
                    break;
                case "Octavo TM":
                    crearOctavoTM();
                    break;
                case "Recurses":
                    crearRecurses();
                    break;
                case "Optativas de Línea":
                    crearOptativas();
                default:
                    Toast.makeText(adapterView.getContext(), "Elige un semestre", Toast.LENGTH_SHORT).show();
                    break;
            }
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    private void crearSegundoTM() {
        //cargamos los semestres por indices, cuidado al momento de acceder y asignar indices
        String[] array = new String[8];
        for(int i=0;i<8;i++){
            array[i] = db.getArray_asignaturas().get(i).getNombre();
        }
        addItem("Segundo TM",array, R.color.pink, R.drawable.ic_menu_laptop);
    }
    private void crearSegundoTV() {
        String[] array2 = new String[8];
        for(int i=0;i<8;i++){
            array2[i] = db.getArray_asignaturas().get(i+8).getNombre();
        }
        addItem("Segundo TV", array2, R.color.pink, R.drawable.ic_menu_laptop);
    }
    private void crearCuartoTM() {
        String[] array3 = new String[8];
        for(int i=0;i<8;i++){
            array3[i] = db.getArray_asignaturas().get(i+16).getNombre();
        }
        addItem("Cuarto TM", array3, R.color.orange, R.drawable.ic_menu_laptop);
    }
    private void crearCuartoTV() {
        String[] array3 = new String[8];
        for(int i=0;i<8;i++){
            array3[i] = db.getArray_asignaturas().get(i+23).getNombre();
        }
        addItem("Cuarto TV", array3, R.color.orange, R.drawable.ic_menu_laptop);
    }
    private void crearSextoTM() {
        String[] array3 = new String[7];
        for(int i=0;i<7;i++){
            array3[i] = db.getArray_asignaturas().get(i+31).getNombre();
        }
        addItem("Sexto TM", array3, R.color.purple, R.drawable.ic_menu_laptop);
    }
    private void crearSextoTV() {
        String[] array3 = new String[7];
        for(int i=0;i<7;i++){
            array3[i] = db.getArray_asignaturas().get(i+38).getNombre();
        }
        addItem("Sexto TV", array3, R.color.purple, R.drawable.ic_menu_laptop);
    }
    private void crearOctavoTM() {
        String[] array3 = new String[6];
        for(int i=0;i<6;i++){
            array3[i] = db.getArray_asignaturas().get(i+45).getNombre();
        }
        addItem("Octavo TM", array3, R.color.green, R.drawable.ic_menu_laptop);
    }
    private void crearRecurses() {
        String[] array3 = new String[6];
        for(int i=0;i<6;i++){
            array3[i] = db.getArray_asignaturas().get(i+51).getNombre();
        }
        addItem("Recurses", array3, R.color.white, R.drawable.ic_menu_laptop);
    }
    private void crearOptativas() {
        String[] array3 = new String[4];
        for(int i=0;i<4;i++){
            array3[i] = db.getArray_asignaturas().get(i+57).getNombre();
        }
        addItem("Optativas", array3, R.color.yellow, R.drawable.ic_menu_laptop);
    }
}
