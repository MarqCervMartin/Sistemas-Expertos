/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knn;

import java.util.ArrayList;
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
        
    
    private int n;
    private ArrayList<CoordenadasClases> clases = new ArrayList<>();
    
    
    //Getters and setters
    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
    
    public ArrayList<CoordenadasClases> getClases() {
        return clases;
    }

    public void setClases(ArrayList<CoordenadasClases> clases) {
        this.clases = clases;
    }
    
    
    
    public void generarClases(){
        Random r = new Random();
        //tamaño de panel x y y
        for(int i=0; i<getN();i++){
            clases.add( new CoordenadasClases( r.nextInt(421), r.nextInt(388)));
            System.out.println( clases.get(i));
        }
    }
   
}
