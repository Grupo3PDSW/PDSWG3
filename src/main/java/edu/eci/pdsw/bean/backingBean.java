/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.bean;
import edu.eci.pdsw.entities.Bitacora;
import edu.eci.pdsw.entities.Monitoria;
import edu.eci.pdsw.entities.Student;
import edu.eci.pdsw.entities.Task;
import edu.eci.pdsw.entities.Turn;
import edu.eci.pdsw.services.ServiceFacadeException;
import edu.eci.pdsw.services.ServicesFacade;
import java.sql.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
/**
 *
 * @author 2101751
 */
@ManagedBean 
@SessionScoped
public class backingBean {
    
    public String estado;
    public Date fecha;
    public int idMonitor;
    public int idTask;
    public int idMonitoria;
    public String Descrip;
    public int idTurn;
    public Bitacora bitacoraBean;
    
    
    public void registroBitacora() throws ServiceFacadeException{
        Student stu = ServicesFacade.getInstance("applicationconfig.properties").consultarEstudiante(idMonitor);
        ServicesFacade.getInstance("applicationconfig.properties").ActualizarEstadoDeTarea(idTask, estado);
        Task tarea = ServicesFacade.getInstance("applicationconfig.properties").consultarTarea(idTask);
        Monitoria moni = ServicesFacade.getInstance("applicationconfig.properties").consultarMonitoria(idMonitoria);
        Turn turno = ServicesFacade.getInstance("applicationconfig.properties").consultarTurn(idTurn);
        bitacoraBean = new Bitacora(stu, Descrip , tarea, fecha, moni, turno, 0);
        ServicesFacade.getInstance("applicationconfig.properties").registrarBitacora(bitacoraBean);
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdMonitoria() {
        return idMonitoria;
    }

    public void setIdMonitoria(int idMonitoria) {
        this.idMonitoria = idMonitoria;
    }

    public String getDescrip() {
        return Descrip;
    }

    public void setDescrip(String Descrip) {
        this.Descrip = Descrip;
    }

    public int getIdTurn() {
        return idTurn;
    }

    public void setIdTurn(int idTurn) {
        this.idTurn = idTurn;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


    public int getIdMonitor() {
        return idMonitor;
    }

    public void setIdMonitor(int idMonitor) {
        this.idMonitor = idMonitor;
    }

    public int getIdTask() {
        return idTask;
    }

    public void setIdTask(int idTask) {
        this.idTask = idTask;
    }
    
    public Bitacora getBitacoraBean() throws ServiceFacadeException {
        registroBitacora();
        return bitacoraBean;
    }

    public void setBitacoraBean(Bitacora bitacoraBean) throws ServiceFacadeException {
        
        this.bitacoraBean = bitacoraBean;
    }
    
    
    
    
}
