package com.example.appico.utilidades;

import com.example.appico.asignaturasdb.Asignatura;
import com.example.appico.asignaturasdb.Docente;

import java.util.ArrayList;

public class DBLocalEstatica {
    private ArrayList<Docente> array_docentes = new ArrayList<>();
    private ArrayList<Asignatura> array_asignaturas = new ArrayList<>();

    public DBLocalEstatica() {
        array_docentes.add(new Docente(1,"Diego Armando","Ramírez","Avelino","Ing"));
        array_docentes.add(new Docente(2,"Isaac","Velázquez","Hernández","Ing"));
        array_docentes.add(new Docente(3,"Israel","García","Juárez","Ing"));
        array_docentes.add(new Docente(4,"Armando","Leal","Cruz","Ing"));
        array_docentes.add(new Docente(5,"Nadia Yanet Julia","López","Villlegas","Ing"));
        array_docentes.add(new Docente(6,"Jesús","Flores","Maya","Ing"));
        array_docentes.add(new Docente(7,"Alejandro","Quintero","García","Ing"));
        array_docentes.add(new Docente(8,"Hazem","Álvarez","Rodríguez","Ing"));
        array_docentes.add(new Docente(9,"Karen Brizeida","Martínez","Castro","Lic"));
        array_docentes.add(new Docente(10,"Yossy","García","Ramírez","Lic"));
        array_docentes.add(new Docente(11,"Carlos","Flores","Moya","Ing"));
        array_docentes.add(new Docente(12,"Edith Cristina","Herrera","Luna","M. en C"));
        array_docentes.add(new Docente(13,"María Guadalupe","Domínguez","Urban","M. en C"));
        array_docentes.add(new Docente(14,"Manuel","Almeida","Vázquez","M. en C"));
        array_docentes.add(new Docente(15,"Valentín","Trujillo","Mora","M. en C"));
        array_docentes.add(new Docente(16,"Rafael","Rojas","Hernández","M. en C"));
        array_docentes.add(new Docente(17,"Luis Enrique","Kú","Moo","M. en C"));
        array_docentes.add(new Docente(18,"Rosa Erendira","Reyes","Luna","M. en Ed"));
        array_docentes.add(new Docente(19,"Jorge","Bautista","López","M.T.I"));
        array_docentes.add(new Docente(20,"Carlos Alberto","Rojas","Hernández","M.T.I"));
        array_docentes.add(new Docente(21,"Cecilia Artemisa","Rivero","Gómez","Mtra"));
        array_docentes.add(new Docente(22,"Asdrúbal","López","Chau","Dr"));
        array_docentes.add(new Docente(23,"José Manuel","Trujillo","Lara","Dr"));
        array_docentes.add(new Docente(24,"Vacante"," "," "," "));
        //61
        //Segundo Matutino
        array_asignaturas.add(new Asignatura(1,"LINC01","Álgebra Lineal",7,"TM",2,"Martes",
                "9:00","11:00", 2.0f,"Viernes","7:00","9:00",2.0f));
        array_asignaturas.add(new Asignatura(2,"LINC04","Cálculo II",7,"TM",3,"Lunes",
                "11:00","13:00", 2.0f,"Jueves","11:00","13:00",2.0f));
        array_asignaturas.add(new Asignatura(3,"LINC07","Ecuaciones Diferenciales",7,"TM",23,"Jueves",
                "9:00","11:00", 2.0f,"Viernes","9:00","11:00",2.0f));
        array_asignaturas.add(new Asignatura(4,"LINC10","Epistemología",7,"TM",9,"Lunes",
                "7:00","9:00", 2.0f,"Miercoles","7:00","9:00",2.0f));
        array_asignaturas.add(new Asignatura(5,"LMU209","Inglés 5",6,"TM",10,"Lunes",
                "9:00","11:00", 2.0f,"Miercoles","9:00","11:00",2.0f));
        array_asignaturas.add(new Asignatura(6,"LINC35","Programación II",7,"M1",18,"Martes",
                "7:00","9:00", 2.0f,"Jueves","7:00","9:00",2.0f));
        array_asignaturas.add(new Asignatura(7,"LINC35","Programación II",7,"M2",13,"Martes",
                "7:00","9:00", 2.0f,"Jueves","7:00","9:00",2.0f));
        array_asignaturas.add(new Asignatura(8,"LINC29","Química",7,"TM",21,"Martes",
                "11:00","13:00", 2.0f,"Viernes","11:00","13:00",2.0f));

        //Segundo vespertino
        array_asignaturas.add(new Asignatura(9,"LINC01","Álgebra Lineal",7,"TV",17,"Miercoles",
                "16:00","18:00", 2.0f,"Viernes","16:00","18:00",2.0f));
        array_asignaturas.add(new Asignatura(10,"LINC04","Cálculo II",7,"TV",23,"Martes",
                "16:00","18:00", 2.0f,"Miercoles","18:00","20:00",2.0f));
        array_asignaturas.add(new Asignatura(11,"LINC07","Ecuaciones Diferenciales",7,"TV",14,"Jueves",
                "14:00","16:00", 2.0f,"Viernes","14:00","16:00",2.0f));
        array_asignaturas.add(new Asignatura(12,"LINC10","Epistemología",7,"TV",11,"Lunes",
                "16:00","18:00", 2.0f,"Miercoles","14:00","16:00",2.0f));
        array_asignaturas.add(new Asignatura(13,"LMU209","Inglés 5",6,"TV",2,"Martes",
                "18:00","20:00", 2.0f,"Jueves","16:00","18:00",2.0f));
        array_asignaturas.add(new Asignatura(14,"LINC35","Programación II",7,"V1",22,"Lunes",
                "14:00","16:00", 2.0f,"Martes","14:00","16:00",2.0f));
        array_asignaturas.add(new Asignatura(15,"LINC35","Programación II",7,"V2",12,"Lunes",
                "14:00","16:00", 2.0f,"Martes","14:00","16:00",2.0f));
        array_asignaturas.add(new Asignatura(16,"LINC29","Química",7,"TV",24,"Lunes",
                "18:00","20:00", 2.0f,"Jueves","18:00","20:00",2.0f));

        //Cuarto matutino

        array_asignaturas.add(new Asignatura(17,"L41109","Cálculo 3",6,"TM",3,"Martes",
                "11:00","14:00", 3.0f,null,null,null,0));
        array_asignaturas.add(new Asignatura(18,"L41034","Circuitos Eléctricos",9,"TM",15,"Jueves",
                "8:00","10:00", 2.0f,"Viernes","8:00","11:00",3.0f));
        array_asignaturas.add(new Asignatura(19,"L41061","Fundamentos de Bases de Datos",6,"TM",18,"Lunes",
                "7:00","9:00", 2.0f,"Miercoles","7:00","9:00",2.0f));
        array_asignaturas.add(new Asignatura(20,"L41004","Investigación de Operaciones",7,"TM",4,"Lunes",
                "12:00","14:00", 2.0f,"Miercoles","9:00","11:00",2.0f));
        array_asignaturas.add(new Asignatura(21,"L41047","Lenguaje Ensamblador",3,"TM",13,"Miercoles",
                "11:00","13:00", 2.0f,null,null,null,0));
        array_asignaturas.add(new Asignatura(22,"L41056","Programación Orientada a Objetos",8,"TM",12,"Lunes",
                "9:00","12:00", 3.0f,"Jueves","10:00","12:00",2.0f));
        array_asignaturas.add(new Asignatura(23,"L41040","Transmisión de Datos",8,"TM",5,"Martes",
                "9:00","11:00", 2.0f,"Viernes","11:00","14:00",3.0f));
        array_asignaturas.add(new Asignatura(24,"L00070","Inglés C2",6,"TM",24,"Sabado",
                "7:00","11:00", 4.0f,null,null,null,0));

        //Cuarto vespertino

        array_asignaturas.add(new Asignatura(25,"L41109","Cálculo 3",6,"TV",23,"Lunes",
                "17:00","20:00", 3.0f,null,null,null,0));
        array_asignaturas.add(new Asignatura(26,"L41034","Circuitos Eléctricos",9,"TV",2,"Miercoles",
                "16:00","18:00", 2.0f,"Viernes","16:00","19:00",3.0f));
        array_asignaturas.add(new Asignatura(27,"L41061","Fundamentos de Bases de Datos",6,"TV",12,"Martes",
                "16:00","18:00", 2.0f,"Jueves","15:00","17:00",2.0f));
        array_asignaturas.add(new Asignatura(28,"L41004","Investigación de Operaciones",7,"TV",17,"Miercoles",
                "14:00","16:00", 2.0f,"Viernes","14:00","16:00",2.0f));
        array_asignaturas.add(new Asignatura(29,"L41047","Lenguaje Ensamblador",3,"TV",6,"Miercoles",
                "18:00","20:00", 2.0f,null,null,null,0));
        array_asignaturas.add(new Asignatura(30,"L41056","Programación Orientada a Objetos",8,"TV",18,"Martes",
                "18:00","20:00", 2.0f,"Jueves","17:00","20:00",3.0f));
        array_asignaturas.add(new Asignatura(31,"L41040","Transmisión de Datos",8,"TV",24,"Lunes",
                "14:00","17:00", 3.0f,"Martes","14:00","16:00",2.0f));

        //SExto matutino
        array_asignaturas.add(new Asignatura(32,"L41048","Compiladores",9,"TM",13,"Lunes",
                "10:00","12:00", 2.0f,"Miercoles","7:00","10:00",3.0f));
        array_asignaturas.add(new Asignatura(33,"L41088","Electrónica Digital",8,"TM",7,"Jueves",
                "10:00","12:00", 2.0f,"Viernes","8:00","11:00",3.0f));
        array_asignaturas.add(new Asignatura(34,"L41045","Modelos de Redes",7,"TM",19,"Miercoles",
                "11:00","13:00", 2.0f,"Jueves","12:00","14:00",2.0f));
        array_asignaturas.add(new Asignatura(35,"L41071","Sistemas Gestores de Bases de Datos",5,"TM",12,"Martes",
                "8:00","10:00", 2.0f,"Jueves","8:00","10:00",2.0f));
        array_asignaturas.add(new Asignatura(36,"L41049","Sistemas Operativos",9,"TM",13,"Lunes",
                "7:00","10:00", 3.0f,"Martes","12:00","14:00",2.0f));
        array_asignaturas.add(new Asignatura(37,"L41007","Teoría de Sistemas",6,"TM",5,"Martes",
                "10:00","12:00", 2.0f,"Miercoles","10:00","11:00",1.0f));
        array_asignaturas.add(new Asignatura(38,"L41005","Tratamiento de Imágenes",5,"TM",14,"Viernes",
                "11:00","14:00", 3.0f,null,null,null,0));

        //SExto vespertino
        array_asignaturas.add(new Asignatura(39,"L41048","Compiladores",9,"TV",7,"Martes",
                "16:00","18:00", 2.0f,"Jueves","15:00","18:00",3.0f));
        array_asignaturas.add(new Asignatura(40,"L41088","Electrónica Digital",8,"TV",15,"Miercoles",
                "15:00","18:00", 3.0f,"Jueves","13:00","15:00",2.0f));
        array_asignaturas.add(new Asignatura(41,"L41045","Modelos de Redes",7,"TV",20,"Martes",
                "18:00","20:00", 2.0f,"Viernes","16:00","18:00",2.0f));
        array_asignaturas.add(new Asignatura(42,"L41071","Sistemas Gestores de Bases de Datos",5,"TV",18,"Lunes",
                "18:00","20:00", 2.0f,"Miercoles","18:00","20:00",2.0f));
        array_asignaturas.add(new Asignatura(43,"L41049","Sistemas Operativos",9,"TV",13,"Lunes",
                "14:00","17:00", 3.0f,"Martes","13:00","15:00",2.0f));
        array_asignaturas.add(new Asignatura(44,"L41007","Teoría de Sistemas",6,"TV",5,"Martes",
                "15:00","16:00", 1.0f,"Viernes","14:00","16:00",2.0f));
        array_asignaturas.add(new Asignatura(45,"L41005","Tratamiento de Imágenes",5,"TV",16,"Lunes",
                "17:00","18:00", 1.0f,"Jueves","18:00","20:00",2.0f));
        //Octavo Matutino
        array_asignaturas.add(new Asignatura(46,"L41051","Administración y Seguridad de Sistemas Operativos",6,"TM",8,"Miercoles",
                "11:00","12:00", 1.0f,"Jueves","10:00","12:00",2.0f));
        array_asignaturas.add(new Asignatura(47,"L41043","Análisis y Diseño de Redes",9,"TM",5,"Martes",
                "11:00","14:00", 3.0f,"Viernes","9:00","11:00",2.0f));
        array_asignaturas.add(new Asignatura(48,"L41038","Arquitectura de Computadoras",8,"TM",7,"Martes",
                "9:00","11:00", 2.0f,"Jueves","7:00","10:00",3.0f));
        array_asignaturas.add(new Asignatura(49,"L41037","Sistemas Digitales",9,"TM",19,"Lunes",
                "8:00","11:00", 3.0f,"Viernes","11:00","14:00",3.0f));
        array_asignaturas.add(new Asignatura(50,"L41057","Programación Paralela y Distribuida",8,"TM",14,"Lunes",
                "11:00","14:00", 3.0f,"Jueves","12:00","14:00",2.0f));
        array_asignaturas.add(new Asignatura(51,"L41067","Fundamentos de Robótica",5,"TM",1,"Sabado",
                "7:00","10:00", 3.0f,null,null,null,0));

        //Recurse
        array_asignaturas.add(new Asignatura(52,"L41002","Álgebra Lineal",6,"TM",16,"Martes",
                "11:00","14:00", 3.0f,null,null,null,0));
        array_asignaturas.add(new Asignatura(53,"L41010","Cálculo 1",9,"TM",16,"Miercoles",
                "11:00","13:00", 2.0f,"Viernes","11:00","13:30",2.5f));
        array_asignaturas.add(new Asignatura(54,"L41054","Estructura de Datos",8,"TM",16,"Lunes",
                "10:00","12:00", 2.0f,"Jueves","11:00","14:00",3.0f));
        array_asignaturas.add(new Asignatura(55,"L41020","Física Básica",9,"TM",15,"Miercoles",
                "11:30","14:00", 2.5f,"Jueves","11:00","13:00",2.0f));
        array_asignaturas.add(new Asignatura(56,"L41020","Física Básica",9,"TM",4,"Miercoles",
                "14:00","16:00", 2.0f,"Viernes","14:00","16:30",2.5f));
        array_asignaturas.add(new Asignatura(57,"L41039","Metrología",4,"TM",1,"Martes",
                "11:00","14:00", 3.0f,null,null,null,0));

        //LINEAS DE acentuación
        array_asignaturas.add(new Asignatura(58,"L41083","Multimedia",6,"IHM",16,"Lunes",
                "12:00","14:00", 2.0f,"Miercoles","13:00","15:00",2.0f));
        array_asignaturas.add(new Asignatura(59,"L41085","Algoritmos Genéticos",4,"IHM",22,"Miercoles",
                "8:00","11:00", 3.0f,null,null,null,0));
        array_asignaturas.add(new Asignatura(60,"L41082","Interconexión de Redes",4,"Grupo Optativa Redes",20,"Lunes",
                "12:00","14:00", 2.0f,"Miercoles","14:00","15:00",1.0f));
        array_asignaturas.add(new Asignatura(61,"L41078","Instalaciones y Equipos",5,"Grupo Optativa Redes",20,"Miercoles",
                "8:00","11:00", 3.0f,null,null,null,0));


    }

    public ArrayList<Docente> getArray_docentes() {
        return array_docentes;
    }

    public void setArray_docentes(ArrayList<Docente> array_docentes) {
        this.array_docentes = array_docentes;
    }

    public ArrayList<Asignatura> getArray_asignaturas() {
        return array_asignaturas;
    }

    public void setArray_asignaturas(ArrayList<Asignatura> array_asignaturas) {
        this.array_asignaturas = array_asignaturas;
    }
}
