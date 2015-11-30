/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistence.jdbcimpl;

import edu.eci.pdsw.entities.Monitoria;
import edu.eci.pdsw.persistencee.DaoMonitoria;
import edu.eci.pdsw.persistencee.PersistenceException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 2101751
 */
public class JDBCDaoMonitoria implements DaoMonitoria{
    
      Connection con;

        public JDBCDaoMonitoria(Connection con) {
        this.con = con;
    }
        
        
        
        
        
    @Override
    public Monitoria load(int idMonitoria) {
        PreparedStatement ps;
        Monitoria moni = new Monitoria();
        try{
            ps=con.prepareStatement("Select * from Monitoria where id= ?" );
            ps.setInt(1, idMonitoria);
            ResultSet rs=ps.executeQuery();
            
            moni.setDarSoporte(rs.getString("DarSoporte"));
            moni.setLenguajeDeProgramacion(rs.getString("lenguajeProgramacion"));
            moni.setTema(rs.getString("tema"));
            
            
        }catch(SQLException ex) {
            try {
                throw new PersistenceException("An error ocurred while loading an order.",ex);
            } catch (PersistenceException ex1) {
                Logger.getLogger(JDBCDaoStudent.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return moni;
    }

    @Override
    public void save(Monitoria mo)  {
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("insert into Monitoria   values (?,?,?)" ,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,mo.getLenguajeDeProgramacion());
            ps.setInt(3,mo.getId());
            ps.setString(2, mo.getTema());
            ps.setString(4, mo.getDarSoporte());
            
            ps.execute();
            
            ResultSet rs=ps.getGeneratedKeys();
            
        } catch (SQLException ex) {
            try {
                throw new PersistenceException("Error al guardar monitoria .",ex);
            } catch (PersistenceException ex1) {
                Logger.getLogger(JDBCDaoBitacora.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    
    @Override
    public int consultarUltimoID() throws PersistenceException {
        PreparedStatement ps;
        int id = 0 ;
        try{
            ps=con.prepareStatement("SELECT id FROM `Monitoria` WHERE id = "
                                             + "(SELECT MAX( id ) FROM `Monitoria`)" );
            ps.execute();
            ResultSet rs=ps.executeQuery();
            
            id = (rs.getInt("id"));
            
            
        }catch(SQLException ex) {
            
                Logger.getLogger(JDBCDaoStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
          return id;
    }
        
}
   
        
    

