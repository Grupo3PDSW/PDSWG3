/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistence.jdbcimpl;

import edu.eci.pdsw.entities.Laboratorio;
import edu.eci.pdsw.persistencee.PersistenceException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 2098167
 */
public class JDBCDaoLaboratorio {
    
    Connection con;

    public JDBCDaoLaboratorio (Connection con) {
        this.con = con;      
    }
    
    public void save(Laboratorio l ) {
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("INSERT INTO Laboratorio  VALUES (?,?)");
            ps.setInt(1, l.getId());
            ps.setString(2, l.getDescripcion());
                
            
            ps.execute();
            
        } catch (SQLException ex) {
            try {
                throw new PersistenceException("Error al guardar euipo.",ex);
            } catch (PersistenceException ex1) {
                Logger.getLogger(JDBCDaoBitacora.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    


    public Laboratorio load(int id) {       
        PreparedStatement ps;
        Laboratorio laboratorio = new Laboratorio();
        try{
            ps=con.prepareStatement("SELECT * from Equipo Laboratorio id = ?" );
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();            
            laboratorio.setId(rs.getInt(1));
            laboratorio.setDescripcion(rs.getString(2));
                       
          
          
            
        }catch(SQLException ex) {
            try {
                throw new PersistenceException("An error ocurred while loading an order.",ex);
            } catch (PersistenceException ex1) {
                Logger.getLogger(JDBCDaoStudent.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return laboratorio;
    }
       
}