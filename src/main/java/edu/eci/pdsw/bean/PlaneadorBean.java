/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.bean;

import edu.eci.pdsw.entities.Problem;
import edu.eci.pdsw.entities.Task;
import edu.eci.pdsw.services.ServiceFacadeException;
import edu.eci.pdsw.services.ServicesFacade;
import java.util.Date;
import java.util.HashSet;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author 2123095
 */

@ManagedBean (name = "PlaneadorBean")
@SessionScoped
public class PlaneadorBean {
    
    public String type;
    public String status;
    public int IdTask;
    public String taskCommnets;
    public String decription;
    public int idEquipo;  
    public int idProblem;
    public Date date;
    public int Estudiante_id;
    public HashSet<Task> tareas;
    public HashSet<Problem> problemas;
    
     public void registroProblema () throws ServiceFacadeException{      
        tareas=  ServicesFacade.getInstance("applicationconfig.properties").consultarTarea();
        problemas=  ServicesFacade.getInstance("applicationconfig.properties").consultarProblem();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdTask() {
        return IdTask;
    }

    public void setIdTask(int IdTask) {
        this.IdTask = IdTask;
    }

    public String getTaskCommnets() {
        return taskCommnets;
    }

    public void setTaskCommnets(String taskCommnets) {
        this.taskCommnets = taskCommnets;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public int getIdProblem() {
        return idProblem;
    }

    public void setIdProblem(int idProblem) {
        this.idProblem = idProblem;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getEstudiante_id() {
        return Estudiante_id;
    }

    public void setEstudiante_id(int Estudiante_id) {
        this.Estudiante_id = Estudiante_id;
    }

    public HashSet<Task> getTareas() {
        return tareas;
    }

    public void setTareas(HashSet<Task> tareas) {
        this.tareas = tareas;
    }

    public HashSet<Problem> getProblemas() {
        return problemas;
    }

    public void setProblemas(HashSet<Problem> problemas) {
        this.problemas = problemas;
    }
    
    
     
     
}
