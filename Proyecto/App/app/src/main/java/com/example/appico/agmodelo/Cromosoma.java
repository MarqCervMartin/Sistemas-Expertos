package com.example.appico.agmodelo;

import java.util.ArrayList;

public class Cromosoma {
    ArrayList<Materia> conjetura;
    int aptitud;

    public Cromosoma(ArrayList<Materia> conjetura, int aptitud) {
        this.conjetura = conjetura;
        this.aptitud = aptitud;
    }

    public ArrayList<Materia> getConjetura() {
        return conjetura;
    }

    public void setConjetura(ArrayList<Materia> conjetura) {
        this.conjetura = conjetura;
    }

    public int getAptitud() {
        return aptitud;
    }

    public void setAptitud(int aptitud) {
        this.aptitud = aptitud;
    }
}
