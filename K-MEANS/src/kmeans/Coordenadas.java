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
    private float x,y;
    private int nC;
    private Color c;
    
    public Coordenadas(float x, float y, Color c, int nC){
        this.x = x;
        this.y = y;
        this.c = c;
        this.nC = nC;
    }

    public int getX() {
        return (int) x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public int getY() {
        return (int) y;
    }

    public void setY(float y) {
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
