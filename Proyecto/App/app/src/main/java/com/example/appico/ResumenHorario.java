package com.example.appico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResumenHorario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen_horario);

        TextView mostrar = (TextView) findViewById(R.id.HorarioTxt);
        Intent intent = this.getIntent();
        Bundle extra = intent.getExtras();
        String contenido = extra.getString("Horario");
        mostrar.setText(contenido);
    }
}