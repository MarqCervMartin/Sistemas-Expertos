/*
"Nombre de materia","día hora duración"
Esthephen Razek Lira envió Ayer a las 10:22
El segundo campo nececito que esté separado por espacios
Esthephen Razek Lira envió Ayer a las 10:22
Leer un objeto dentro de otro objeto está cabron casi muero en el intento ayer ...
*/


CREATE DATABASE ico_db;
USE ico_db;

CREATE TABLE docente(
    id TINYINT PRIMARY KEY,
    nombre varchar(30) NOT NULL,
    paterno varchar(30) NOT NULL,
    materno varchar(30) NOT NULL,
    grado varchar(20) NOT NULL
);
CREATE TABLE asignatura(
    id TINYINT PRIMARY KEY,
    matricula varchar(6),
    nombre varchar(60) NOT NULL,
    creditos TINYINT NOT NULL,
    turno varchar(5) NOT NULL,
    docente_id TINYINT NOT NULL,
    dia_uno varchar(10) NOT NULL,
    hora_inicio_dia_uno TIME NOT NULL,
    hora_salida_dia_uno TIME NOT NULL,
    --duracion_dia_uno varchar(15),
    dia_dos varchar(10),
    hora_inicio_dia_dos TIME,
    hora_salida_dia_dos TIME,
    --duracion_dia_dos varchar(15),
    CONSTRAINT fk_docente FOREIGN KEY (docente_id) REFERENCES docente(id)
);

/*SQLITE
Sintax
*/

CREATE TABLE "docente" (
	"id"	INTEGER NOT NULL,
	"nombre"	TEXT NOT NULL,
	"paterno"	TEXT NOT NULL,
	"materno"	TEXT NOT NULL,
	"grado"	TEXT NOT NULL,
	PRIMARY KEY("id")
);
CREATE TABLE "asignatura" (
	"id"	INTEGER NOT NULL,
	"matricula"	TEXT NOT NULL,
	"nombre"	TEXT NOT NULL,
	"creditos"	INTEGER NOT NULL,
	"turno"	TEXT NOT NULL,
	"docente_id"	INTEGER NOT NULL,
	"dia_uno"	TEXT NOT NULL,
	"hora_inicio_dia_uno"	TEXT NOT NULL,
	"hora_salida_dia_uno"	TEXT NOT NULL,
	"duracion_dia_uno"	INTEGER,
	"dia_dos"	TEXT NOT NULL,
	"hora_inicio_dia_dos"	TEXT NOT NULL,
	"hora_salida_dia_dos"	TEXT NOT NULL,
	"duracion_dia_dos"	INTEGER,
	PRIMARY KEY("id"),
	FOREIGN KEY("docente_id") REFERENCES "docente"("id")
);

/*
alter table asignatura drop column duracion;
alter table asignatura add duracion AS datediff(hour, hora_inicio, hora_salida) PERSISTED;
*/
