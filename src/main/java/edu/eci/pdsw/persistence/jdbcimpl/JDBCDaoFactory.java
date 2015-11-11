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

     private static final ThreadLocal<Connection> connectionInstance = new ThreadLocal<Connection>() {
    };

    private static Properties appProperties = null;

    public JDBCDaoFactory(Properties appProperties) {
        this.appProperties = appProperties;
    }

    private static Connection openConnection() throws PersistenceException {
        String url = appProperties.getProperty("url");
        String driver = appProperties.getProperty("driver");
        String user = appProperties.getProperty("user");
        String pwd = appProperties.getProperty("pwd");

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
        connectionInstance.set(openConnection());

    }

    @Override
    public void endSession() throws PersistenceException {
        try {
            if (connectionInstance.get() == null || connectionInstance.get().isClosed()) {
                throw new PersistenceException("Conection is null or is already closed.");
            } else {
                connectionInstance.get().close();
            }
        } catch (SQLException ex) {
            throw new PersistenceException("Error on connection closing.", ex);
        }
    }

    @Override
    public void commitTransaction() throws PersistenceException {
        try {
            if (connectionInstance.get() == null || connectionInstance.get().isClosed()) {
                throw new PersistenceException("Conection is null or is already closed.");
            } else {
                connectionInstance.get().commit();
            }
        } catch (SQLException ex) {
            throw new PersistenceException("Error on connection closing.", ex);
        }
    }

    @Override
    public void rollbackTransaction() throws PersistenceException {
        try {
            if (connectionInstance.get() == null || connectionInstance.get().isClosed()) {
                throw new PersistenceException("Conection is null or is already closed.");
            } else {
                connectionInstance.get().rollback();
            }
        } catch (SQLException ex) {
            throw new PersistenceException("Error on connection closing.", ex);
        }
    }
    
    @Override
    public DaoBitacora getDaoBitacora() {
        return new JDBCDaoBitacora(connectionInstance.get());
    }

    @Override
    public DaoStudent getDaoStudent(){
        return new JDBCDaoStudent(connectionInstance.get());
    }
    
    @Override
    public DaoTask getDaoTask(){
        return new JDBCDaoTask(connectionInstance.get());
    }


    @Override
    public DaoMonitoria getDaoMonitoria() {
        return new JDBCDaoMonitoria(connectionInstance.get());
    }

    @Override
    public DaoProblem getDaoProblem() {
        return new JDBCDaoProblem(connectionInstance.get());
    }

    @Override
    public DaoTurn getDaoTurn() {
        return new JDBCDaoTurn(connectionInstance.get());
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
