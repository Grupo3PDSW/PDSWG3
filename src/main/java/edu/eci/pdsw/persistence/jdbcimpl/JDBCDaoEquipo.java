/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistence.jdbcimpl;

import edu.eci.pdsw.entities.Equipo;
import edu.eci.pdsw.persistencee.DaoEquipo;
import edu.eci.pdsw.persistencee.PersistenceException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 2098167
 */
public class JDBCDaoEquipo implements DaoEquipo{

    Connection con;

    public JDBCDaoEquipo(Connection con) {
        this.con = con;      
    }
    
    @Override
    public void save(Equipo e ) {
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("INSERT INTO Equipo  VALUES (?,?,?)");
            ps.setInt(1, e.getId());
            ps.setInt(2, e.getLaboratorio_id());
            ps.setString(3, e.getDescripcion());        
            
            ps.execute();
            
        } catch (SQLException ex) {
            try {
                throw new PersistenceException("Error al guardar euipo.",ex);
            } catch (PersistenceException ex1) {
                Logger.getLogger(JDBCDaoBitacora.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    


    @Override
    public Equipo load(int id) {       
        PreparedStatement ps;
        Equipo equipo = new Equipo();
        try{
            ps=con.prepareStatement("SELECT * from Equipo WHERE id = ?" );
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
                       
           equipo.setId(rs.getInt("id"));
           equipo.setLaboratorio_id(rs.getInt(2));
           equipo.setDescripcion(rs.getString(3));
            
        }catch(SQLException ex) {
            try {
                throw new PersistenceException("An error ocurred while loading an order.",ex);
            } catch (PersistenceException ex1) {
                Logger.getLogger(JDBCDaoStudent.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return equipo;
    }
       
}
