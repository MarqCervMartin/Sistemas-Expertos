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

public class Funciones {
    
    ArrayList GenSet; 
  
    String ST = "Algebra Lineal, Isaac,TM,Martes, 9:00, 2, Viernes, 2, 7:00\n" +
                "Algebra Lineal, Ku moo, TV, Martes, 13:00, 2, Jueves, 13:00, 2\n" +
                "Algoritmos Geneticos, Asdrubal, IHM, Miercoles, 8:00, 3\n" +
                "Analisis y Diseño de Redes, Nadia, TM, Martes, 11:00, 2, Viernes, 9:00, 2\n" +
                "Analisis y Diseño de Redes, Hazem, TV, Miercoles, 17:00, 2, Viernes, 15:00, 2\n" +
                "Arquitectura de Computadoras, Alejandro, TM, Martes, 9:00, 2, Jueves, 7:00, 2\n" +
                "Arquitectura de Computadoras, Jorge, TV, Martes, 15:00, 2, Jueves, 15:00, 2\n" +
                "Calculo ii, Rafael, R1, Martes, 11:00,2\n" +
                "Calculo ii, Israel, TV, Lunes, 13:00, 2 \n" +
                "Calculo ii, Jose, TV, Martes, 15:00, 2\n" +
                "Fundamentos de Robotica, Diego, TM, Sabado, 7:00, 3\n" +
                "Fundamentos de Robotica, Diego, TV, Viernes, 7:00, 3\n" +
                "Programacion Paralela y Distribuida, Manuel, TM, Lunes, 11:00, 2, Jueves, 12:00, 2\n" +
                "Programacion Paralela y Distribuida, Alejandro, TV, Viernes, 17:00, 2, Jueves, 17:00, 2\n" +
                "Sistemas Digitales, Jorge, TM, Lunes, 8:00, 3, Viernes, 11:00, 2\n" +
                "Sistemas Digitales, Valentin, TV, Lunes, 13:00, 3, Jueves, 13:00, 2";
 
    String[] P = ST.split("\n");
        
    public ArrayList generar_padre(int Num_Materias){
        ArrayList<N_Materias> M = new ArrayList<>();
        SeparaDatos(P[6]);
        return M;
    }
    
    public String ToNewString(String[] A,int Imin,int Imax){
        String Res = "";
        for (int i = Imin; i <Imax; i++) {
            Res = Res + A[i]+ ","; 
        }
        return Res.substring(0, Res.length()-1);
    }
    
   public N_Materias SeparaDatos(String Pis){
       System.out.println(Pis);
       N_Materias NM = new N_Materias();
       ArrayList<Clase> C = new ArrayList();
       String Pi[] = Pis.split(", ");
       String Datos = ToNewString(Pi, 0, 3);
       String horarios = ToNewString(Pi, 3, Pi.length);
       System.out.println(Datos);
       System.out.println(horarios);
       String[] Adatos = Datos.split(",");
       String[] Ahorarios = horarios.split(",");
       NM.UA = Adatos[0];
       NM.Profesor = Adatos[2];
       for (int i = 0; i < Ahorarios.length/3; i++) {
           if(i == 0 || i == 3){
                C.add(new Clase(Ahorarios[i], Ahorarios[i + 1], Integer.parseInt(Ahorarios[i + 2])));
           }
           i++;
       }
       NM.Clases = C;
       System.out.println(C.toString());
       return NM;
   }
    
}
