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
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
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
    
    

    public List<SelectItem> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<SelectItem> taskList) {
        this.taskList = taskList;
    }

    public SelectItemGroup getG1() {
        return g1;
    }

    public void setG1(SelectItemGroup g1) {
        this.g1 = g1;
    }
    public List<SelectItem> taskList;
    
    SelectItemGroup g1;

    public backingBean() {
        this.g1 = new SelectItemGroup("Listado de tareas");    
        g1.setSelectItems(new SelectItem[] {new SelectItem("t1", "t1"), new SelectItem("t2", "t2"), new SelectItem("t3", "t3")});
        
        taskList = new ArrayList<SelectItem>();
        taskList.add(g1);

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
    
    public List<String> completeArea(String query) {
        List<String> results = new ArrayList<String>();
         
        if(query.equals("PrimeFaces")) {
            results.add("PrimeFaces Rocks!!!");
            results.add("PrimeFaces has 100+ components.");
            results.add("PrimeFaces is lightweight.");
            results.add("PrimeFaces is easy to use.");
            results.add("PrimeFaces is developed with passion!");
        }
        else {
            for(int i = 0; i < 10; i++) {
                results.add(query + i);
            }
        }
         
        return results;
    }
    
    
    
    
}
