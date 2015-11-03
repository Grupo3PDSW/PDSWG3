/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.entities;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author felipe
 */
public class ReportProblem {
   
    public String decription;
    public int idLab;
    public int idPc;
    public Date date;
    
    public ReportProblem(String description, int idL, int IdP, Date date ){
        
        this.decription=description;
        idLab=idL;
        idPc=IdP;
        this.date=date;
    }
    
    @Override
    public String toString() {
        return "Bitacora{" + "decription=" + decription
                           + ", idLab=" + idLab
                           + ", idPc=" + idPc 
                           + ", date=" + date + '}';
    }
    
    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public int getIdLab() {
        return idLab;
    }

    public void setIdLab(int idLab) {
        this.idLab = idLab;
    }

    public int getIdPc() {
        return idPc;
    }

    public void setIdPc(int idPc) {
        this.idPc = idPc;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
}
