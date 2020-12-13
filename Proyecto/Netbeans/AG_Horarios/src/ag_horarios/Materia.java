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
public class Materia {
    String UA;
    ArrayList<Clase> Clases = new ArrayList();

    public Materia() {
        
    }
    public Materia(String UA, String S_Clases) {
        this.UA = UA;
        String[] ArryClasses = S_Clases.split(" ");
        if(ArryClasses.length > 3){
            Clase C = new Clase(ArryClasses[0], ArryClasses[1] , ArryClasses[2]);
            Clases.add(C);
            Clase C2 = new Clase(ArryClasses[3], ArryClasses[4] , ArryClasses[5]);
            Clases.add(C2);
        }else{
        Clase C = new Clase(ArryClasses[0], ArryClasses[1] , ArryClasses[2]);
        Clases.add(C);
        }
    }

    @Override
    public String toString() {
        return "N_Materias | " + "UA = " + UA + " Clases = " + Clases.toString();
    }

    void add(Materia M) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
