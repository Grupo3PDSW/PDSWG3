/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.services;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import edu.eci.pdsw.entities.Bitacora;
import edu.eci.pdsw.entities.Equipo;
import edu.eci.pdsw.entities.Monitoria;
import edu.eci.pdsw.entities.Problem;
import edu.eci.pdsw.entities.Report;
import edu.eci.pdsw.entities.Student;
import edu.eci.pdsw.entities.Task;
import edu.eci.pdsw.entities.Turn;
import edu.eci.pdsw.persistencee.DaoFactory;
import edu.eci.pdsw.persistencee.PersistenceException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.HashSet;
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
            throw new ServiceFacadeException("error no se registro la tarea",ex);
        }
    }
    
    
    
        /**
     * El metodo registra un problema en la BD
     * @param p     
     * @throws ServiceFacadeException 
     */
    public void registrarProblema(Problem p) throws ServiceFacadeException {
        DaoFactory daof=DaoFactory.getInstance(properties);
        try {
            daof.beginSession();
            daof.getDaoProblem().save(p);
            daof.commitTransaction();
            daof.endSession();
        } catch (PersistenceException ex) {
            throw new ServiceFacadeException("error no se registro el problema ",ex);
        }
    }
    
            /**
     * El metodo registra un equipo en la BD
     * @param e
     * @throws ServiceFacadeException 
     */
    public void registrarEquipo(Equipo e) throws ServiceFacadeException {
        DaoFactory daof=DaoFactory.getInstance(properties);
        try {
            daof.beginSession();
            daof.getDaoEquipo().save(e);
            daof.commitTransaction();
            daof.endSession();
        } catch (PersistenceException ex) {
            throw new ServiceFacadeException("error no se registro el problema ",ex);
        }
    }
    
    
    public void ActualizarEstadoDeTarea(int idTask, String estado) throws ServiceFacadeException{
        DaoFactory daof=DaoFactory.getInstance(properties);
        try {
            daof.beginSession();
            daof.getDaoTask().UpdateEstado(idTask, estado);
            daof.endSession();
            
        } catch (PersistenceException ex) {
            System.out.println(ex.toString());
            throw new ServiceFacadeException("Error al consultar estudiante.",ex);
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
     * El metodo consulta un problem de la base de datos y lo retorna como un objeto
     * @param idPro es el Id del problema  a consultar
     * @return retorla el objeto eproblema con su informacion correspondiente
     * @throws ServiceFacadeException 
     */
    public Problem consultarProblem(int idPro) throws ServiceFacadeException{
        DaoFactory daof=DaoFactory.getInstance(properties);
        try {
            daof.beginSession();
            Problem pro=daof.getDaoProblem().load(idPro);
            daof.endSession();
            return pro;
        } catch (PersistenceException ex) {
            System.out.println(ex.toString());
            throw new ServiceFacadeException("Error al consultar problem.",ex);
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
            throw new ServiceFacadeException("Error al consultar la bitacora .",ex);
        }        
    }
    
    
    /**
     * Consulta un turno en la base de datos
     * @param idTurn contiene el Id de la turno a consultar
     * @return retorna el turno como objeto con toda la informacion necesaria
     * @throws ServiceFacadeException 
     */
    
    public Turn consultarTurn(int idTurn) throws ServiceFacadeException{
        DaoFactory daof=DaoFactory.getInstance(properties);
        try {
            daof.beginSession();
            Turn turn=daof.getDaoTurn().load(idTurn);
            daof.endSession();
            return turn;
        } catch (PersistenceException ex) {
            System.out.println(ex.toString());
            throw new ServiceFacadeException("Error al consultar turno.",ex);
        }        
    }
    
    
     /**
     * Consulta una monitoria en la base de datos
     * @param idMoni contiene el Id de la monitoria a consultar
     * @return retorna la monitoria como objeto con toda la informacion necesaria
     * @throws ServiceFacadeException 
     */
    
    
    
    public Monitoria consultarMonitoria(int idMoni) throws ServiceFacadeException{
        DaoFactory daof=DaoFactory.getInstance(properties);
        try {
            daof.beginSession();
            Monitoria moni=daof.getDaoMonitoria().load(idMoni);
            daof.endSession();
            return moni;
        } catch (PersistenceException ex) {
            System.out.println(ex.toString());
            throw new ServiceFacadeException("Error al consultar estudiante.",ex);
        }        
    }
     /**
     * Consulta una tarea en la base de datos
     * @param idTask contiene el Id de la tarea a consultar
     * @return retorna la tarea como objeto con toda la informacion necesaria
     * @throws ServiceFacadeException 
     */ 
       
    
    
    public Task consultarTarea(int idTask) throws ServiceFacadeException{
        DaoFactory daof=DaoFactory.getInstance(properties);
        try {
            daof.beginSession();
            Task tar=daof.getDaoTask().load(idTask);
            daof.endSession();
            return tar;
        } catch (PersistenceException ex) {
            System.out.println(ex.toString());
            throw new ServiceFacadeException("Error al consultar estudiante.",ex);
        }        
    }
    
    
    
     /**
     * Consulta un equipo en la base de datos
     * @param idEq contiene el Id del Equipo a consultar
     * @return retorna el equipo como objeto con toda la informacion necesaria
     * @throws ServiceFacadeException 
     */
    
        public Equipo consultarEquipo(int idEq) throws ServiceFacadeException{
        DaoFactory daof=DaoFactory.getInstance(properties);
        try {
            daof.beginSession();
            Equipo eq=daof.getDaoEquipo().load(idEq);
            daof.endSession();
            return eq;
        } catch (PersistenceException ex) {
            System.out.println(ex.toString());
            throw new ServiceFacadeException("Error al consultar estudiante.",ex);
        }        
    }

    /**
     * Muestra un reporte apartir de la base de datos entre fechas seleccionadas 
     * @param fecha1 , Fecha de inicio del intervalo
     * @param fecha2 , Fecha de fin del intervalo
     * @return retorna el reporte con la informacion necesaria
     * @throws ServiceFacadeException 
     */
        
       public HashSet<Report> HacerReporte( Date fecha1, Date fecha2) throws ServiceFacadeException{
       
        DaoFactory daof=DaoFactory.getInstance(properties);
        try {
            daof.beginSession();
            HashSet<Report> reportes=daof.getDaoReport().load(fecha1,fecha2);
            daof.endSession();
            return reportes;
        } catch (PersistenceException ex) {
            System.out.println(ex.toString());
            throw new ServiceFacadeException("Error al consultar estudiante.",ex);
        }        
      }
    public Report HacerReporte(java.util.Date date1, java.util.Date date2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       
       
    
    
    
}
