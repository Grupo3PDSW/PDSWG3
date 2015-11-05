/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.services;

import edu.eci.pdsw.samples.entities.Bitacora;
import edu.eci.pdsw.samples.entities.Student;
import edu.eci.pdsw.samples.entities.Task;
import edu.eci.pdsw.samples.persistencee.DaoFactory;
import edu.eci.pdsw.samples.persistencee.PersistenceException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author felipe
 */
public class ServicesFacade {
    
    private static ServicesFacade instance=null;
    
    private final Properties properties=new Properties();
    
    DaoFactory dao=DaoFactory.getInstance(properties);
    
    private ServicesFacade(String propFileName) throws IOException{        
	InputStream input = null;
        input = this.getClass().getClassLoader().getResourceAsStream(propFileName);        
        properties.load(input);
    }
    
    public static ServicesFacade getInstance(String propertiesFileName) throws RuntimeException{
        if (instance==null){
            try {
                instance=new ServicesFacade(propertiesFileName);
            } catch (IOException ex) {
                throw new RuntimeException("Error on application configuration:",ex);
            }
        }        
        return instance;
    }
    
    
    public void registrarBitacora(Bitacora b) throws ServiceFacadeException {
        DaoFactory daof=DaoFactory.getInstance(properties);
        try {
            daof.beginSession();
            daof.getDaoBitacora().save(b);
            daof.commitTransaction();
            daof.endSession();
        } catch (PersistenceException ex) {
            throw new ServiceFacadeException("error no se registro bitacora",ex);
        }
    }
    
    public void registrarEstudiante(Student stu) throws ServiceFacadeException {
        DaoFactory daof=DaoFactory.getInstance(properties);
        try {
            daof.beginSession();
            daof.getDaoStudent().save(stu);
            daof.commitTransaction();
            daof.endSession();
        } catch (PersistenceException ex) {
            throw new ServiceFacadeException("error no se registro estudiante",ex);
        }
    }
    
    public void registrarTarea(Task t) throws ServiceFacadeException {
        DaoFactory daof=DaoFactory.getInstance(properties);
        try {
            daof.beginSession();
            daof.getDaoTask().save(t);
            daof.commitTransaction();
            daof.endSession();
        } catch (PersistenceException ex) {
            throw new ServiceFacadeException("error no se registro estudiante",ex);
        }
    }
    
    public Student consultarEstudiante(int idEstu) throws ServiceFacadeException{
        try {
            dao.beginSession();
            Student stu=dao.getDaoStudent().load(idEstu);
            dao.endSession();
            return stu;
        } catch (PersistenceException ex) {
            System.out.println(ex.toString());
            throw new ServiceFacadeException("Error al consultar estudiante.",ex);
        }        
    }
}
