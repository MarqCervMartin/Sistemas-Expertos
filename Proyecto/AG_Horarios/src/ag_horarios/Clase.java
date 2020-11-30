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
    int Duracion;

    public Clase(String Dia, String Horain, int Duracion) {
        this.Dia = Dia;
        this.Horain = Horain;
        this.Duracion = Duracion;
    }

    @Override
    public String toString() {
        return "Clase{" + "Dia=" + Dia + ", Horain=" + Horain + ", Duracion=" + Duracion + '}';
    }
    
}
