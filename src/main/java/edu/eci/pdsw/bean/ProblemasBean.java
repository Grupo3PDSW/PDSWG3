/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.bean;
import edu.eci.pdsw.entities.Bitacora;
import edu.eci.pdsw.entities.Equipo;
import edu.eci.pdsw.entities.Monitoria;
import edu.eci.pdsw.entities.Problem;
import edu.eci.pdsw.entities.Student;
import edu.eci.pdsw.entities.Task;
import edu.eci.pdsw.entities.Turn;
import edu.eci.pdsw.services.ServiceFacadeException;
import edu.eci.pdsw.services.ServicesFacade;
import java.io.IOException;
import java.sql.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author 2098167
 */

@ManagedBean (name = "beanProblemas")
@SessionScoped
public class ProblemasBean {
    public String desc;
    public int idEquipo;  
    public int idProblem;
    public java.sql.Date date;
    public java.util.Date fecha;
    public int Estudiante_id;       
    Problem problemaBean;
    public String laboratorio;
    
    public void registroProblema () throws ServiceFacadeException, IOException{     
        
        java.util.Date fecha = new java.util.Date();
        java.sql.Date date = new java.sql.Date(fecha.getTime());
        idProblem= ServicesFacade.getInstance("applicationconfig.properties").consultarMaxId();
        Student stu = ServicesFacade.getInstance("applicationconfig.properties").consultarEstudiante(Estudiante_id);
        Equipo eq = ServicesFacade.getInstance("applicationconfig.properties").consultarEquipo(idEquipo);        
        problemaBean = new Problem(desc,eq.getId(),idProblem+1,date,stu.getIdStudent());
        
        ServicesFacade.getInstance("applicationconfig.properties").registrarProblema(problemaBean);
        FacesContext.getCurrentInstance().getExternalContext().redirect("inicioUsuario.xhtml");
    }
        
        
    public String getDecription() {
        return desc;
    }

    public void setDecription(String decription) {
        this.desc = decription;
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

    public java.sql.Date getDate() {
        return date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    public int getEstudiante_id() {
        return Estudiante_id;
    }

    public void setEstudiante_id(int Estudiante_id) {
        this.Estudiante_id = Estudiante_id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public java.util.Date getFecha() {
        return fecha;
    }

    public void setFecha(java.util.Date fecha) {
        this.fecha = fecha;
    }

    public Problem getProblemaBean() {
        return problemaBean;
    }

    public void setProblemaBean(Problem problemaBean) {
        this.problemaBean = problemaBean;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }
    
    
    
    
}
