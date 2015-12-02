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
import java.util.Date;
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
        HashSet<Report> reportes = new HashSet<>();
        try{
            ps=con.prepareStatement("SELECT Bitacora.Monitor, Estudiante.Nombre,COUNT(Tarea.id), Tarea.tipo\n" +
                                    "FROM Bitacora, Tarea, Estudiante\n" +
                                    "WHERE Bitacora.tarea_id = Tarea.id AND Bitacora.Monitor = Estudiante.id AND \n" +
                                    "(Bitacora.fecha BETWEEN ? AND ?)\n" +
                                    "GROUP BY Tarea.id" );
            
                 
            ps.setDate(1,new java.sql.Date(fecha1.getTime()));
            ps.setDate(2,new java.sql.Date(fecha2.getTime()));
            
            
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

            

         
            
            
        }catch(SQLException ex) {
           
                throw new PersistenceException("Error al cargar el reporte 1",ex);
            
        }
        return reportes;
    }

    @Override
    public HashSet<Report> loadSegundo(Date fecha1, Date fecha2) throws PersistenceException {
        PreparedStatement ps1;
        HashSet<Report> reportesSegundo = new HashSet<>();
        try{
            ps1=con.prepareStatement("SELECT Estudiante.id AS Monitor,Monitoria.lenguajeProgramacion AS Lenguajes_Mas_Consultados, Monitoria.tema, Monitoria.DarSoporte AS Se_Dio_Soporte, COUNT(Monitoria.lenguajeProgramacion)AS Cantidad_Monitoria\n" +
"FROM Monitoria,Estudiante, Bitacora\n" +
"WHERE Monitoria.id = Bitacora.Monitoria_id AND Estudiante.id=Bitacora.Monitor AND\n" +
"(Bitacora.fecha BETWEEN ? AND ?)\n" +
"GROUP BY Monitoria.tema \n" +
"ORDER BY COUNT(Monitoria.lenguajeProgramacion) DESC" );
            
           
           
            ps1.setDate(1,new java.sql.Date(fecha1.getTime()));
            ps1.setDate(2,new java.sql.Date(fecha2.getTime()));
            
            ResultSet rs1=ps1.executeQuery();
            while(rs1.next())
            {
            Report r = new Report();
            r.setCodigoMonitor(rs1.getInt(1));
            r.setLenguajeProgramacion(rs1.getString(2));
            r.setTemaMonitoria(rs1.getString(3));
            r.setSoporte(rs1.getString(4));
            r.setMonitorias(rs1.getInt(5));
            reportesSegundo.add(r);
            }
        
        } catch (SQLException ex) {
             throw new PersistenceException("Error al cargar el reporte 2",ex);
         }
         return reportesSegundo;
    }

  public HashSet<Report> loadHoras(Date fecha1, Date fecha2) throws PersistenceException {
        PreparedStatement ps2;
        HashSet<Report> reportesHoras = new HashSet<>();
        try{
            ps2=con.prepareStatement("SELECT estudiante_id, nombre, SUM(TIMESTAMPDIFF(hour,horainicio, horafin))\n" +
"FROM Turno, Estudiante, Bitacora\n" +
"WHERE Turno.Estudiante_id = Estudiante.id AND Turno.id=Bitacora.Turno_id AND (Bitacora.fecha BETWEEN ? AND ?)\n" +
"GROUP BY Turno.Estudiante_id;" );
            
           
           
            ps2.setDate(1,new java.sql.Date(fecha1.getTime()));
            ps2.setDate(2,new java.sql.Date(fecha2.getTime()));
            
            ResultSet rs2=ps2.executeQuery();
            while(rs2.next())
            {
            Report r = new Report();
            r.setCodigoMonitor(rs2.getInt(1));
            r.setNombreMonitor(rs2.getString(2));
            r.setHoras(rs2.getInt(3));
            reportesHoras.add(r);
            }
        
        } catch (SQLException ex) {
             throw new PersistenceException("Error al cargar el reporte de las horas",ex);
         }
         return reportesHoras;
    }
    
}