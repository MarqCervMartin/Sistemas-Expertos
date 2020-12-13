/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ag_horarios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Random;
import java.util.Date;

/**
 *
 * @author liraz
 */

public class Funciones {
    
    ArrayList GenSet; 
    String SEPARATOR = ",";
    String QUOTE = "\"";
    Random random = new Random();
    ArrayList<Materia> Diccionario = new ArrayList();
 
        
    public ArrayList generar_padre(int Num_Materias, ArrayList<Materia> Diccionario){        
        ArrayList<Materia> M = new ArrayList<>();
        ArrayList<String> S = new ArrayList<>();
        int x = random.nextInt(Diccionario.size());
        for (int i = 0; i < Num_Materias; i++) {
            while(S.contains(Diccionario.get(x).UA)) {
                x = random.nextInt(Diccionario.size());
            }
            M.add(Diccionario.get(x));
            S.add(Diccionario.get(x).UA);
        }
        return M;
    }
   
   public ArrayList<Materia> DiccionarioGen() throws IOException{
       BufferedReader br = null;
       Diccionario = new ArrayList();
      try {
         br = new BufferedReader(new FileReader("src\\ag_horarios\\Data.csv"));
         String line = br.readLine();
         while (null!=line) {
            String [] fields = line.split(SEPARATOR);
            //System.out.println(Arrays.toString(fields));
            fields = removeTrailingQuotes(fields);
            Diccionario.add(new Materia(fields[0],fields[1]));
            //System.out.println(Arrays.toString(fields));
            line = br.readLine();
         }
      } catch (Exception e) {
          System.out.println(e);
      }finally {
         if (null!=br) {
            br.close();
         }
      }
      return Diccionario;
   }
   
   public String[] removeTrailingQuotes(String[] fields) {
      String result[] = new String[fields.length];
      for (int i=0;i<result.length;i++){
         result[i] = fields[i].replaceAll("^"+QUOTE, "").replaceAll(QUOTE+"$", "");
      }
      return result;
   }
   
   public float DiferenciaDeHoras(String H1,String H2) throws ParseException{
        DateFormat hora = new SimpleDateFormat("HH:mm");
        Date Conv1 = hora.parse(H1);
        Date Conv2 = hora.parse(H2);
        long Dif = Conv2.getTime() - Conv1.getTime();
        float Diferencia = (float) Dif/(1000*60)/60;
        return Math.abs(Diferencia);
   }
      public String Hora_Final(String H1,String H2) throws ParseException{
        int h2 = Integer.parseInt(H2);
        DateFormat hora = new SimpleDateFormat("HH:mm");
        Date Conv1;
        Conv1 = hora.parse(H1);
        hora.getCalendar().setTime(Conv1);
        hora.getCalendar().add(Calendar.HOUR, h2);
        return hora.format(hora.getCalendar().getTime())+"";
   }   
      public float aptitud(ArrayList<Materia> AM) throws ParseException{
          float Lu,Ma,Mi,Ju,Vi,Sa;
          ArrayList<Clase> ClasesLunes = new ArrayList();
          ArrayList<Clase> ClasesMartes = new ArrayList();
          ArrayList<Clase> ClasesMiercoles = new ArrayList();
          ArrayList<Clase> ClasesJueves = new ArrayList();
          ArrayList<Clase> ClasesViernes = new ArrayList();
          ArrayList<Clase> ClasesSabado = new ArrayList();
          for (Materia Mat : AM) {
              for (Clase C : Mat.Clases) {
                  switch(C.Dia){
                      case "Lunes":
                          ClasesLunes.add(C);
                          break;
                      case "Martes":
                          ClasesMartes.add(C);
                          break;
                      case "Miercoles":
                          ClasesMiercoles.add(C);
                          break;
                      case "Jueves":
                          ClasesJueves.add(C);
                          break;
                      case "Viernes":
                          ClasesViernes.add(C);
                          break;
                      case "Sabado":
                          ClasesSabado.add(C);
                          break;
                  }
              }
          }
            
            Collections.sort(ClasesLunes);
            Lu = ObtenerHorasM_por_dia(ClasesLunes);
            Collections.sort(ClasesMartes);
            Ma = ObtenerHorasM_por_dia(ClasesMartes);
            Collections.sort(ClasesMiercoles);
            Mi = ObtenerHorasM_por_dia(ClasesMiercoles);
            Collections.sort(ClasesJueves);
            Ju = ObtenerHorasM_por_dia(ClasesJueves);
            Collections.sort(ClasesViernes);
            Vi = ObtenerHorasM_por_dia(ClasesViernes);
            Collections.sort(ClasesSabado);
            Sa = ObtenerHorasM_por_dia(ClasesSabado);
            
            return Lu + Ma + Mi + Ju + Vi + Sa;
        }
      
    public float ObtenerHorasM_por_dia(ArrayList<Clase> Dia) throws ParseException{
        if(Dia.isEmpty() || Dia.size() == 1){
            return 0;
        }
        float Hors = 0;
        for (int i = 0; i < Dia.size() - 1; i++) {
            Hors = Hors + DiferenciaDeHoras(Dia.get(i + 1).Horain,Hora_Final(Dia.get(i).Horain, Dia.get(i).Duracion));
        }
        return Hors;
    }
    
    public ArrayList Mutar(ArrayList<Materia> Padre){
        ArrayList<String> Materias = new ArrayList<>();
        int indice = random.nextInt(Diccionario.size());
        int indiceEnPadre = random.nextInt(Padre.size());
        Padre.remove(indiceEnPadre);
        for (Materia M : Padre) {
            Materias.add(M.UA);
        }
        while(Materias.contains(Diccionario.get(indice).UA)){
            indice = random.nextInt(Diccionario.size());
        }
        Materia MatNueva = Diccionario.get(indice);
        Padre.add(indiceEnPadre,MatNueva);
        ArrayList<Materia> niño = new ArrayList<>();
        niño.addAll(Padre);
        return niño;
    }
    public boolean Factibilidad(ArrayList<Materia> Conjetura) throws ParseException{
        boolean Factible = true;
        
        ArrayList<Clase> ClasesLunes = new ArrayList();
        ArrayList<Clase> ClasesMartes = new ArrayList();
        ArrayList<Clase> ClasesMiercoles = new ArrayList();
        ArrayList<Clase> ClasesJueves = new ArrayList();
        ArrayList<Clase> ClasesViernes = new ArrayList();
        ArrayList<Clase> ClasesSabado = new ArrayList();
        for (Materia Mat : Conjetura) {
            for (Clase C : Mat.Clases) {
                switch(C.Dia){
                    case "Lunes":
                        ClasesLunes.add(C);
                        break;
                    case "Martes":
                        ClasesMartes.add(C);
                        break;
                    case "Miercoles":
                        ClasesMiercoles.add(C);
                        break;
                    case "Jueves":
                        ClasesJueves.add(C);
                        break;
                    case "Viernes":
                        ClasesViernes.add(C);
                        break;
                    case "Sabado":
                        ClasesSabado.add(C);
                        break;
                }
            }
        }
          Collections.sort(ClasesLunes);
          Collections.sort(ClasesMartes);
          Collections.sort(ClasesMiercoles);
          Collections.sort(ClasesJueves);
          Collections.sort(ClasesViernes);
          Collections.sort(ClasesSabado);
         if(verificar(ClasesLunes) == true || verificar(ClasesMartes) == true || verificar(ClasesMiercoles) == true || verificar(ClasesJueves) == true || verificar(ClasesViernes) == true || verificar(ClasesSabado) == true){
                Factible = false;
            }else{
                Factible = true;
         }
        return Factible;
    }
    
    public boolean verificar(ArrayList<Clase> ClasesDia) throws ParseException{
        boolean SeCruzan = false;
        
        for (int i = 0; i < ClasesDia.size() - 1; i++) {
            float DuracionSegun = DiferenciaDeHoras(ClasesDia.get(i).Horain,ClasesDia.get(i + 1).Horain);
            if(DuracionSegun < Integer.parseInt(ClasesDia.get(i).Duracion) || (ClasesDia.get(i).Horain.equals(ClasesDia.get(i + 1).Horain)) == true){
                //SeCruzan = true;
                System.out.println(ClasesDia.get(i).Horain +"<="+ ClasesDia.get(i + 1).Horain);
                return SeCruzan = true;
            }
        }
        return SeCruzan;
    }
    
    
    public void MostrarConjetura(ArrayList<Materia> Conjetura) throws ParseException{
        float Lu,Ma,Mi,Ju,Vi,Sa;
        ArrayList<Clase> ClasesLunes = new ArrayList();
        ArrayList<Clase> ClasesMartes = new ArrayList();
        ArrayList<Clase> ClasesMiercoles = new ArrayList();
        ArrayList<Clase> ClasesJueves = new ArrayList();
        ArrayList<Clase> ClasesViernes = new ArrayList();
        ArrayList<Clase> ClasesSabado = new ArrayList();
        ArrayList<String> SClasesLunes = new ArrayList();
        ArrayList<String> SClasesMartes = new ArrayList();
        ArrayList<String> SClasesMiercoles = new ArrayList();
        ArrayList<String> SClasesJueves = new ArrayList();
        ArrayList<String> SClasesViernes = new ArrayList();
        ArrayList<String> SClasesSabado = new ArrayList();
        for (Materia Mat : Conjetura) {
            for (Clase C : Mat.Clases) {
                switch(C.Dia){
                    case "Lunes":
                        ClasesLunes.add(C);
                        SClasesLunes.add(Mat.UA);
                        break;
                    case "Martes":
                        ClasesMartes.add(C);
                        SClasesMartes.add(Mat.UA);
                        break;
                    case "Miercoles":
                        ClasesMiercoles.add(C);
                        SClasesMiercoles.add(Mat.UA);
                        break;
                    case "Jueves":
                        ClasesJueves.add(C);
                        SClasesJueves.add(Mat.UA);
                        break;
                    case "Viernes":
                        ClasesViernes.add(C);
                        SClasesViernes.add(Mat.UA);
                        break;
                    case "Sabado":
                        ClasesSabado.add(C);
                        SClasesSabado.add(Mat.UA);
                        break;
                }
            }
        }

          Collections.sort(ClasesLunes);
          Lu = ObtenerHorasM_por_dia(ClasesLunes);
          Collections.sort(ClasesMartes);
          Ma = ObtenerHorasM_por_dia(ClasesMartes);
          Collections.sort(ClasesMiercoles);
          Mi = ObtenerHorasM_por_dia(ClasesMiercoles);
          Collections.sort(ClasesJueves);
          Ju = ObtenerHorasM_por_dia(ClasesJueves);
          Collections.sort(ClasesViernes);
          Vi = ObtenerHorasM_por_dia(ClasesViernes);
          Collections.sort(ClasesSabado);
          Sa = ObtenerHorasM_por_dia(ClasesSabado);


          System.out.println("\n");
          System.out.println(SClasesLunes.toString());
          System.out.println(ClasesLunes.toString());
          System.out.println("horas muertas: "+ Lu);
          System.out.println("\n");


          System.out.println(SClasesMartes.toString());
          System.out.println(ClasesMartes.toString());
          System.out.println("horas muertas: "+ Ma);
          System.out.println("\n");


          System.out.println(SClasesMiercoles.toString());
          System.out.println(ClasesMiercoles.toString());
          System.out.println("horas muertas: "+ Mi);
          System.out.println("\n");


          System.out.println(SClasesJueves.toString());
          System.out.println(ClasesJueves.toString());
          System.out.println("horas muertas: "+ Ju);
          System.out.println("\n");


          System.out.println(SClasesViernes.toString());
          System.out.println(ClasesViernes.toString());
          System.out.println("horas muertas: "+ Vi);
          System.out.println("\n");


          System.out.println(SClasesSabado.toString());
          System.out.println(ClasesSabado.toString());
          System.out.println("horas muertas: "+ Sa);
          System.out.println("\n");
    }
}
