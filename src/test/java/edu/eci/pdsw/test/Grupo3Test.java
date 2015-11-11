package edu.eci.pdsw.test;

import edu.eci.pdsw.entities.Equipo;
import edu.eci.pdsw.entities.Laboratorio;
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
 *      - CH1B: Reporta problemas faltando algun dato no exigido (Comentarios adicionales).
 *      - CH1C: Reporta problemas faltando algun dato exigido (Descripcion, laboratorio, equipo etc.).
 *      
 * 
 * <HU2  (13) Gestión de la bitácora>
 *      - CH2A: Realiza una entrada a la bitacora correctamente sin faltar datos.
 *      - CH2B: Realiza una entrada a la bitacora sobre una tarea que no esta   en el planeador como pendiente 
 *      - CH2C: Realiza una entrada sobre una tarea sin reportar su estado (resuelto o avanzado)
 *      - CH2D: Realiza una entrada sobre una faltando datos 
 *      - CH2E: Realiza una entrada sobre un soporte academico faltando datos.
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
    // CH1B: Reporta problemas faltando algun dato no exigido (Comentarios adicionales).
    public void CH1BTest() {

    }


    @Test
    // CH1C: Reporta problemas faltando algun dato exigido (Descripcion, laboratorio, equipo etc.).
    public void CH1CTest() {

    }
    @Test
    //CH2A: Realiza una entrada a la bitacora correctamente sin faltar datos.
    public void CH2ATest() {

    }

    @Test
    //CH2B: Realiza una entrada a la bitacora sobre una tarea que no esta   en el planeador como pendiente 
    public void CH2BTest() {

    }
    @Test
    //CH2C: Realiza una entrada sobre una tarea sin reportar su estado (resuelto o avanzado)
    public void CH2CTest() {

    }


    @Test
    //CH2D: Realiza una entrada sobre una faltando datos 
    public void CH2DTest() {

    }
    @Test
    //CH2E: Realiza una entrada sobre un soporte academico faltando datos.
    public void CH2ETest() {

    }

    @Test
    //CH3A: Realiza un reporte de manera correcta.
    public void CH3ATest() {

    }
    @Test
    //CH3B: Realiza un reporte con seleccion de intervalo de fechas.
    public void CH3BTest() {

    }


    @Test
    //CH3C: Realiza un reporte con seleccion de fechas organizados por el top N de lenguajes.
    public void CH3CTest() {

    }
    @Test
    //CH3D: Realiza un reporte con las tareas discriminadas.
    public void CH3DTest() {

    }


    }
    }
