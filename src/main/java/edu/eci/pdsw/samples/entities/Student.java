/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.entities;

/**
 *
 * @author felipe
 * 
 * Esta clase la vamos a tomar como monitor y estudiante
 */
public class Student {
    
    public int idStudent;
    public String name;
    public String email;
    public boolean isMonitor;
    public int turn;

    public boolean isIsMonitor() {
        return isMonitor;
    }

    public void setIsMonitor(boolean isMonitor) {
        this.isMonitor = isMonitor;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }


    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
