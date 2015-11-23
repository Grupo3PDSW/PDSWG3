/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template tin the editor.
 */
package edu.eci.pdsw.entities;

import java.util.Date;
import java.sql.Timestamp;

/**
 *
 * @author felipe
 */
public class Bitacora {
    
    
    public String description;
    public Date fecha;
    public int IdBit=0;
    public int taskid;
    public int monitoria_id;
    public int monitor_id;
    public int turno_id;


    public Bitacora(String description, int taskid,int monitoria_id, int monitor_id, int turno_id) {
        this.description = description;
        this.fecha = new Date();
        this.IdBit = 0;
        this.taskid = taskid;
        this.monitoria_id = monitoria_id;
        this.monitor_id = monitor_id;
        this.turno_id = turno_id;
    }

    public int getIdBit() {
        return IdBit;
    }

    public void setIdBit(int IdBit) {
        this.IdBit = IdBit;
    }
    
    /**
     * 
     */
    public Bitacora(){
    
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        return "Bitacora{" + "Monitor_Estudiantes_id=" + monitor_id
                           + ", Monitor_Turnos_id=" + turno_id
                           + ", descripcion=" + description 
                           + ", tarea_id=" + taskid
                           + ", fecha=" + this.fecha
                           + ", Monitoria_id=" +monitoria_id+ '}';
    }

    public int getTaskid() {
        return taskid;
    }

    public void setTaskid(int taskid) {
        this.taskid = taskid;
    }

    public int getMonitoria_id() {
        return monitoria_id;
    }

    public void setMonitoria_id(int monitoria_id) {
        this.monitoria_id = monitoria_id;
    }

    public int getMonitor_id() {
        return monitor_id;
    }

    public void setMonitor_id(int monitor_id) {
        this.monitor_id = monitor_id;
    }

    public int getTurno_id() {
        return turno_id;
    }

    public void setTurno_id(int turno_id) {
        this.turno_id = turno_id;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

  
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

   
    
}
