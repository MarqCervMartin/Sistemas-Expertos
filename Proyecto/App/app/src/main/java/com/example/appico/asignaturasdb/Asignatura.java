package com.example.appico.asignaturasdb;

import java.util.Calendar;

/*
Development by Mares ICO 2020
 */
public class Asignatura {
    //Calendar cal = Calendar.getInstance();
    private Integer id;
    private String matricula;
    private String nombre;
    private Integer creditos;
    private String turno;
    private Integer docente_id;

    private String dia_uno;
    private String hora_inicio_dia_uno;
    private String hora_salida_dia_uno;
    private float duracion_dia_uno;

    private String dia_dos;
    private String hora_inicio_dia_dos;
    private String hora_salida_dia_dos;
    private float duracion_dia_dos;

    public Asignatura(Integer id, String matricula, String nombre, Integer creditos, String turno, Integer docente_id, String dia_uno, String hora_inicio_dia_uno, String hora_salida_dia_uno, float duracion_dia_uno, String dia_dos, String hora_inicio_dia_dos, String hora_salida_dia_dos, float duracion_dia_dos) {
        this.id = id;
        this.matricula = matricula;
        this.nombre = nombre;
        this.creditos = creditos;
        this.turno = turno;
        this.docente_id = docente_id;
        this.dia_uno = dia_uno;
        this.hora_inicio_dia_uno = hora_inicio_dia_uno;
        this.hora_salida_dia_uno = hora_salida_dia_uno;
        this.duracion_dia_uno = duracion_dia_uno;
        this.dia_dos = dia_dos;
        this.hora_inicio_dia_dos = hora_inicio_dia_dos;
        this.hora_salida_dia_dos = hora_salida_dia_dos;
        this.duracion_dia_dos = duracion_dia_dos;
    }

    public Asignatura(Integer id, String matricula, String nombre, Integer creditos, String turno, Integer docente_id, String dia_uno, String hora_inicio_dia_uno, String hora_salida_dia_uno, float duracion_dia_uno) {
        this.id = id;
        this.matricula = matricula;
        this.nombre = nombre;
        this.creditos = creditos;
        this.turno = turno;
        this.docente_id = docente_id;
        this.dia_uno = dia_uno;
        this.hora_inicio_dia_uno = hora_inicio_dia_uno;
        this.hora_salida_dia_uno = hora_salida_dia_uno;
        this.duracion_dia_uno = duracion_dia_uno;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public Integer getDocente_id() {
        return docente_id;
    }

    public void setDocente_id(Integer docente_id) {
        this.docente_id = docente_id;
    }

    public String getDia_uno() {
        return dia_uno;
    }

    public void setDia_uno(String dia_uno) {
        this.dia_uno = dia_uno;
    }

    public String getHora_inicio_dia_uno() {
        return hora_inicio_dia_uno;
    }

    public void setHora_inicio_dia_uno(String hora_inicio_dia_uno) {
        this.hora_inicio_dia_uno = hora_inicio_dia_uno;
    }

    public String getHora_salida_dia_uno() {
        return hora_salida_dia_uno;
    }

    public void setHora_salida_dia_uno(String hora_salida_dia_uno) {
        this.hora_salida_dia_uno = hora_salida_dia_uno;
    }

    public float getDuracion_dia_uno() {
        return duracion_dia_uno;
    }

    public void setDuracion_dia_uno(float duracion_dia_uno) {
        this.duracion_dia_uno = duracion_dia_uno;
    }

    public String getDia_dos() {
        return dia_dos;
    }

    public void setDia_dos(String dia_dos) {
        this.dia_dos = dia_dos;
    }

    public String getHora_inicio_dia_dos() {
        return hora_inicio_dia_dos;
    }

    public void setHora_inicio_dia_dos(String hora_inicio_dia_dos) {
        this.hora_inicio_dia_dos = hora_inicio_dia_dos;
    }

    public String getHora_salida_dia_dos() {
        return hora_salida_dia_dos;
    }

    public void setHora_salida_dia_dos(String hora_salida_dia_dos) {
        this.hora_salida_dia_dos = hora_salida_dia_dos;
    }

    public float getDuracion_dia_dos() {
        return duracion_dia_dos;
    }

    public void setDuracion_dia_dos(float duracion_dia_dos) {
        this.duracion_dia_dos = duracion_dia_dos;
    }
}
