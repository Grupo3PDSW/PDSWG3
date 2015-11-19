/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistence.jdbcimpl;

import edu.eci.pdsw.entities.Report;
import edu.eci.pdsw.persistencee.DaoReport;
import edu.eci.pdsw.persistencee.PersistenceException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.Query;

/**
 *
 * @author 2091854
 */
public class JDBCDaoReport implements DaoReport{

     Connection con;

    public JDBCDaoReport(Connection con) {
        this.con = con;
    }
    
    /**
     *
     * @param fecha1
     * @param fecha2
     * @return
     * @throws edu.eci.pdsw.persistencee.PersistenceException
     */
    @Override
    public HashSet<Report> load(Date fecha1, Date fecha2) throws PersistenceException{
        PreparedStatement ps;
        PreparedStatement ps1;
        HashSet<Report> reportes = new HashSet<>();
        try{
            ps=con.prepareStatement("SELECT Bitacora.Monitor, Estudiante.Nombre,COUNT(Tarea.id), Tarea.tipo\n" +
                                    "FROM Bitacora, Tarea, Estudiante\n" +
                                    "WHERE Bitacora.tarea_id = Tarea.id AND Bitacora.Monitor = Estudiante.id AND \n" +
                                    "(Bitacora.fecha BETWEEN ? AND ?)\n" +
                                    "GROUP BY Tarea.id" );
            
                 
            ps.setDate(1, fecha1);
            ps.setDate(2, fecha2);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
            Report r = new Report();
            r.setCodigoMonitor(rs.getInt(1));
            r.setNombreMonitor(rs.getString(2));
            r.setTareas(rs.getInt(3));
            r.setTipo(rs.getString(4));
            reportes.add(r);
            }

            ps1=con.prepareStatement("SELECT Monitoria.lenguajeProgramacion AS Lenguajes_Mas_Consultados, Monitoria.tema, Monitoria.DarSoporte AS Se_Dio_Soporte, COUNT(Monitoria.lenguajeProgramacion)AS Cantidad_Monitoria, Estudiante.id AS Monitor\n" +
"FROM Monitoria,Estudiante, Bitacora\n" +
"WHERE Estudiante.Monitor ='Y' AND Monitoria.id = Bitacora.Monitoria_id AND Estudiante.id=Bitacora.Monitor AND\n" +
"(Bitacora.fecha BETWEEN ? AND ?)\n" +
"GROUP BY Monitoria.tema ORDER BY COUNT(Monitoria.lenguajeProgramacion) DESC" );
            
            ps1.setDate(1, fecha1);
            ps1.setDate(2, fecha2);
            ResultSet rs1=ps1.executeQuery();
            while(rs.next())
            {
            Report r = new Report();
            r.setLenguajeProgramacion(rs1.getString(1));
            r.setTemaMonitoria(rs.getString(2));
            r.setSoporte(rs.getString(3));
            r.setMonitorias(rs.getInt(4));
            reportes.add(r);
            }

         
            
            
        }catch(SQLException ex) {
           
                throw new PersistenceException("An error ocurred while loading an order.",ex);
            
        }
        return reportes;
    }

    
    
}
