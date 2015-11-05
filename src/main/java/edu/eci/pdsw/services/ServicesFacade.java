/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.services;

import edu.eci.pdsw.entities.Bitacora;
import edu.eci.pdsw.entities.Monitor;
import edu.eci.pdsw.entities.Student;
import edu.eci.pdsw.entities.Task;
import edu.eci.pdsw.entities.Turn;
import edu.eci.pdsw.persistencee.DaoFactory;
import edu.eci.pdsw.persistencee.PersistenceException;
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
    
    
    
    private ServicesFacade(String propFileName) throws IOException{        
	InputStream input = null;
        input = this.getClass().getClassLoader().getResourceAsStream(propFileName);        
        properties.load(input);
        
        DaoFactory.getInstance(properties);
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
    
    /**
     * El metodo regista la bitacora en la BD
     * @param b contiene toda la informacion de la bitacora a registrar.
     * @throws ServiceFacadeException 
     */
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
    
    
    /**
     * El metodo regista a un estudiante en la BD
     * @param stu Contiene toda la informacion del estudiante.
     * @throws ServiceFacadeException 
     */
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
    
    /**
     * El metodo registra una tarea en la BD
     * @param t contiene toda la informacion de la tarea
     * @throws ServiceFacadeException 
     */
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
    
    
    /**
     * El metodo consulta un estudiante de la base de datos y lo retorna como un objeto
     * @param idEstu es el Id de estudiante a consultar
     * @return retorla el objeto estudiante con su informacion correspondiente
     * @throws ServiceFacadeException 
     */
    public Student consultarEstudiante(int idEstu) throws ServiceFacadeException{
        DaoFactory daof=DaoFactory.getInstance(properties);
        try {
            daof.beginSession();
            Student stu=daof.getDaoStudent().load(idEstu);
            daof.endSession();
            return stu;
        } catch (PersistenceException ex) {
            System.out.println(ex.toString());
            throw new ServiceFacadeException("Error al consultar estudiante.",ex);
        }        
    }
    
    
    /**
     * Consulta una bitacora en la base de datos
     * @param idBitacora contiene el Id de la bitacora a consultar
     * @return retorna la bitacora como objeto con toda la informacion necesaria
     * @throws ServiceFacadeException 
     */
    public Bitacora consultarBitacora( int idBitacora) throws ServiceFacadeException{
        DaoFactory daof=DaoFactory.getInstance(properties);
        try {
            daof.beginSession();
            Bitacora bit=daof.getDaoBitacora().load(idBitacora);
            daof.endSession();
            return bit;
        } catch (PersistenceException ex) {
            System.out.println(ex.toString());
            throw new ServiceFacadeException("Error al consultar estudiante.",ex);
        }        
    }
    
    
    /**
     * Consulta un monitor de la base de datos
     * @param idMonitor contiene el id del monitor a consultar
     * @return retorna un monitor con toda la informacion respectiva.
     * @throws ServiceFacadeException 
     */
    public Monitor consultarMonitor(int idMonitor) throws ServiceFacadeException{
        DaoFactory daof=DaoFactory.getInstance(properties);
        try {
            daof.beginSession();
            Monitor monitor=daof.getDaoMonitor().load(idMonitor);
            daof.endSession();
            return monitor;
        } catch (PersistenceException ex) {
            System.out.println(ex.toString());
            throw new ServiceFacadeException("Error al consultar estudiante.",ex);
        }        
    }
    
    public Turn consultarTurn(int idTurn) throws ServiceFacadeException{
        DaoFactory daof=DaoFactory.getInstance(properties);
        try {
            daof.beginSession();
            Turn turn=daof.getDaoTurn().load(idTurn);
            daof.endSession();
            return turn;
        } catch (PersistenceException ex) {
            System.out.println(ex.toString());
            throw new ServiceFacadeException("Error al consultar estudiante.",ex);
        }        
    }
}
