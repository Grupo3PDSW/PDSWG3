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
    
}
