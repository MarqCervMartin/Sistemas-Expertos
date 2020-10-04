/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmeans;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author martin
 */
public class KMeans {
    
    private ArrayList<Coordenadas> clases = new ArrayList<>();
    private int nPoints;

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
    
    public void generarClases(){
        Random r = new Random();
        int Xaux = 0;
        int Yaux = 0;
        //tamaño de panel x y y
        for(int i=0; i<getnPoints();i++){
            Xaux = r.nextInt(624);
            Yaux = r.nextInt(500);
            clases.add( new Coordenadas( Xaux, Yaux, -1));
            //System.out.println( clases.get(i));
        }
    
    }
}
