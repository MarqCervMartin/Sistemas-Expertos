/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmeans;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author martin
 */
public class KMeans {
    
    private ArrayList<Coordenadas> clases = new ArrayList<>();
    private ArrayList<Coordenadas> atractores = new ArrayList<>();
    private ArrayList<Float> arrayDistancias = new ArrayList<>();
    private ArrayList<Coordenadas> centroides = new ArrayList<>();

    private int nPoints, nAtractores;

    public ArrayList<Coordenadas> getClases() {
        return clases;
    }

    public void setClases(ArrayList<Coordenadas> clases) {
        this.clases = clases;
    }

    public int getnPoints() {
        return nPoints;
    }

    public void setnPoints(int nPoints) {
        this.nPoints = nPoints;
    }

    public int getnAtractores() {
        return nAtractores;
    }

    public void setnAtractores(int nAtractores) {
        this.nAtractores = nAtractores;
    }

    public ArrayList<Coordenadas> getAtractores() {
        return atractores;
    }

    public void setAtractores(ArrayList<Coordenadas> atractores) {
        this.atractores = atractores;
    }

    public ArrayList<Float> getArrayDistancias() {
        return arrayDistancias;
    }

    public void setArrayDistancias(ArrayList<Float> arrayDistancias) {
        this.arrayDistancias = arrayDistancias;
    }

    public ArrayList<Coordenadas> getCentroides() {
        return centroides;
    }

    public void setCentroides(ArrayList<Coordenadas> centroides) {
        this.centroides = centroides;
    }
    
    
    
    
    public void generarPuntos(){
        Random r = new Random();
        int Xaux = 0;
        int Yaux = 0;
        //tamaño de panel x y y
        for(int i=0; i<getnPoints();i++){
            Xaux = r.nextInt(624);
            Yaux = r.nextInt(500);
            clases.add( new Coordenadas( Xaux, Yaux, Color.BLACK, -1));
            //System.out.println( clases.get(i));
        }
    }
    public void claseColor(Color c){
        
    }
    public void añadirAtractor(int x, int y, Color c, int nC){
        atractores.add(new Coordenadas(x, y, c, nC));
    }
    
    public float euclidiana(int x1, int y1, int x2, int y2){
        float d;
        return d =(float) Math.sqrt( Math.pow(x2-x1,2)+ Math.pow(y2-y1,2));
    }
    public void centroides(){
        
    }
    public void clear(){
        clases.clear();
        atractores.clear();
        arrayDistancias.clear();
        centroides.clear();
        System.out.println("Memoria Limpiada!");
    }
}
