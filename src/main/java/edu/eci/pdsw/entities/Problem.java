/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.entities;



import java.util.Date;
import java.util.logging.Logger;



/**
 *
 * @author 2098167
 * 
 * Clase Problema crea un problema con sus entidades
 */
public class Problem {
   
    public String decription;
    public int idEquipo;  
    public int idProblem;
    public Date date;
    public int Estudiante_id;

    public Problem(String decription, int idEquipo, int idProblem, Date date, int Estudiante_id) {
        this.decription = decription;
        this.idEquipo = idEquipo;
        this.idProblem = idProblem;
        this.date = date;
        this.Estudiante_id = Estudiante_id;
    }
    private static final Logger LOG = Logger.getLogger(Problem.class.getName());

    public Problem() {
       
    }
    
    

    @Override
    public String toString() {
        return "Problem{" + "decription=" + decription + ", idEquipo=" + idEquipo + ", idProblem=" + idProblem + ", date=" + date + ", Estudiante_id=" + Estudiante_id + '}';
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
    
    
    
}
