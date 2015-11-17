/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistence.jdbcimpl;

import edu.eci.pdsw.entities.Student;
import edu.eci.pdsw.persistencee.DaoStudent;
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
public class JDBCDaoStudent implements DaoStudent{

    Connection con;

    public JDBCDaoStudent(Connection con) {
        this.con = con;
    }            
    
    @Override
    public void save(Student stu) {
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("insert into Estudiante(id, Nombre, email) values (?,?,?)");
            ps.setInt(1, stu.getIdStudent() );
            ps.setString(2,stu.getName());
            ps.setString(3, stu.getEmail());   
            ps.execute();
            
        } catch (SQLException ex) {
            try {
                throw new PersistenceException("Error.",ex);
            } catch (PersistenceException ex1) {
                Logger.getLogger(JDBCDaoStudent.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    
    @Override
    public Student load(int id)  {
        PreparedStatement ps;
        Student stu = new Student();
        try{
            ps=con.prepareStatement("SELECT * from Estudiante WHERE id = ?" );
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            
            stu.setIdStudent(rs.getInt("id"));
            stu.setEmail(rs.getString("email"));
            stu.setName(rs.getString("Nombre"));
            
            
        }catch(SQLException ex) {
            try {
                throw new PersistenceException("An error ocurred while loading an order.",ex);
            } catch (PersistenceException ex1) {
                Logger.getLogger(JDBCDaoStudent.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return stu;
    }

    @Override
    public String loadContraseña(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
