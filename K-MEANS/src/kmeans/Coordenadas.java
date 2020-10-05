/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmeans;

import java.awt.Color;

/**
 *
 * @author martin
 */
public class Coordenadas {
    private int x,y,nC;
    private Color c;
    
    public Coordenadas(int x, int y, Color c, int nC){
        this.x = x;
        this.y = y;
        this.c = c;
        this.nC = nC;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getC() {
        return c;
    }

    public void setC(Color c) {
        this.c = c;
    }

    public int getnC() {
        return nC;
    }

    public void setnC(int nC) {
        this.nC = nC;
    }

    @Override
    public String toString() {
        return "Coordenadas{" + "x=" + x + ", y=" + y + ", nC=" + nC + ", c=" + c + '}';
    }


    
    
}
