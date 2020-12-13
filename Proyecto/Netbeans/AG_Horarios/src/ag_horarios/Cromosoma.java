/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ag_horarios;

import java.util.ArrayList;

/**
 *
 * @author liraz
 */

public class Cromosoma{

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