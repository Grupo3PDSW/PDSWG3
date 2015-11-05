/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistence.jdbcimpl;

import edu.eci.pdsw.entities.Monitor;
import edu.eci.pdsw.persistencee.DaoMonitor;
import edu.eci.pdsw.persistencee.PersistenceException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 2101751
 */
public class JDBCDaoMonitor implements DaoMonitor {
    
    Connection con;

    public JDBCDaoMonitor(Connection con) {
        this.con = con;
    }  

    @Override
    public Monitor load(int idMonitor) throws PersistenceException {
        PreparedStatement ps;
        Monitor monitor = new Monitor();
        try{
            ps=con.prepareStatement("SELECT e.email, e.nombre, e.id, m.Turnos_id from Monitor as m inner join Estudiante as e WHERE e.id = ? AND m.Estudiantes_id= ? " );
            ps.setInt(1, idMonitor);
            ps.setInt(2, idMonitor);
            ResultSet rs=ps.executeQuery();
            
            monitor.setEmail(rs.getString(1));
            monitor.setIdStudent(rs.getInt(3));
            monitor.setIdTurn(rs.getInt(4));
            monitor.setName(rs.getString(2));
            
           return monitor;
        }catch(SQLException ex) {
            
                throw new PersistenceException("An error ocurred while loading an order.",ex);
       
        }
    }
}
