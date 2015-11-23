/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistence.jdbcimpl;

import java.util.Date;
import edu.eci.pdsw.entities.Bitacora;
import edu.eci.pdsw.entities.Monitoria;
import edu.eci.pdsw.entities.Student;
import edu.eci.pdsw.entities.Task;
import edu.eci.pdsw.entities.Turn;
import edu.eci.pdsw.persistencee.DaoBitacora;
import edu.eci.pdsw.persistencee.PersistenceException;
import edu.eci.pdsw.services.ServiceFacadeException;
import edu.eci.pdsw.services.ServicesFacade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author felipe
 */
public class JDBCDaoBitacora implements DaoBitacora{
    
    Connection con;

    public JDBCDaoBitacora(Connection con) {
        this.con = con;
    }            
    
    
    
    @Override
    public void save(Bitacora b) throws PersistenceException {
        PreparedStatement ps;
        try{
            
            if(b.getIdBit()==0){
                ps=con.prepareStatement("insert into Bitacora(descripcion, tarea_id,"
                    + "fecha, Monitoria_id, Monitor, Turno_id) "
                        + "values (?,?,?,?,?,?)" ,Statement.RETURN_GENERATED_KEYS);
                ps.setInt(5, b.getMonitor_id());
                ps.setInt(6 , b.getTurno_id());
                ps.setString(1, b.getDescription());  
                ps.setInt(2, b.getTaskid());
                ps.setDate(3, (java.sql.Date) b.getFecha());
                ps.setInt(4, b.getMonitoria_id());
                ps.execute();
                ResultSet rs=ps.getGeneratedKeys();
                if(rs.next()){
                    b.setIdBit(rs.getInt("id"));
                }
                
            }   
              
        }catch (SQLException ex) {
            throw new PersistenceException("An error ocurred while loading an order.",ex);
        }
    }

    
    
    @Override
    public Bitacora load(int idBitacora) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
