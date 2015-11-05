/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.persistence.jdbcimpl;

import edu.eci.pdsw.samples.entities.Turn;
import edu.eci.pdsw.samples.persistencee.DaoTurn;
import edu.eci.pdsw.samples.persistencee.PersistenceException;
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

public class JDBCDaoTurn implements DaoTurn{

    Connection con;
    
    JDBCDaoTurn(Connection con) {
        this.con = con;
    }  

    @Override
    public void save(Turn t) {
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("insert into Turn(horaInicio, horaFinal, idTurn, dia) values (?,?,?,?)");
            ps.setDate(1, t.getHoraInicio());
            ps.setDate(2, t.getHoraFinal());
            ps.setInt(3, t.getIdTurn());
            ps.setString(4, t.getDia());
            
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
    public Turn load(int idTurn) {
       PreparedStatement ps;
        Turn turn = new Turn();
        try{
            ps=con.prepareStatement("SELECT * from Turno WHERE id = ?" );
            ps.setInt(1, idTurn);
            ResultSet rs=ps.executeQuery();
            
            turn.setIdTurn(rs.getInt("idTurn"));
            turn.setHoraInicio(rs.getDate("horaInicio"));
            turn.setHoraFinal(rs.getDate("horaFinal"));
            turn.setDia(rs.getString("dia"));
            
            
        }catch(SQLException ex) {
            try {
                throw new PersistenceException("An error ocurred while loading an order.",ex);
            } catch (PersistenceException ex1) {
                Logger.getLogger(JDBCDaoStudent.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return turn;
    }
    
}

