/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.persistence.jdbcimpl;

import edu.eci.pdsw.samples.entities.Bitacora;
import edu.eci.pdsw.samples.persistencee.DaoBitacora;
import edu.eci.pdsw.samples.persistencee.PersistenceException;
import edu.eci.pdsw.samples.services.ServiceFacadeException;
import edu.eci.pdsw.samples.services.ServicesFacade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
    /**
     * 
     * @param b contiene una bitacora que es usada para realizar la insersion en la bb 
     */
    @Override
    public void save(Bitacora b) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.        
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("insert into Bitacora(Monitor_Estudiantes_id, Monitor_Turnos_id, "
                    + "descripcion, id, tarea_id, fecha, Monitoria_id) values (?,?,?,?,?,?,?)");
            ps.setInt(1, b.getBitMonitor().getIdStudent());
            ps.setInt(2, b.getBitMonitor().getIdTurn());
            ps.setString(3, b.getDescription());
            ps.setInt(4, b.getIdBit());     
            ps.setInt(5, b.getBitTask().getIdTask());
            ps.setDate(6, b.getFecha());
            ps.setInt(7, b.getBitMonitoria().getIdMonitoria());
            ps.execute();
            
        } catch (SQLException ex) {
            try {
                throw new PersistenceException("Error.",ex);
            } catch (PersistenceException ex1) {
                Logger.getLogger(JDBCDaoBitacora.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    
    @Override
    public Bitacora load(int idBitacora)throws PersistenceException {
        return null;
    /*    PreparedStatement ps;
        Bitacora bitacora = new Bitacora();
        try{
            ps=con.prepareStatement("SELECT * from Bitacora WHERE id = ?" );
            ps.setInt(1, idBitacora);
            ResultSet rs=ps.executeQuery();
            
            bitacora.setDescription(rs.getString("descripcion"));
            bitacora.setIdBit(rs.getInt("id"));
            bitacora.setFecha(rs.getDate("fecha"));
            bitacora.setBitMonitor(ServicesFacade.getInstance("applicationconfig.properties").consultarMonitor(rs.getInt("Monitor_Estudiantes_id")));
            
            return bitacora;
        }catch(SQLException ex) {
            
                throw new PersistenceException("An error ocurred while loading an order.",ex);
            
            
        } catch (ServiceFacadeException ex) {
            Logger.getLogger(JDBCDaoBitacora.class.getName()).log(Level.SEVERE, null, ex);
        }
        //return stu;*/
    }
    
    
}
