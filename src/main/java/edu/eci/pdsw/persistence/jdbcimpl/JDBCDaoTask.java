/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistence.jdbcimpl;

import edu.eci.pdsw.entities.Task;
import edu.eci.pdsw.persistencee.DaoTask;
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
public class JDBCDaoTask implements DaoTask{
    Connection con;

    public JDBCDaoTask(Connection con) {
        this.con = con;
    }            
    
    @Override
    public void save(Task t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.        
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("insert into Bitacora(id, tipo, estado, comentario) values (?,?,?,?)");
            ps.setInt(1, t.getIdTask());
            ps.setString(2, t.getType());
            ps.setString(3, t.getStatus());
            ps.setString(4, t.getTaskCommnets());     
            
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
    public void UpdateEstado(int id, String estado) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.        
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("Update Tarea Set estado = ? Where id = ? ");
            ps.setInt(1, id);
            ps.setString(2,estado); 
            
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
    public Task load(int idtask) {
        PreparedStatement ps;
        Task tar = new Task();
        try{
            ps=con.prepareStatement("SELECT * from Task WHERE id = ?" );
            ps.setInt(1, idtask);
            ResultSet rs=ps.executeQuery();
            
            tar.setIdTask(rs.getInt("id"));
            tar.setType(rs.getString("tipo"));
            tar.setStatus(rs.getString("estado"));
            tar.setTaskCommnets(rs.getString("comentario"));
            
            
            
        }catch(SQLException ex) {
            try {
                throw new PersistenceException("An error ocurred while loading an order.",ex);
            } catch (PersistenceException ex1) {
                Logger.getLogger(JDBCDaoStudent.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return tar;
    }
    
    
}
