/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmeans3d;

import java.util.Random;
import org.jzy3d.analysis.AbstractAnalysis;
import org.jzy3d.analysis.AnalysisLauncher;
import org.jzy3d.chart.factories.AWTChartComponentFactory;
import org.jzy3d.colors.Color;
import org.jzy3d.maths.Coord3d;
import org.jzy3d.plot3d.primitives.Scatter;
import org.jzy3d.plot3d.rendering.canvas.Quality;

/**
 *
 * @author martin
 */
public class KMeans3D extends AbstractAnalysis{
    private int nPuntos;

    public int getnPuntos() {
        return nPuntos;
    }

    public void setnPuntos(int nPuntos) {
        this.nPuntos = nPuntos;
    }
    
    public KMeans3D(int n){
        this.nPuntos = n;
    }
    public KMeans3D(){
        
    }
    
    public void Open(int n) throws Exception{
        AnalysisLauncher.open(new KMeans3D(n));
    }
    @Override
    public void init() {
        int size = nPuntos;
        float x;
        float y;
        float z;
        float a;

        Coord3d[] points = new Coord3d[size];
        Color[] colors = new Color[size];

        Random r = new Random();
        r.setSeed(0);

        for (int i = 0; i < size; i++) {
            x = r.nextFloat() - 0.5f;
            y = r.nextFloat() - 0.5f;
            z = r.nextFloat() - 0.5f;
            points[i] = new Coord3d(x, y, z);
            a = 1.0f;
            colors[i] = new Color(0, 255, 0, a);
        }
        
        Scatter scatter = new Scatter(points, colors);
        //Scatter scatte = new Scatter();
        scatter.setWidth(5);
        scatter.setBoundingBoxDisplayed(true);
        scatter.updateBounds();
        //scatter.applyGeometryTransform(Transform transfor = new Transform());
        chart = AWTChartComponentFactory.chart(Quality.Fastest, "newt");
        chart.getScene().add(scatter);
        
    }
}
