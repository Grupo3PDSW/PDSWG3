-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2015-11-17 17:56:30.408




-- tables
-- Table Bitacora
CREATE TABLE Bitacora (
    descripcion varchar(255)  NOT NULL,
    id int  NOT NULL,
    tarea_id int  NULL,
    fecha timestamp  NOT NULL,
    Monitoria_id int  NULL,
    Monitor int  NOT NULL,
    Turno_id int  NOT NULL,
    CONSTRAINT Bitacora_pk PRIMARY KEY (id)
);

-- Table Equipo
CREATE TABLE Equipo (
    Id int  NOT NULL,
    Laboratorios_id int  NOT NULL,
    descripcion varchar(255)  NOT NULL,
    CONSTRAINT Equipo_pk PRIMARY KEY (Id)
);

-- Table Estudiante
 
    
CREATE TABLE Estudiante (
    id int  NOT NULL,
    Nombre varchar(255)  NOT NULL,
    email varchar(255)  NOT NULL,
    Monitor varchar(1)  NOT NULL,
    CONSTRAINT Estudiante_pk PRIMARY KEY (id)
);

-- Table Laboratorio
CREATE TABLE Laboratorio (
    id int  NOT NULL,
    descripcion varchar(255)  NOT NULL,
    CONSTRAINT Laboratorio_pk PRIMARY KEY (id)
);

-- Table Monitoria
CREATE TABLE Monitoria (
    lenguajeProgramacion varchar(20)  NOT NULL,
    tema varchar(20)  NOT NULL,
    id int  NOT NULL,
    DarSoporte varchar(20)  NOT NULL,
    CONSTRAINT Monitoria_pk PRIMARY KEY (id)
);

-- Table Problema
CREATE TABLE Problema (
    descripcion varchar(255)  NOT NULL,
    Equipo_Id int  NOT NULL,
    id int  NOT NULL,
    fecha timestamp  NOT NULL,
    Estudiante_id int  NOT NULL,
    CONSTRAINT Problema_pk PRIMARY KEY (id)
);

-- Table Tarea
CREATE TABLE Tarea (
    id int  NOT NULL,
    tipo varchar(40)  NOT NULL,
    estado varchar(10)  NOT NULL,
    comentario varchar(255)  NOT NULL,
    CONSTRAINT Tarea_pk PRIMARY KEY (id)
);

-- Table Turno
CREATE TABLE Turno (
    HoraInicio timestamp  NOT NULL,
    HoraFin timestamp  NOT NULL,
    id int  NOT NULL,
    dia varchar(20)  NOT NULL,
    Estudiante_id int  NOT NULL,
    CONSTRAINT Turno_pk PRIMARY KEY (id)
);




