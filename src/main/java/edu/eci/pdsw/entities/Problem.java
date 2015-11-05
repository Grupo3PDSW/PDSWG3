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
public class Problem {
   
    public String decription;
    public int idEquipo;
    public int idPc;
    public int idProblem;
    public Date date;
    
    public Problem(String description, int idL, int IdP, Date date ){
        
        this.decription=description;
        idEquipo=idL;
        idPc=IdP;
        this.date=date;
    }
    
    @Override
    public String toString() {
        return "Problem{" + "decription=" + decription
                           + ", idEquipo=" + idEquipo
                           + ", idPc=" + idPc
                           + ", idProblem=" + idProblem
                           + ", date=" + date + '}';
    }
    
    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
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
    
    
    
}
