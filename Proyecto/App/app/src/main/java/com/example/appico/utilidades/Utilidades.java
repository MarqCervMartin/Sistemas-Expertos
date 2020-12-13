package com.example.appico.utilidades;

public class Utilidades {
    //constantes campos tabla docente

    public static final String TABLA_DOCENTE = "docente";
    public static final String CAMPO_ID_DOCENTE = "id";
    public static final String CAMPO_NOMBRE_DOCENTE = "nombre";
    public static final String CAMPO_PATERNO_DOCENTE = "paterno";
    public static final String CAMPO_MATERNO_DOCENTE = "materno";
    public static final String CAMPO_GRADO_DOCENTE = "grado";

    public static final String TABLA_ASIGNATURA = "asignatura";
    public static final String CAMPO_ID_ASIGNATURA = "id";
    public static final String CAMPO_MATRICULA_ASIGNATURA = "matricula";
    public static final String CAMPO_NOMBRE_ASIGNATURA = "nombre";
    public static final String CAMPO_CREDITOS_ASIGNATURA = "creditos";
    public static final String CAMPO_TURNO_ASIGNATURA = "turno";
    public static final String CAMPO_DOCENTEID_ASIGNATURA = "docente_id";

    public static final String CAMPO_DIAUNO_ASIGNATURA = "dia_uno";
    public static final String CAMPO_HORAINICIODIAUNO_ASIGNATURA = "hora_inicio_dia_uno";
    public static final String CAMPO_HORASALIDADIAUNO_ASIGNATURA = "hora_salida_dia_uno";
    public static final String CAMPO_DURACIONDIAUNO_ASIGNATURA = "duracion_dia_uno";
    public static final String CAMPO_DIADOS_ASIGNATURA = "dia_dos";
    public static final String CAMPO_HORAINICIODIADOS_ASIGNATURA = "hora_inicio_dia_dos";
    public static final String CAMPO_HORASALIDADIADOS_ASIGNATURA = "hora_salida_dia_dos";
    public static final String CAMPO_DURACIONDIADOS_ASIGNATURA = "duracion_dia_dos";


    public static final String CREAR_TABLA_ASIGNATURA = "CREATE TABLE "+TABLA_ASIGNATURA+" ("+
            CAMPO_ID_ASIGNATURA+" INTEGER NOT NULL, " +
            CAMPO_MATRICULA_ASIGNATURA + " TEXT NOT NULL, " +
            CAMPO_NOMBRE_ASIGNATURA + " TEXT NOT NULL, " +
            CAMPO_CREDITOS_ASIGNATURA + " INTEGER NOT NULL, " +
            CAMPO_TURNO_ASIGNATURA + " TEXT NOT NULL, " +
            CAMPO_DOCENTEID_ASIGNATURA + " INTEGER NOT NULL, " +
            CAMPO_DIAUNO_ASIGNATURA + " TEXT NOT NULL, " +
            CAMPO_HORAINICIODIAUNO_ASIGNATURA + " TEXT NOT NULL, " +
            CAMPO_HORASALIDADIAUNO_ASIGNATURA + " TEXT NOT NULL, " +
            CAMPO_DURACIONDIAUNO_ASIGNATURA + " INTEGER, " +
            CAMPO_DIADOS_ASIGNATURA + " TEXT, " +
            CAMPO_HORAINICIODIADOS_ASIGNATURA + " TEXT, " +
            CAMPO_HORASALIDADIADOS_ASIGNATURA + " TEXT, " +
            CAMPO_DURACIONDIADOS_ASIGNATURA + " INTEGER, " +
            "PRIMARY KEY("+CAMPO_ID_ASIGNATURA+")"+
            //+ " FOREIGN KEY ("+CAMPO_DOCENTEID_ASIGNATURA+") REFERENCES "+ TABLA_DOCENTE +"("+CAMPO_ID_DOCENTE+")" +
            ")";
    public static final String CREAR_TABLA_DOCENTE = "CREATE TABLE "+ TABLA_DOCENTE+" (" +
            CAMPO_ID_DOCENTE + " INTEGER NOT NULL, " +
            CAMPO_NOMBRE_DOCENTE + " TEXT NOT NULL, " +
            CAMPO_PATERNO_DOCENTE + " TEXT NOT NULL, " +
            CAMPO_MATERNO_DOCENTE + " TEXT NOT NULL, "+
            CAMPO_GRADO_DOCENTE + " TEXT NOT NULL, " +
            "PRIMARY KEY("+CAMPO_ID_DOCENTE+")"+
            ")";
}
