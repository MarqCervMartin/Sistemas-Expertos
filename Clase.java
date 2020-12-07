/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ag_horarios;

import java.util.Calendar;
/**
 *
 * @author liraz
 */
public class Clase {
    String Dia;
    String Horain; 
    String Duracion;

    public Clase(String Dia, String Horain, String Duracion) {
        this.Dia = Dia;
        this.Horain = Horain;
        this.Duracion = Duracion;
    }

    public String toString() {
        return "Dia = " + Dia + ", Horain = " + Horain + ", Duracion = " + Duracion;
    }
    
}
