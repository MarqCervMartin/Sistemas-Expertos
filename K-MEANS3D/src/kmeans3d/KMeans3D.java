/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmeans3d;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.JOptionPane;
import org.apache.commons.lang3.ArrayUtils;
import org.jzy3d.analysis.AbstractAnalysis;
import org.jzy3d.analysis.AnalysisLauncher;
import org.jzy3d.chart.Chart;
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
    private int nPuntos, nAtractores;
    private Scatter scatter = new Scatter();
    Coord3d[] points;
    Coord3d[] atractors;
    Color[] colors;
    Color[] colorsAtractors;
    //---------------------------------->Getters and setters
    public int getnPuntos() {
        return nPuntos;
    }

    public void setnPuntos(int nPuntos) {
        this.nPuntos = nPuntos;
    }

    public int getnAtractores() {
        return nAtractores;
    }

    public void setnAtractores(int nAtractores) {
        this.nAtractores = nAtractores;
    }

    public Scatter getScatter() {
        return scatter;
    }

    public void setScatter(Scatter scatter) {
        this.scatter = scatter;
    }

    public Coord3d[] getPoints() {
        return points;
    }

    public void setPoints(Coord3d[] points) {
        this.points = points;
    }

    public Coord3d[] getAtractors() {
        return atractors;
    }

    public void setAtractors(Coord3d[] atractors) {
        this.atractors = atractors;
    }
    

    public Color[] getColors() {
        return colors;
    }

    public void setColors(Color[] colors) {
        this.colors = colors;
    }



    
    
    //Doble constructor
    public KMeans3D(int n, int atrac){
        this.nPuntos = n;
        this.nAtractores = atrac;
    }
    public KMeans3D(){
        
    }
    
    public void generar(int n, int atrac) throws Exception{
        AnalysisLauncher.open(new KMeans3D(n, atrac));
    }
    @Override
    public void init() {
        //creamos las tres coordenadas, tipo flotante
        float x;
        float y;
        float z;
        //definimos los arraysCoord3D y colorArrays
        points = new Coord3d[nPuntos];
        colors = new Color[nPuntos];
        
        atractors = new Coord3d[nAtractores];
        colorsAtractors = new Color[nAtractores];

        Random r = new Random();
        //llenamos Coor3D de puntos y colores, en un inicio son negros
        for (int i = 0; i < nPuntos; i++) {
            x = r.nextFloat() - 0.5f;
            y = r.nextFloat() - 0.5f;
            z = r.nextFloat() - 0.5f;
            points[i] = new Coord3d(x, y, z);
            colors[i] = new Color(0, 0, 0);
        }
        //llenamos Coord3D de atractores y colores
        //Color aux = Color.BLUE;
        int listAtrac = 1;
        for (int i = 0; i < nAtractores; i++) {
            x = r.nextFloat() - 0.5f;
            y = r.nextFloat() - 0.5f;
            z = r.nextFloat() - 0.5f;
            atractors[i] = new Coord3d(x, y, z);
            Color aux = escogerColor(i+1);
            colorsAtractors[i] = new Color(aux.r, aux.g, aux.b, aux.a);
            System.out.println(listAtrac+" Atractor: "+atractors[i]+"\t Clase:"+colorsAtractors[i]);
            listAtrac++;
        }
        setAtractors(atractors);
        //centroides y clases
        boolean t;
        int numIteraciones=0;
        do{
            numIteraciones++;
            //puntos con clase, despues de obtener la distancia euclidiana de los puntos más cerca
            setPoints(distancias(getPoints(), atractors, colors, colorsAtractors));
            //calculamos centroides
            t = calcularCentroides(getPoints(), atractors, colors, colorsAtractors);
        }while(t);
        JOptionPane.showMessageDialog( null ,"¡Se completo! en "+numIteraciones+" iteraciones", "K-Means",JOptionPane.WARNING_MESSAGE);

        
        // Unimos los puntos y atractores
        Coord3d[] points2= (Coord3d[])ArrayUtils.addAll(points, atractors);
        //Unimos los arrays de colores de puntos y atractores
        Color[] colors2= (Color[])ArrayUtils.addAll(colors, colorsAtractors);
        
        //Al objeto scatter le añadimos los datos y sus clases.
        scatter.setData(points2);
        scatter.setColors(colors2);
        
        scatter.setWidth(5);
        scatter.setBoundingBoxDisplayed(true);
        scatter.updateBounds();
        
        
        chart = AWTChartComponentFactory.chart(Quality.Fastest, "newt");
        chart.getScene().add(scatter);
        
    }
    public Color escogerColor(int c){
        switch(c){
            case 1:
                return Color.GREEN;
            case 2:
                return Color.BLUE;
            case 3:
                return Color.YELLOW;
            case 4:
                return Color.MAGENTA;
            case 5:
                return Color.CYAN;
            case 6:
                return Color.GRAY;
            case 7:
                return Color.RED;
            default:
                return Color.WHITE;
        }
    }
    public Coord3d[] distancias(Coord3d[] points, Coord3d[] atractors, Color[] auxColor, Color[] auxColorsAtractors){
        ArrayList<Float> arrayDistancias = new ArrayList<>();
        float aux=0;//obtener el valor minimo de las distancias
        int min = -1;
        int listado=1;
        for (int i = 0; i < nPuntos; i++) {
            for(int j=0; j< nAtractores; j++){
                arrayDistancias.add(euclidiana(points[i].x, points[i].y, points[i].z, atractors[j].x, atractors[j].y, atractors[j].z));
            }
            aux = Collections.min(arrayDistancias);
            min = arrayDistancias.indexOf(aux);
            auxColor[i] = auxColorsAtractors[min];
            System.out.println(listado+" Puntos: "+points[i]+" \tClase: "+auxColor[i]);
            listado++;
            auxColor[i].a = -2.0f;
            arrayDistancias.clear();
        }
        setColors(auxColor);
        return points;
    }
    public float euclidiana(float x1, float y1, float z1, float x2, float y2, float z2){
        float d;
        return d =(float) Math.sqrt( Math.pow(x2-x1,2)+ Math.pow(y2-y1,2)+ Math.pow(z2-z1,2));
    }
    public boolean calcularCentroides(Coord3d[] points, Coord3d[] atractors, Color[] auxColor, Color[] auxColorsAtractors){
        Coord3d[] auxAtractors = atractors;
        int arrayContadores[] = new int[nAtractores];//contadores de numero de clases
        //inicializamos nuestros centroides en cordenadas X y Y, junto con los contadores en cero
        for(int i=0;i<nAtractores;i++){
            auxAtractors[i].x = 0;
            auxAtractors[i].y = 0;
            auxAtractors[i].z = 0;
            //centroide.setnC(0);
            arrayContadores[i] = 0;
        }//System.out.println("Centroides: "+centroides);
        float acumulador = 0;
        //recorremos todas las clases y comprobamos si tienen la misma clase, si lo tienen
        //se suma un uno a el array de contadores
        for(int i=0;i< nPuntos;i++){
            for(int j=0; j< nAtractores;j++){
                //System.out.println("punto : "+puntos.getnC()+" atractor: "+centroides.get(i).getnC());
                if(auxColor[j].equals(auxColorsAtractors[j])){
                    
                    acumulador = auxAtractors[j].x + points[j].x;
                    auxAtractors[j].x = acumulador;
                    acumulador = 0;
                    acumulador = auxAtractors[j].y + points[j].y;
                    auxAtractors[j].y = acumulador;
                    acumulador = 0;
                    acumulador = auxAtractors[j].z + points[j].z;
                    auxAtractors[j].z = acumulador;
                    acumulador = 0;
                    arrayContadores[j] = arrayContadores[j]+1;
                }
            }
        }
        for(int i=0;i< nAtractores;i++){
            System.out.println("Centroides:"+auxAtractors[i]);
        }
        boolean t;
        t = pintarNuevoCentroide(auxAtractors, auxColorsAtractors, auxColor, arrayContadores);
        //objectKM.setCentroides(centroides);
        
        
        return t;
    }
    public boolean pintarNuevoCentroide(Coord3d[] auxAtractors, Color[] auxColorsAtractors,Color[] auxColors, int contadores[]){
        int countBooleans = 0; //contador de booleanos, sí el atractor viejo es igual a el nuevo atractor
        for(int i=0;i<nAtractores;i++){
            auxAtractors[i].x = auxAtractors[i].x/contadores[i];
            auxAtractors[i].y = auxAtractors[i].y/contadores[i];
            auxAtractors[i].z = auxAtractors[i].z/contadores[i];
            if(auxAtractors.equals(getAtractors())){
                countBooleans++;
            }
        }
        //antes de mandar true o false, actualizamos los atractores.
        setAtractors(auxAtractors);
        for(int j=0;j<nAtractores;j++){
            System.out.println(" Actualizado : "+auxAtractors[j]);
        }
        if(countBooleans == nAtractores){
            //aqui me equivoque por eso no daba XD era al revez por la condicíon del while
            //return true
            return false;
        }else{
            //return false;
            return true;
        }
    }
    public void clear(){
        
    }
}
