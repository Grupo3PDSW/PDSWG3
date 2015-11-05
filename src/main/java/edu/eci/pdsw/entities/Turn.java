/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.entities;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author felipe
 */
public class Turn {
    public Date horaInicio;
    public Date horaFinal;
    public int IdTurn;
    public String dia;
    
    public Turn(Date hi, Date hf, int idT, String dia){
        
        horaInicio=hi;
        horaFinal=hf;
        IdTurn=idT;
        this.dia=dia;
    }

    public Turn() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString() {
        return "Bitacora{" + "horaInicio=" + horaInicio
                           + ", horaFinal=" + horaFinal
                           + ", IdTurn=" + IdTurn 
                           + ", dia=" +  dia+ '}';
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Date horaFinal) {
        this.horaFinal = horaFinal;
    }

    public int getIdTurn() {
        return IdTurn;
    }

    public void setIdTurn(int IdTurn) {
        this.IdTurn = IdTurn;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }
    
}
