/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.bean;


import edu.eci.pdsw.entities.Report;
import edu.eci.pdsw.services.ServiceFacadeException;
import edu.eci.pdsw.services.ServicesFacade;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
 
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
/**
 *
 * @author 2091854
 */
@ManagedBean (name = "beanReport")
@SessionScoped
public class ReporteBean {

    public Date date1; 
    public Date date2; 
    public int  codigoMonitor; 
    public String nombreMonitor; 
    public int tareas; 
    public String tipo; 
    public String lenguajeProgramacion; 
    public String temaMonitoria;
    public String soporte; 
    public int monitorias; 
    Report r;
    
   
    public void registroProblema () throws ServiceFacadeException{               

            Report re=  ServicesFacade.getInstance("applicationconfig.properties").HacerReporte(date1, date2);
            r = new Report(re.getFecha1(),re.getFecha2(),re.getCodigoMonitor(),re.getNombreMonitor(),re.getTareas(),re.getTipo(),re.getLenguajeProgramacion(),re.getTemaMonitoria(),re.getSoporte(),re.getMonitorias());
//        r= new Report(fecha1, fecha2, codigoMonitor, nombreMonitor, tareas, tipo, lenguajeProgramacion, temaMonitoria, soporte, monitorias);
    }

    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }
     
    public void click() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
         
        requestContext.update("form:display");
        requestContext.execute("PF('dlg').show()");
    }
    
    public Date getFecha1() {
        return date1;
    }

    public void setFecha1(Date fecha1) {
        this.date1 = date1;
    }

    public Date getFecha2() {
        return date2;
    }

    public void setFecha2(Date fecha2) {
        this.date2 = date2;
    }

    public int getCodigoMonitor() {
        return codigoMonitor;
    }

    public void setCodigoMonitor(int codigoMonitor) {
        this.codigoMonitor = codigoMonitor;
    }

    public String getNombreMonitor() {
        return nombreMonitor;
    }

    public void setNombreMonitor(String nombreMonitor) {
        this.nombreMonitor = nombreMonitor;
    }

    public int getTareas() {
        return tareas;
    }

    public void setTareas(int tareas) {
        this.tareas = tareas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLenguajeProgramacion() {
        return lenguajeProgramacion;
    }

    public void setLenguajeProgramacion(String lenguajeProgramacion) {
        this.lenguajeProgramacion = lenguajeProgramacion;
    }

    public String getTemaMonitoria() {
        return temaMonitoria;
    }

    public void setTemaMonitoria(String temaMonitoria) {
        this.temaMonitoria = temaMonitoria;
    }

    public String getSoporte() {
        return soporte;
    }

    public void setSoporte(String soporte) {
        this.soporte = soporte;
    }

    public int getMonitorias() {
        return monitorias;
    }

    public void setMonitorias(int monitorias) {
        this.monitorias = monitorias;
    }

    public Report getR() {
        return r;
    }

    public void setR(Report r) {
        this.r = r;
    }
}
        
