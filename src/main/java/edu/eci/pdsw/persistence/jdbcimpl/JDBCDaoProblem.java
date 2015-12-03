/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistence.jdbcimpl;


import edu.eci.pdsw.entities.Equipo;
import edu.eci.pdsw.entities.Problem;
import edu.eci.pdsw.persistencee.DaoProblem;
import edu.eci.pdsw.persistencee.PersistenceException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 2101751
 */
public class JDBCDaoProblem implements DaoProblem{
    
      Connection con;

    public JDBCDaoProblem(Connection con) {
        this.con = con;
    }

    @Override
    public void save(Problem p) {
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("insert into Problema   values (?,?,?,?,?)");
            ps.setString(1, p.getDecription());
            ps.setInt(2, p.getIdEquipo());
            ps.setInt(3, p.getIdProblem());
            ps.setDate(4, (Date) p.getDate());
            ps.setInt(5,p.getEstudiante_id());
            
            ps.execute();
            
        } catch (SQLException ex) {
            try {
                throw new PersistenceException("Error al guardar problema .",ex);
            } catch (PersistenceException ex1) {
                Logger.getLogger(JDBCDaoBitacora.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    @Override
    public Problem load(int idProblem) {
        PreparedStatement ps;
        Problem p = new Problem();
        try{
            ps=con.prepareStatement("SELECT * from Problema WHERE id = ?" );
            ps.setInt(1, idProblem);
            ResultSet rs=ps.executeQuery();
            
            p.setDecription(rs.getString(1));
            p.setIdEquipo(rs.getInt(2));
            p.setIdProblem(rs.getInt(3));
            p.setDate(rs.getDate(4));
            p.setEstudiante_id(rs.getInt(5));
         
            
            
        }catch(SQLException ex) {
            try {
                throw new PersistenceException("An error ocurred while loading an order.",ex);
            } catch (PersistenceException ex1) {
                Logger.getLogger(JDBCDaoStudent.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return p;
    }

    @Override
    public HashSet<Problem> loadSegundo() throws PersistenceException {
    PreparedStatement ps;
        HashSet<Problem> problemas = new HashSet<>();
        try{
            ps=con.prepareStatement("SELECT id, Equipo_id, descripcion, fecha, Estudiante_id\n" +
                                    "FROM Problema\n" +
                                    "ORDER BY fecha ASC;" );
            
            
            
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
            Problem p = new Problem();
            p.setIdProblem(rs.getInt(1));
            p.setIdEquipo(rs.getInt(2));
            p.setDecription(rs.getString(3));
            p.setDate(rs.getDate(4));
            p.setEstudiante_id(rs.getInt(5));
            problemas.add(p);
            }
            
            
        }catch(SQLException ex) {
           
                throw new PersistenceException("Error al cargar los reportes",ex);
            
        }
        return problemas;
    }

    @Override
    public int maximunid() {
        PreparedStatement ps;
        int maxid = 0;
        try {
            ps = con.prepareStatement("SELECT max(id) from Problema");          
            ResultSet rs = ps.executeQuery();
            maxid=rs.getInt(1);     

        } catch (SQLException ex) {
            try {
                throw new PersistenceException("An error ocurred while loading an order.", ex);
            } catch (PersistenceException ex1) {
                Logger.getLogger(JDBCDaoStudent.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return maxid;
    }

  
}
