/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ag_horarios;

import java.util.Date;

/**
 *
 * @author liraz
 */
public class Materia {

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public Date getHoraIn() {
        return horaIn;
    }

    public void setHoraIn(Date horaIn) {
        this.horaIn = horaIn;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }
    
    public Materia(String nombre, String profesor, String grupo, Date horaIn, Date horaFin) {
        this.nombre = nombre;
        this.profesor = profesor;
        this.turno = grupo;
        this.horaIn = horaIn;
        this.horaFin = horaFin;
    }
    
    public int getDuracion() {
        return Duracion;
    }

    public void setDuracion(int Duracion) {
        this.Duracion = Duracion;
    }
    String nombre;
    String profesor;
    String turno;
    Date horaIn;
    Date horaFin;
    int Duracion;
    
    
}
