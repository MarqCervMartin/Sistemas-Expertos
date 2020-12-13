package com.example.appico;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appico.asignaturasdb.Asignatura;
import com.example.appico.asignaturasdb.Docente;
import com.example.appico.utilidades.DBLocalEstatica;
import com.example.appico.utilidades.Utilidades;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    DBLocalEstatica dbLocal = new DBLocalEstatica();

    TextView info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Generar Horario", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent formulario = new Intent(MainActivity.this, Formulario.class);
                startActivity(formulario);
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        //crear BD
        ConexionSQLiteHelper conexion = new ConexionSQLiteHelper(this, "ico_bd", null, 1);

        iniciarCargaDeDatos(conexion);
        iniciarCargaDeDatosAsignaturas(conexion);
    }

    private void iniciarCargaDeDatosAsignaturas(ConexionSQLiteHelper conexion) {
        SQLiteDatabase db = conexion.getWritableDatabase();
        ContentValues valuesA = new ContentValues();
        for(Asignatura a: dbLocal.getArray_asignaturas()){
            valuesA.put(Utilidades.CAMPO_ID_ASIGNATURA, a.getId());
            valuesA.put(Utilidades.CAMPO_MATRICULA_ASIGNATURA,a.getMatricula());
            valuesA.put(Utilidades.CAMPO_NOMBRE_ASIGNATURA, a.getNombre());
            valuesA.put(Utilidades.CAMPO_CREDITOS_ASIGNATURA, a.getCreditos());
            valuesA.put(Utilidades.CAMPO_TURNO_ASIGNATURA, a.getTurno());
            valuesA.put(Utilidades.CAMPO_DOCENTEID_ASIGNATURA, a.getDocente_id());
            valuesA.put(Utilidades.CAMPO_DIAUNO_ASIGNATURA, a.getDia_uno());
            valuesA.put(Utilidades.CAMPO_HORAINICIODIAUNO_ASIGNATURA, a.getHora_inicio_dia_uno());
            valuesA.put(Utilidades.CAMPO_HORASALIDADIAUNO_ASIGNATURA, a.getHora_salida_dia_uno());
            valuesA.put(Utilidades.CAMPO_DURACIONDIAUNO_ASIGNATURA, a.getDuracion_dia_uno());
            valuesA.put(Utilidades.CAMPO_DIADOS_ASIGNATURA, a.getDia_dos());
            valuesA.put(Utilidades.CAMPO_HORAINICIODIADOS_ASIGNATURA, a.getHora_inicio_dia_dos());
            valuesA.put(Utilidades.CAMPO_HORASALIDADIADOS_ASIGNATURA, a.getHora_salida_dia_dos());
            valuesA.put(Utilidades.CAMPO_DURACIONDIADOS_ASIGNATURA, a.getDuracion_dia_dos());
            Long idResultanteAsig = db.insert(Utilidades.TABLA_ASIGNATURA, Utilidades.CAMPO_ID_ASIGNATURA, valuesA);
            Toast.makeText(getApplicationContext(),"Datos cargados: "+idResultanteAsig, Toast.LENGTH_SHORT).show();
        }
        db.close();
    }

    private void iniciarCargaDeDatos(ConexionSQLiteHelper conn) {
        SQLiteDatabase db = conn.getWritableDatabase();
        ContentValues values = new ContentValues();
        ///llenar la BD
        for(Docente d: dbLocal.getArray_docentes()){
            values.put(Utilidades.CAMPO_ID_DOCENTE, d.getId());
            values.put(Utilidades.CAMPO_NOMBRE_DOCENTE, d.getNombre());
            values.put(Utilidades.CAMPO_PATERNO_DOCENTE, d.getPaterno());
            values.put(Utilidades.CAMPO_MATERNO_DOCENTE, d.getMaterno());
            values.put(Utilidades.CAMPO_GRADO_DOCENTE, d.getGrado());
            Long idResultante = db.insert(Utilidades.TABLA_DOCENTE, Utilidades.CAMPO_ID_DOCENTE, values);
            //Toast.makeText(getApplicationContext(),"Id registro: "+idResultante, Toast.LENGTH_SHORT).show();
        }

        db.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}