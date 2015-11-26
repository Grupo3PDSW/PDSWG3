/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.bean;


import edu.eci.pdsw.entities.Report;
import edu.eci.pdsw.persistence.jdbcimpl.JDBCDaoReport;
import edu.eci.pdsw.persistencee.PersistenceException;
import edu.eci.pdsw.services.ServiceFacadeException;
import edu.eci.pdsw.services.ServicesFacade;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.logging.Logger;
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

    public Date date1=new Date(System.currentTimeMillis()); 
    public Date date2=new Date(System.currentTimeMillis()); 
    public int  codigoMonitor; 
    public String nombreMonitor; 
    public int tareas; 
    public String tipo; 
    public String lenguajeProgramacion; 
    public String temaMonitoria;
    public String soporte; 
    public int monitorias; 
    public HashSet<Report> reporte1;
    public HashSet<Report> reporte2;
    public JDBCDaoReport jdbcReporte;

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        LOG.info("Recibida fecha "+date2);
        this.date2 = date2;
    }
    private static final Logger LOG = Logger.getLogger(ReporteBean.class.getName());
    
   
    public void registroProblema () throws ServiceFacadeException{               
        System.out.println("hola");
            reporte1=  ServicesFacade.getInstance("applicationconfig.properties").HacerReporte(date1, date2);
            reporte2=  ServicesFacade.getInstance("applicationconfig.properties").HacerReporteSegundo(date1, date2);
            System.out.println(reporte1.iterator().next().getNombreMonitor());
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
    
//    public void reporte1(Date fecha1, Date fecha2) throws PersistenceException
//    {
//        jdbcReporte.load(fecha1, fecha2);
//    }
//    
//    public void reporte2(Date fecha1, Date fecha2) throws PersistenceException
//    {
//        jdbcReporte.loadSegundo(fecha1, fecha2);
//    }
    
    
    
    public Date getFecha1() {
        return date1;
    }

    public void setFecha1(Date fecha1) {
        this.date1 = date1;
    }

    public HashSet<Report> getReporte1() {
        return reporte1;
    }

    public void setReporte1(HashSet<Report> reporte1) {
        this.reporte1 = reporte1;
    }

    public HashSet<Report> getReporte2() {
        return reporte2;
    }

    public void setReporte2(HashSet<Report> reporte2) {
        this.reporte2 = reporte2;
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

}
