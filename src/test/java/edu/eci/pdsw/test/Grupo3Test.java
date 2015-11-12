package edu.eci.pdsw.test;

import edu.eci.pdsw.entities.Bitacora;
import edu.eci.pdsw.entities.Equipo;
import edu.eci.pdsw.entities.Laboratorio;
import edu.eci.pdsw.entities.Monitoria;
import edu.eci.pdsw.entities.Problem;
import edu.eci.pdsw.entities.Student;
import edu.eci.pdsw.services.ServiceFacadeException;
import edu.eci.pdsw.services.ServicesFacade;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.LinkedList;
import org.junit.After;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author 2098167 Leonardo Castro Susa
 * 
 * 
 *     <   CLASES DE EQUIVALENCIA >
 *  
 * <HU1  (3) Reporte de problemas>
 *      - CH1A: Reporta problemas de manera correcta.
 *      - CH1B: Reporta problemas con  un id repetido (no deberia reportar ).
 *      
 * 
 * <HU2  (13) Gestión de la bitácora>
 *      - CH2A: Realiza una entrada a la bitacora correctamente sin faltar datos.
 *      - CH2B: Realiza una entrada a la bitacora con un id repetido (no deberia  ingresar )
 * 
 * 
 * <HU3  (8) Reporte de monitores>
 * 
 *      - CH3A: Realiza un reporte de manera correcta.
 *      - CH3B: Realiza un reporte con seleccion de intervalo de fechas.
 *      - CH3C: Realiza un reporte con seleccion de fechas organizados por el top N de lenguajes.
 *      - CH3D: Realiza un reporte con las tareas discriminadas.
 *   
 * 
 */


public class Grupo3Test {

public class AppTest {

     @Before
    public void setUp() {
    }

    @After
    public void clearDB() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:file:./target/db/testdb;MODE=MYSQL", "sa", "");
        Statement stmt = conn.createStatement();
        stmt.execute("delete from Bitacora");
        stmt.execute("delete from Equipo");
        stmt.execute("delete from Estudiante ");
        stmt.execute("delete from Laboratorio");
        stmt.execute("delete from Monitor");
        stmt.execute("delete from Monitoria");
        stmt.execute("delete from Problema");
        stmt.execute("delete from Tarea");
        stmt.execute("delete from Turno");
        
        conn.commit();
        conn.close();
    }
    
    @Test
    //CH1A: Reporta problemas basicos de manera correcta.
    public void CH1ATest() throws SQLException, ServiceFacadeException {
        Connection conn = DriverManager.getConnection("jdbc:h2:file:./target/db/testdb;MODE=MYSQL", "sa", "");        
        Statement stmt = conn.createStatement();
        stmt.execute("insert into Estudiante values (2098167,'Pepito Perez','ejemplo@test.com',false))"); 
        stmt.execute("insert into Laboratorio values (1,'prueba')");
        stmt.execute("insert into Equipo values (1,1,'Asombrosos 120 Mb de RAM')");
        stmt.execute("insert into Problema values ('Esta lento',1,1,'2015-11-01 10:00:00',2098167)");       
        conn.commit();
        Date d = new Date(2015,11,01,10,00,00)  ;     
        Problem pro;
         pro = new Problem ("Esta lento",1,1,d,2098167);
        
        ServicesFacade f=ServicesFacade.getInstance("h2-applicationconfig.properties");
        Problem p=f.consultarProblem(1);
         
        assertTrue(pro==p);
        

    }
    @Test
    // CH1B: Reporta problemas con un id repetido (no deberia reportar ).
    public void CH1BTest() throws SQLException, ServiceFacadeException {
        
        //Se intentara ingresar un problema sin un id repetido lo cual no deberia ser posible 
        
        Connection conn = DriverManager.getConnection("jdbc:h2:file:./target/db/testdb;MODE=MYSQL", "sa", "");        
        Statement stmt = conn.createStatement();
        stmt.execute("insert into Estudiante values (2098167,'Pepito Perez','ejemplo@test.com',false))");  
        stmt.execute("insert into Laboratorio values (1,'prueba')");
        stmt.execute("insert into Equipo values (1,1,'Asombrosos 120 Mb de RAM')");
        stmt.execute("insert into Problema values ('Esta lento',1,1,'2015-11-01 10:00:00',2098167)");  
        stmt.execute("insert into Problema values ('Esta REEEELENTOOOO',1,1,'2015-11-01 10:10:00',2098167)");  
        conn.commit();
        Date d = new Date(2015,11,01,10,00,00)  ;     
        Problem pro;
         pro = new Problem ("Esta lento",1,1,d,2098167);
        
        ServicesFacade f=ServicesFacade.getInstance("h2-applicationconfig.properties");
        Problem p=f.consultarProblem(1);
         
        assertTrue(pro==p);   
    }



    @Test
    //CH2A: Realiza una entrada a la bitacora correctamente sin faltar datos.
    public void CH2ATest() throws SQLException, ServiceFacadeException {        
        Connection conn = DriverManager.getConnection("jdbc:h2:file:./target/db/testdb;MODE=MYSQL", "sa", "");        
        Statement stmt = conn.createStatement();
        
        stmt.execute("insert into Estudiante values (2020,'JUan Perez','ejemplo@test.com',true))"); 
        stmt.execute("INSERT INTO Turno VALUES ('2015-11-01 07:00:00','2015-11-01 10:00:00',1,'Lunes',2020)");
        stmt.execute("INSERT INTO Tarea VALUES(1,'Instalacion de software','avanzado','La instalacion esta en proceso,falta instalar el parche') ");
        stmt.execute("INSERT INTO Monitoria  VALUES('Python','arrays',1,'se logro dar soporte') ");
        stmt.execute("INSERT INTO Bitacora  VALUES('se realizo la primer monitoria del dia, y se cumplio con una tarea',1,1,'2015-11-01 10:00:00',1,2020,1); ");
        stmt.execute("INSERT INTO Bitacora  VALUES('no hice nada ',1,1,'2015-11-01 10:00:00',1,2020,1); ");
        conn.commit();
        
        Date d  ;   
         d = new Date(2015,11,01,10,00,00);
         
        Bitacora mo;
         mo = new Bitacora ("se realizo la primer monitoria del dia, y se cumplio con una tarea",1,1, (java.sql.Date) d,1,2020,1);
        
         
        ServicesFacade f=ServicesFacade.getInstance("h2-applicationconfig.properties");
        Bitacora b=f.consultarBitacora(1);
         
        assertTrue(mo==b);  

    }

    @Test
    //CH2B: Realiza una entrada a la bitacora con un id repetido (no deberia )
    public void CH2BTest() throws SQLException, ServiceFacadeException {
        Connection conn = DriverManager.getConnection("jdbc:h2:file:./target/db/testdb;MODE=MYSQL", "sa", "");        
        Statement stmt = conn.createStatement();
        
        stmt.execute("insert into Estudiante values (2020,'JUan Perez','ejemplo@test.com',true))"); 
        stmt.execute("INSERT INTO Turno VALUES ('2015-11-01 07:00:00','2015-11-01 10:00:00',1,'Lunes',2020)");
        stmt.execute("INSERT INTO Tarea VALUES(1,'Instalacion de software','avanzado','La instalacion esta en proceso,falta instalar el parche') ");
        stmt.execute("INSERT INTO Monitoria  VALUES('Python','arrays',1,'se logro dar soporte') ");
        stmt.execute("INSERT INTO Bitacora  VALUES('se realizo la primer monitoria del dia, y se cumplio con una tarea',1,1,'2015-11-01 10:00:00',1,2020,1); ");
        conn.commit();
        
        Date d  ;   
         d = new Date(2015,11,01,10,00,00);
         
        Bitacora mo;
         mo = new Bitacora ("se realizo la primer monitoria del dia, y se cumplio con una tarea",1,1, (java.sql.Date) d,1,2020,1);
        
         
        ServicesFacade f=ServicesFacade.getInstance("h2-applicationconfig.properties");
        Bitacora b=f.consultarBitacora(1);
         
        assertTrue(mo==b);  

    }

 
    }

    
 
     /*
    }
    
    @Test
    //CH3B: Realiza un reporte con seleccion de intervalo de fechas.
    public void CH3BTest() {
        
    }*/

}
