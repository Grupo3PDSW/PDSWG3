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
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

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
            ps = con.prepareStatement("insert into Tarea(id, tipo, estado, comentario) values (?,?,?,?)");
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
    public Task load(String tipo) {
        PreparedStatement ps;
        Task tar = new Task();
        try{
            ps=con.prepareStatement("SELECT * FROM `Tarea` WHERE tipo = ?" );
            ps.setString(1, tipo);
            ps.execute();
            ResultSet rs=ps.executeQuery();
            rs.next();
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

    @Override
    public HashSet<Task> loadSegundo()  throws PersistenceException{
        PreparedStatement ps;
        HashSet<Task> tareas = new HashSet<>();
        try{
            ps=con.prepareStatement("SELECT id, tipo, estado, comentario\n" +
                                    "FROM Tarea\n" +
                                    "WHERE tipo = ('Instalacion de software' OR 'Organizacion' OR 'Arreglos' OR 'Solucion a problemas reportados') AND (estado = 'Avanzado' OR estado = 'pendiente' OR estado = 'avanzado' OR estado = 'Pendiente');" );
            
            
            
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
            Task t = new Task();
            t.setIdTask(rs.getInt(1));
            t.setType(rs.getString(2));
            t.setStatus(rs.getString(3));
            t.setTaskCommnets(rs.getString(4));
            tareas.add(t);
            }
            
            
        }catch(SQLException ex) {
           
                throw new PersistenceException("Error al cargar las tareas",ex);
            
        }
        return tareas;
    }

    @Override
    public int consultarUltimoID() {
        PreparedStatement ps;
        int id = 0 ;
        try{
            ps=con.prepareStatement("SELECT id FROM `Tarea` WHERE id = "
                                             + "(SELECT MAX( id ) FROM `Tarea`)" );
            ps.execute();
            ResultSet rs=ps.executeQuery();
            rs.next();
            id = (rs.getInt("id"));
            
            
        }catch(SQLException ex) {
            
                Logger.getLogger(JDBCDaoStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
          return id;
    }

    @Override
    public void actualizar(String estado, String comentario, int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.        
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("UPDATE `Tarea` SET `estado`= ? , `comentario`= ?"
                    + "WHERE `id` = ?");
            
            ps.setString(1, estado);
            ps.setString(2, comentario);
            ps.setInt(3, id);     
            
            ps.execute();
            System.out.println("Entro a actualizar");
        } catch (SQLException ex) {
            try {
                throw new PersistenceException("Error.",ex);
            } catch (PersistenceException ex1) {
                Logger.getLogger(JDBCDaoBitacora.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    @Override
    public List<SelectItem> loadTodosIdTipo() {
        PreparedStatement ps;
        SelectItemGroup g1;
        List<SelectItem> si = new ArrayList<SelectItem>();
        try{
            ps=con.prepareStatement("SELECT `id`, `tipo` FROM `Tarea` WHERE `Estado` = 'Avanzado' OR `Estado` = 'avanzado' OR `Estado` = 'Pendiente' OR   `Estado` = 'pendiente'  " );
            ps.execute();
            ResultSet rs=ps.executeQuery();
            
            
            g1 = new SelectItemGroup("Listado de tareas");
            
            while(rs.next()){
                SelectItem it = new SelectItem(rs.getInt("id"), rs.getString("tipo"));
                si.add(it);
            }
            
            
        }catch(SQLException ex) {
            try {
                throw new PersistenceException("An error ocurred while loading an order.",ex);
            } catch (PersistenceException ex1) {
                Logger.getLogger(JDBCDaoStudent.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return si;
    }

    
    
    
}
