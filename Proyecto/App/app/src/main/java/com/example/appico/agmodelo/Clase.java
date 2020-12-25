package com.example.appico.agmodelo;

import java.text.ParseException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Clase implements Comparable<Clase>{
    Funciones F = new Funciones();
    String Dia;
    String Horain;
    String Duracion;
    int horaS;

    public Clase(String Dia, String Horain, String Duracion) {
        this.Dia = Dia;
        this.Horain = Horain;
        this.Duracion = Duracion;
        this.horaS = Integer.parseInt(Horain.split(":")[0]);
    }

    public String toString() {
        try {
            return "Dia = " + Dia + ", Horario = " + Horain + " - " + F.Hora_Final(Horain, Duracion);
        } catch (ParseException ex) {
            Logger.getLogger(Clase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public int compareTo(Clase o) {
        if(horaS <=o.horaS){
            return -1;
        }if(horaS > o.horaS){
            return 1;
        }
        return 0;
    }
}
