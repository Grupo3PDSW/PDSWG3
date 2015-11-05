package edu.eci.cosw.sampleapp.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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
 *      - CH3D: Realiza un reporte con las tareas discriminadas
 * 
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
  public void CH1ATest() {
	
  }

}
}
