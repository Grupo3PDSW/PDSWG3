-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2015-11-05 19:09:23.023




-- tables
-- Table Bitacora
CREATE TABLE Bitacora (
    Monitor_Estudiantes_id int  NOT NULL,
    Monitor_Turnos_id int  NOT NULL,
    descripcion varchar(255)  NOT NULL,
    id int  NOT NULL,
    tarea_id int  NOT NULL,
    fecha timestamp  NOT NULL,
    Monitoria_id int  NOT NULL,
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
    CONSTRAINT Estudiante_pk PRIMARY KEY (id)
);


-- Table Laboratorio
CREATE TABLE Laboratorio (
    id int  NOT NULL,
    descripcion varchar(255)  NOT NULL,
    CONSTRAINT Laboratorio_pk PRIMARY KEY (id)
);


-- Table Monitor
CREATE TABLE Monitor (
    Estudiantes_id int  NOT NULL,
    Turnos_id int  NOT NULL,
    CONSTRAINT Monitor_pk PRIMARY KEY (Estudiantes_id,Turnos_id)
);

-- Table Monitoria
CREATE TABLE Monitoria (
    lenguajeProgramacion varchar(20)  NOT NULL,
    tema varchar(20)  NOT NULL,
    id int  NOT NULL,
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
    CONSTRAINT Turno_pk PRIMARY KEY (id)
);






-- foreign keys
-- Reference:  Bitacora_Monitor (table: Bitacora)


ALTER TABLE Bitacora ADD CONSTRAINT Bitacora_Monitor FOREIGN KEY Bitacora_Monitor (Monitor_Estudiantes_id,Monitor_Turnos_id)
    REFERENCES Monitor (Estudiantes_id,Turnos_id);
-- Reference:  Bitacora_Monitoria (table: Bitacora)


ALTER TABLE Bitacora ADD CONSTRAINT Bitacora_Monitoria FOREIGN KEY Bitacora_Monitoria (Monitoria_id)
    REFERENCES Monitoria (id);
-- Reference:  Bitacora_Tarea (table: Bitacora)


ALTER TABLE Bitacora ADD CONSTRAINT Bitacora_Tarea FOREIGN KEY Bitacora_Tarea (tarea_id)
    REFERENCES Tarea (id);
-- Reference:  Monitores_Estudiantes (table: Monitor)


ALTER TABLE Monitor ADD CONSTRAINT Monitores_Estudiantes FOREIGN KEY Monitores_Estudiantes (Estudiantes_id)
    REFERENCES Estudiante (id);
-- Reference:  Monitores_Turnos (table: Monitor)


ALTER TABLE Monitor ADD CONSTRAINT Monitores_Turnos FOREIGN KEY Monitores_Turnos (Turnos_id)
    REFERENCES Turno (id);
-- Reference:  Problema_Equipo (table: Problema)


ALTER TABLE Problema ADD CONSTRAINT Problema_Equipo FOREIGN KEY Problema_Equipo (Equipo_Id)
    REFERENCES Equipo (Id);
-- Reference:  Problema_Estudiante (table: Problema)


ALTER TABLE Problema ADD CONSTRAINT Problema_Estudiante FOREIGN KEY Problema_Estudiante (Estudiante_id)
    REFERENCES Estudiante (id);
-- Reference:  Recursos_Laboratorios (table: Equipo)


ALTER TABLE Equipo ADD CONSTRAINT Recursos_Laboratorios FOREIGN KEY Recursos_Laboratorios (Laboratorios_id)
    REFERENCES Laboratorio (id);



-- End of file.


--INSERTAR ESTUDIANTE

INSERT INTO Estudiante 
VALUES (2091854, 'Daniel Tarquino','daniel.tarquino@mail.escuelaing.edu.co'); 

INSERT INTO Estudiante 
VALUES (2096579, 'Santiago Sossa','santiago.sossa@mail.escuelaing.edu.co'); 

INSERT INTO Estudiante 
VALUES (2390876, 'Leonardo Castro','leonardo.castro@mail.escuelaing.edu.co'); 

INSERT INTO Estudiante 
VALUES (2548765, 'Felipe Diaz','felipe.diaz@mail.escuelaing.edu.co'); 

INSERT INTO Estudiante 
VALUES (2889911,'Alejandro Villarraga','alejandro.villarraga@mail.escuelaing.edu.co'); 

INSERT INTO Estudiante 
VALUES (2334455, 'Camilo Nieves', 'camilo.nieves@mail.escuelaing.edu.co'); 

INSERT INTO Estudiante
VALUES (2119009, 'Camila Torres','camila.torres@mail.escuelaing.edu.co'); 

