/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistence.jdbcimpl;

import edu.eci.pdsw.persistencee.DaoBitacora;
import edu.eci.pdsw.persistencee.DaoEquipo;
import edu.eci.pdsw.persistencee.DaoFactory;
import edu.eci.pdsw.persistencee.DaoLaboratorio;
import edu.eci.pdsw.persistencee.DaoMonitoria;
import edu.eci.pdsw.persistencee.DaoProblem;
import edu.eci.pdsw.persistencee.DaoStudent;
import edu.eci.pdsw.persistencee.DaoTask;
import edu.eci.pdsw.persistencee.DaoTurn;
import edu.eci.pdsw.persistencee.PersistenceException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author felipe
 */
public class JDBCDaoFactory extends DaoFactory{

     Connection con; 

    private static Connection openConnection() throws PersistenceException {
         String url="jdbc:mysql://desarrollo.is.escuelaing.edu.co:3306/pdswg3";
            String driver="com.mysql.jdbc.Driver";
            String user="pdswg3";
            String pwd="pdswg03";

        try {
            Class.forName(driver);
            Connection _con = DriverManager.getConnection(url, user, pwd);
            _con.setAutoCommit(false);
            return _con;
        } catch (ClassNotFoundException | SQLException ex) {
            throw new PersistenceException("Error on connection opening.", ex);
        }

    }

    @Override
    public void beginSession() throws PersistenceException {
       try {
            if (con==null || con.isClosed()){            
                con=openConnection();
            }
            else{
                throw new PersistenceException("Session was already opened.");
            }
        } catch (SQLException ex) {
            throw new PersistenceException("An error ocurred while opening a JDBC connection.",ex);
        }

    }

    @Override
    public void endSession() throws PersistenceException {
       try {
            if (con==null || con.isClosed()){
                throw new PersistenceException("Conection is null or is already closed.");
            }
            else{
                con.close();
            }            
        } catch (SQLException ex) {
            throw new PersistenceException("Error on connection closing.",ex);
        }
    }

    @Override
    public void commitTransaction() throws PersistenceException {
         try {
            if (con==null || con.isClosed()){
                throw new PersistenceException("Conection is null or is already closed.");
            }
            else{
                con.commit();
            }            
        } catch (SQLException ex) {
            throw new PersistenceException("Error on connection closing.",ex);
        }        
    }

    @Override
    public void rollbackTransaction() throws PersistenceException {
          try {
            if (con==null || con.isClosed()){
                throw new PersistenceException("Conection is null or is already closed.");
            }
            else{
                con.rollback();
            }            
        } catch (SQLException ex) {
            throw new PersistenceException("Error on connection closing.",ex);
        }
    }
    
    @Override
    public DaoBitacora getDaoBitacora() {
        return new JDBCDaoBitacora(con);
    }

    @Override
    public DaoStudent getDaoStudent(){
        return new JDBCDaoStudent(con);
    }
    
    @Override
    public DaoTask getDaoTask(){
        return new JDBCDaoTask(con);
    }


    @Override
    public DaoMonitoria getDaoMonitoria() {
        return new JDBCDaoMonitoria(con);
    }

    @Override
    public DaoProblem getDaoProblem() {
        return new JDBCDaoProblem(con);
    }

    @Override
    public DaoTurn getDaoTurn() {
        return new JDBCDaoTurn(con);
    }

    @Override
    public DaoEquipo getDaoEquipo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DaoLaboratorio getDaoLaboratorio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
