/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ag_horarios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Math.random;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
 
        
    public ArrayList generar_padre(int Num_Materias, ArrayList<Materia> Diccionario){
        ArrayList<Materia> M = new ArrayList<>();
        int x = random.nextInt(Diccionario.size());
        for (int i = 0; i < Num_Materias; i++) {
            while(M.contains(Diccionario.get(x))) {
                x = random.nextInt(Diccionario.size());
            }
            M.add(Diccionario.get(x));
        }
        return M;
    }
   
   public ArrayList<Materia> DiccionarioGen() throws IOException{
       BufferedReader br = null;
       ArrayList<Materia> Diccionario = new ArrayList();
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
        Date Conv2;
        Date Conv1;
        Conv2 = hora.parse(H2);
        Conv1 = hora.parse(H1);
        long Dif = Conv2.getTime() - Conv1.getTime();
        System.out.println("Diferencia es:");
        float Diferencia = (float) Dif/((1000*60))/60;
        System.out.println(Diferencia + " Hrs.");
        return Diferencia;
   }
    
}
