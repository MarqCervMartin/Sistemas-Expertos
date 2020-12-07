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
        ArrayList<Materia> Conjetura;
        Funciones F = new Funciones();
         SRE = F.DiccionarioGen();
         for(Materia Obj : SRE){
             System.out.println(Obj.toString());
         }
         Conjetura = F.generar_padre(7, SRE);
         System.out.println("\n\n");
         System.out.println("Padre");
         for(Materia Obj : Conjetura){
             System.out.println(Obj.toString());
         }
    }
}
