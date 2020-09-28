/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knn;

/**
 *
 * @author martin
 */
public class CoordenadasClases {
    private int x,y,c;
    private float distance;
    
    //COnstructor
    public CoordenadasClases(int x, int y, int c, float d){
        this.x = x;
        this.y = y;
        this.c = c;
        this.distance = d;
    }
    //Setters and getters
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

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "CoordenadasClases{" + "x=" + x + ", y=" + y + ", c=" + c + ", distance=" + distance + '}';
    }

    
    
    
}
