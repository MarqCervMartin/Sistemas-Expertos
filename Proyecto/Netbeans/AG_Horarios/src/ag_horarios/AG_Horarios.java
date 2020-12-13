/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ag_horarios;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author liraz
 */
public class AG_Horarios {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException, IOException {
        // TODO code application logic here
        ArrayList<Materia> SRE;
        ArrayList<Materia> MejorPadre;
        ArrayList<Materia> Niño;
        boolean Factible = false;
        float AptitudDeNiño = 0;
        Funciones F = new Funciones();
        SRE = F.DiccionarioGen();
        /*for(Materia Obj : SRE){
            System.out.println(Obj.toString());
        }*/
        MejorPadre = F.generar_padre(8, SRE);
        System.out.println("\n\n");
        System.out.println("Padre");
        for(Materia Obj : MejorPadre){
            System.out.println(Obj.toString());
        }
        float MejorAptitud = F.aptitud(MejorPadre);
        System.out.println("Aptitud de Padre: " + MejorAptitud);
        int Reps = 0;
        while(true){
            Reps++;
            Niño = F.Mutar(MejorPadre);
            AptitudDeNiño = F.aptitud(Niño);
            Factible = F.Factibilidad(Niño);
            if(Reps == 10000){
                break;
            }
            if(Factible == false){
                continue;
            }
            if(AptitudDeNiño > MejorAptitud){
                continue;
            }
            if(AptitudDeNiño <= 3){
                break;
            }
            MejorAptitud = AptitudDeNiño;
            MejorPadre = Niño;
        }
        System.out.println("\n\n");
        System.out.println("Mejor Horario en " + Reps + " Iteraciones");
        for(Materia Obj : Niño){
            System.out.println(Obj.toString());
        }
        
        System.out.println("Aptitud : " + AptitudDeNiño);
        F.MostrarConjetura(Niño);
        
        if(Reps == 10000){
            System.out.println("ADVERTENCIA: El ESTE  HORARIO PUEDE TENER MATERIAS CRUZADAS, INTENTA METER MENOS MATERIAS.");
        }
        if(F.Factibilidad(Niño) == true){
            System.out.println("EN ESTE HORARIO NO SE CRUZAN MATERIAS");
        }else{
            System.out.println("EN ESTE HORARIO SE CRUZAN MATERIAS");
        }
    }
}
