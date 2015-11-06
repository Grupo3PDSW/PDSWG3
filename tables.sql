-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2015-11-06 03:04:51.306




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





-- foreign keys
-- Reference:  Bitacora_Estudiante (table: Bitacora)


ALTER TABLE Bitacora ADD CONSTRAINT Bitacora_Estudiante FOREIGN KEY Bitacora_Estudiante (Monitor)
    REFERENCES Estudiante (id);
-- Reference:  Bitacora_Monitoria (table: Bitacora)


ALTER TABLE Bitacora ADD CONSTRAINT Bitacora_Monitoria FOREIGN KEY Bitacora_Monitoria (Monitoria_id)
    REFERENCES Monitoria (id);
-- Reference:  Bitacora_Tarea (table: Bitacora)


ALTER TABLE Bitacora ADD CONSTRAINT Bitacora_Tarea FOREIGN KEY Bitacora_Tarea (tarea_id)
    REFERENCES Tarea (id);
-- Reference:  Bitacora_Turno (table: Bitacora)


ALTER TABLE Bitacora ADD CONSTRAINT Bitacora_Turno FOREIGN KEY Bitacora_Turno (Turno_id)
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
-- Reference:  Turno_Estudiante (table: Turno)


ALTER TABLE Turno ADD CONSTRAINT Turno_Estudiante FOREIGN KEY Turno_Estudiante (Estudiante_id)
    REFERENCES Estudiante (id);



-- End of file.


--INSERTAR ESTUDIANTES
INSERT INTO Estudiante 
VALUES (2091854, 'Daniel Tarquino','daniel.tarquino@mail.escuelaing.edu.co','N'); 

INSERT INTO Estudiante 
VALUES (2096579, 'Santiago Sossa','santiago.sossa@mail.escuelaing.edu.co','N'); 

INSERT INTO Estudiante 
VALUES (2390876, 'Leonardo Castro','leonardo.castro@mail.escuelaing.edu.co','N'); 

INSERT INTO Estudiante 
VALUES (2548765, 'Felipe Diaz','felipe.diaz@mail.escuelaing.edu.co','N'); 

INSERT INTO Estudiante 
VALUES (2889911,'Alejandro Villarraga','alejandro.villarraga@mail.escuelaing.edu.co','N'); 

INSERT INTO Estudiante 
VALUES (2334455, 'Camilo Nieves', 'camilo.nieves@mail.escuelaing.edu.co','Y'); 

INSERT INTO Estudiante
VALUES (2119009, 'Camila Torres','camila.torres@mail.escuelaing.edu.co','Y'); 

--INSERTAR LABORATORIOS
INSERT INTO Laboratorio 
VALUES(1,'Laboratorio de Redes'); 

INSERT INTO Laboratorio 
VALUES (2,'Laboratorio de Desarrollo de Software'); 

INSERT INTO Laboratorio
VALUES(3, 'Laboratorio de Plataformas Computacionales'); 

--INSERTAR EQUIPOS
INSERT INTO Equipo
VALUES (01,1,'Este COMPUTADOR tiene su hardware completo y su software esta compuesto de Linux y windows'); 

INSERT INTO Equipo
VALUES (02,1,'Este SERVIDOR tiene su hardware al dia'); 

INSERT INTO Equipo
VALUES (03,1,'Este ROUTER tiene su hardware completo (HACE POCO SE HIZO CAMBIO DE MEMORIA RAM');

INSERT INTO Equipo
VALUES (04,1,'Este COMPUTADOR tiene su hardware completo y su software esta compuesto de Linux y windows');  

INSERT INTO Equipo
VALUES (05,1,'Este COMPUTADOR tiene su hardware completo y su software esta compuesto de Linux y windows'); 

INSERT INTO Equipo
VALUES (06,1,'Este ROUTER tiene su hardware completo (HACE POCO SE HIZO CAMBIO DE MEMORIA RAM');

INSERT INTO Equipo
VALUES (07,1,'Este ROUTER tiene su hardware completo (HACE POCO SE HIZO CAMBIO DE MEMORIA RAM');

INSERT INTO Equipo
VALUES (08,2,'Este COMPUTADOR tiene su hardware completo y su software esta compuesto de xUbuntu y windows8.1'); 

INSERT INTO Equipo
VALUES (09,2,'Este COMPUTADOR tiene su hardware completo y su software esta compuesto de xUbuntu y windows8.1'); 

INSERT INTO Equipo
VALUES (10,2,'Este COMPUTADOR tiene su hardware completo y su software esta compuesto de xUbuntu y windows8.1'); 

INSERT INTO Equipo
VALUES (11,2,'Este COMPUTADOR tiene su hardware completo y su software esta compuesto de xUbuntu y windows8.1');

INSERT INTO Equipo
VALUES (12,2,'Este COMPUTADOR tiene su hardware completo y su software esta compuesto de xUbuntu y windows8.1');  

INSERT INTO Equipo
VALUES (13,3,'Este COMPUTADOR tiene su hardware completo y su software esta compuesto de Linux y windows8.1'); 

INSERT INTO Equipo
VALUES (14,3,'Este COMPUTADOR tiene su hardware completo y su software esta compuesto de Linux y windows8.1'); 

INSERT INTO Equipo
VALUES (15,3,'Este COMPUTADOR tiene su hardware completo y su software esta compuesto de Linux y windows8.1'); 

--INSERTAR TURNOS

INSERT INTO Turno 
VALUES ('2015-11-01 07:00:00','2015-11-01 10:00:00',1,'Lunes',2119009); 

INSERT INTO Turno 
VALUES ('2015-11-01 10:00:00','2015-11-01 13:00:00',2,'Lunes',2334455); 

INSERT INTO Turno 
VALUES ('2015-11-01 13:00:00','2015-11-01 16:00:00',3,'Lunes',2119009);

INSERT INTO Turno 
VALUES ('2015-11-01 16:00:00','2015-11-01 19:00:00',4,'Lunes',2334455); 

INSERT INTO Turno 
VALUES ('2015-11-02 07:00:00','2015-11-02 10:00:00',5,'Martes',2119009); 

INSERT INTO Turno 
VALUES ('2015-11-02 10:00:00','2015-11-02 13:00:00',6,'Martes',2334455); 

INSERT INTO Turno 
VALUES ('2015-11-02 13:00:00','2015-11-02 16:00:00',7,'Martes',2119009);

INSERT INTO Turno 
VALUES ('2015-11-02 16:00:00','2015-11-02 19:00:00',8,'Martes',2334455);

INSERT INTO Turno 
VALUES ('2015-11-03 07:00:00','2015-11-03 10:00:00',9,'Miercoles',2119009); 

INSERT INTO Turno 
VALUES ('2015-11-03 10:00:00','2015-11-03 13:00:00',10,'Miercoles',2334455); 

INSERT INTO Turno 
VALUES ('2015-11-03 13:00:00','2015-11-03 16:00:00',11,'Miercoles',2119009);

INSERT INTO Turno 
VALUES ('2015-11-03 16:00:00','2015-11-03 19:00:00',12,'Miercoles',2334455); 
  
INSERT INTO Turno 
VALUES ('2015-11-04 07:00:00','2015-11-04 10:00:00',13,'Jueves',2119009); 

INSERT INTO Turno 
VALUES ('2015-11-04 10:00:00','2015-11-04 13:00:00',14,'Jueves',2334455); 

INSERT INTO Turno 
VALUES ('2015-11-04 13:00:00','2015-11-04 16:00:00',15,'Jueves',2119009);

INSERT INTO Turno 
VALUES ('2015-11-04 16:00:00','2015-11-04 19:00:00',16,'Jueves',2334455); 
  
INSERT INTO Turno 
VALUES ('2015-11-05 07:00:00','2015-11-05 10:00:00',17,'Viernes',2119009); 

INSERT INTO Turno 
VALUES ('2015-11-05 10:00:00','2015-11-05 13:00:00',18,'Viernes',2334455); 

INSERT INTO Turno 
VALUES ('2015-11-05 13:00:00','2015-11-05 16:00:00',19,'Viernes',2119009);

INSERT INTO Turno 
VALUES ('2015-11-05 16:00:00','2015-11-05 19:00:00',20,'Viernes',2334455); 
 
--INSERTAR TAREAS
INSERT INTO Tarea
VALUES(1,'Instalacion de software','avanzado','La instalacion esta en proceso,falta instalar el parche'); 

INSERT INTO Tarea
VALUES(2,'Solucion a problemas reportados','resuelto','Se soluciono el problema con el router');

INSERT INTO Tarea
VALUES(3,'Solucion a problemas reportados','resuelto','se pudo solucionar el ingreso al usuario');  

--INSERTAR PROBLEMAS
INSERT INTO Problema 
VALUES('No puedo entrar al sistema con mi usuario',1,1,'2015-09-11 01:19:50',2091854); 

INSERT INTO Problema 
VALUES('Necesito instalar ubuntu',2,2,'2015-11-05 16:19:50',2096579); 


INSERT INTO Problema 
VALUES('EL router dejo de funcionar',7,3,'2015-11-02 11:05:50',2334455);

--INSERTAR MONITORIAS
INSERT INTO Monitoria 
VALUES('Python','arrays',1,'se logro dar soporte'); 

INSERT INTO Monitoria 
VALUES('Java','creacion de objetos',2,'se logro dar soporte');

INSERT INTO Monitoria 
VALUES('sql','triggers',3,'no se logro dar soporte'); 

INSERT INTO Monitoria 
VALUES('Java','Metodo para obtener datos de un hash',4,'se logro dar soporte');

INSERT INTO Monitoria 
VALUES('sql','insetar datos a una base de datos',5,'se logro dar soporte');   

--INSERTAR BITACORA
INSERT INTO Bitacora
VALUES('se realizo la primer monitoria del dia, y se cumplio con una tarea',1,1,'2015-11-01 10:00:00',1,2119009,1); 

INSERT INTO Bitacora
VALUES('se realizo una monitora y debido a esto no pude realizar tareas pendientes',2,NULL,'2015-11-01 13:00:00',2,2334455,2);

INSERT INTO Bitacora
VALUES('No hubo monitorias, se realizo una tarea',3,2,'2015-11-01 16:00:00',NULL,2119009,3);

INSERT INTO Bitacora
VALUES('Hubo monitorias y se realizo una tarea',4,3,'2015-11-01 19:00:00',3,2334455,4);


INSERT INTO Bitacora
VALUES('Se colaboro al profesor Hector con un salon',5,NULL,'2015-11-02 10:00:00',NULL,2119009,5);


INSERT INTO Bitacora
VALUES('Se colaboro al profesor Gerardo con un salon',6,NULL,'2015-11-02 13:00:00',NULL,2334455,6);


INSERT INTO Bitacora
VALUES('Se colaboro al grupo de GLECIX con libros',7,NULL,'2015-11-02 16:00:00',NULL,2119009,7);


INSERT INTO Bitacora
VALUES('Sin novedades',8,NULL,'2015-11-02 19:00:00',NULL,2334455,8);


INSERT INTO Bitacora
VALUES('Sin novedades',9,NULL,'2015-11-03 10:00:00',NULL,2119009,9);

INSERT INTO Bitacora
VALUES('Sin novedades',10,NULL,'2015-11-03 13:00:00',NULL,2334455,10);


INSERT INTO Bitacora
VALUES('Sin novedades',11,NULL,'2015-11-03 16:00:00',NULL,2119009,11);


INSERT INTO Bitacora
VALUES('Sin novedades',12,NULL,'2015-11-03 19:00:00',NULL,2334455,12);


INSERT INTO Bitacora
VALUES('Sin novedades',13,NULL,'2015-11-04 10:00:00',NULL,2119009,13);


INSERT INTO Bitacora
VALUES('Sin novedades',14,NULL,'2015-11-04 13:00:00',NULL,2334455,14);


INSERT INTO Bitacora
VALUES('Sin novedades',15,NULL,'2015-11-04 16:00:00',NULL,2119009,15);

INSERT INTO Bitacora
VALUES('Sin novedades',16,NULL,'2015-11-04 19:00:00',NULL,2334455,16);


INSERT INTO Bitacora
VALUES('Sin novedades',17,NULL,'2015-11-05 10:00:00',NULL,2119009,17);

INSERT INTO Bitacora
VALUES('Sin novedades',18,NULL,'2015-11-05 13:00:00',NULL,2334455,18);

INSERT INTO Bitacora
VALUES('Sin novedades',19,NULL,'2015-11-05 16:00:00',NULL,2119009,19);


INSERT INTO Bitacora
VALUES('Sin novedades',20,NULL,'2015-11-05 19:00:00',NULL,2334455,20);

