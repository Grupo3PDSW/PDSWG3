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
@ManagedBean (name = "beanMonitores")
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
    public String contraseñaIngresada;
    
    public boolean ingresoCorrecto() throws ServiceFacadeException{
        boolean estado = false;
        if(contraseñaIngresada.equals(ServicesFacade.getInstance("applicationconfig.properties").consultarContraseña(idMonitor))){
            estado = true;
        }
        return estado;
    }

    public String getContraseñaIngresada() {
        return contraseñaIngresada;
    }

    public void setContraseñaIngresada(String contraseñaIngresada) {
        this.contraseñaIngresada = contraseñaIngresada;
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
        return bitacoraBean;
    }

    public void setBitacoraBean(Bitacora bitacoraBean) throws ServiceFacadeException {
        
        this.bitacoraBean = bitacoraBean;
    }
    
    
    
    
}
