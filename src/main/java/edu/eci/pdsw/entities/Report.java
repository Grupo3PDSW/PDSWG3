/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.entities;

import java.sql.Date;

/**
 *
 * @author 2091854
 */
public class Report {
    
    public Date fecha1; 
    public Date fecha2; 
    public int  codigoMonitor; 
    public String nombreMonitor; 
    public int tareas; 
    public String tipo; 
    public String lenguajeProgramacion; 
    public String temaMonitoria;
    public String soporte; 
    public int monitorias; 

    public Report(Date fecha1, Date fecha2, int codigoMonitor, String nombreMonitor, int tareas, String tipo, String lenguajeProgramacion, String temaMonitoria, String soporte, int monitorias) {
        this.fecha1 = fecha1;
        this.fecha2 = fecha2;
        this.codigoMonitor = codigoMonitor;
        this.nombreMonitor = nombreMonitor;
        this.tareas = tareas;
        this.tipo = tipo;
        this.lenguajeProgramacion = lenguajeProgramacion;
        this.temaMonitoria = temaMonitoria;
        this.soporte = soporte;
        this.monitorias = monitorias;
    }

    public Report() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Date getFecha1() {
        return fecha1;
    }

    public void setFecha1(Date fecha1) {
        this.fecha1 = fecha1;
    }

    public Date getFecha2() {
        return fecha2;
    }

    public void setFecha2(Date fecha2) {
        this.fecha2 = fecha2;
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
