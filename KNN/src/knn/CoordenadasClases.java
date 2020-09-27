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
    private int x,y;
    
    //COnstructor
    public CoordenadasClases(int x, int y){
        this.x = x;
        this.y = y;
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

    @Override
    public String toString() {
        return "KNN{" + "x=" + x + ", y=" + y + '}';
    }
}
