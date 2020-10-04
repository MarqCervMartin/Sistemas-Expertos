/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author martin
 * Hola:
    Realizar programa para clasificar un punto (x,y) dado por el usuario usando el algoritmo KNN.
    El usuario indica el número de k vecinos, la cantidad de clases, de puntos y puede seleccionar 
    entre una generación aleatoria o manual del problema inicial.
    Programa gráfico, que incluye el plano para visualizar fácilmente la clasificación, uso de colores,
    botones y opciones que permitan manipular el programa fácilmente, así como intentar varias veces 
    el proceso de clasificación.
    Por supuesto el plagio es gravemente penalizado, se revisará y pedirá la explicación de código fuente.
    Lenguajes c, c++, c#, java.
    Saludos.

 */
public class KNN {

    /**
     * @param args the command line arguments
     */
    //public static void main(String[] args) {
        // TODO code application logic here
        
    
    private int n, ncolores;
    private ArrayList<CoordenadasClases> clases = new ArrayList<>();
    private ArrayList<Float> distancias = new ArrayList<>();
    private int XNeighbor,YNeighbor;

    public int getXNeighbor() {
        return XNeighbor;
    }

    public void setXNeighbor(int XNeighbor) {
        this.XNeighbor = XNeighbor;
    }

    public int getYNeighbor() {
        return YNeighbor;
    }

    public void setYNeighbor(int YNeighbor) {
        this.YNeighbor = YNeighbor;
    }
    
   
    //Getters and setters
    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getNcolores() {
        return ncolores;
    }

    public void setNcolores(int ncolores) {
        this.ncolores = ncolores;
    }
    
    public ArrayList<CoordenadasClases> getClases() {
        return clases;
    }

    public void setClases(ArrayList<CoordenadasClases> clases) {
        this.clases = clases;
    }

    public ArrayList<Float> getDistancias() {
        return distancias;
    }

    public void setDistancias(ArrayList<Float> distancias) {
        this.distancias = distancias;
    }


    
    
    public void generarClases(){
        Random r = new Random();
        int Xaux = 0;
        int Yaux = 0;
        //tamaño de panel x y y
        for(int i=0; i<getN();i++){
            Xaux = r.nextInt(680);
            Yaux = r.nextInt(545);
            clases.add( new CoordenadasClases( Xaux, Yaux, -1, distancia(Xaux,Yaux)));
            //System.out.println( clases.get(i));
        }
    }
    public float distancia(int x, int y){
        //Map <String, List<String>> map = new HashMap<>();
        //ArrayList<Integer> indices = new ArrayList<>();
        //map.put(0, "France");
        //map.put(1, "Spain");
        //map.put(2, "France");
        //for(CoordenadasClases act : clases){
            //distMenor(act);
        float d;
        return d =(float) Math.sqrt( Math.pow(getXNeighbor()-x,2)+ Math.pow(getYNeighbor()- y,2));
            //------------------------>distancias.add(d);
            //indices.add(act.getC());
            //map.put(""+act.getC(), distancias);
        //}
        //System.out.println("Antes del Sorting: "+ distancias); 
        //------------------------>Collections.sort(distancias);
        //System.out.println("Despues del Sorting: "+ distancias); 
        //System.out.println("One index:"+distancias.get(1));
        
        
    }
    public int[] imprimirTabla(){
        //copia de distancias
        ArrayList<Float> aux = new ArrayList<>();
        for(CoordenadasClases act : clases){
            distancias.add(act.getDistance());
            aux.add(act.getDistance());
        }
        //se ordena
        Collections.sort(distancias);
        //obtenemos indices
        int total = distancias.size();
        int[] indexes = new int[total];
        System.out.print("Indices: ");
        for (int i = 0; i < distancias.size(); i++){
            indexes[i] = aux.indexOf(distancias.get(i));
            System.out.print(" ,"+indexes[i]);
        }
        System.out.println("");
        System.out.println("Despues del Sorting: "+ distancias);
        return indexes;
        
    }

   
}
