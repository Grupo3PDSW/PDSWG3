/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.entities;

/**
 *
 * @author felipe
 */
public class Monitor extends Student {
    
    public int IdTurn;

    public Monitor(int id, String n, String e, int idTurn) {
        
        super(id, n, e);
        this.IdTurn=idTurn;
        
    }
    
    public Monitor(){
    
    }

    public int getIdTurn() {
        return IdTurn;
    }

    public void setIdTurn(int IdTurn) {
        this.IdTurn = IdTurn;
    }
    
    @Override
    public String toString() {
        return "Student{" + "IDStudent=" + idStudent
                           + ", name=" + name 
                           + ", email=" + email
                           + "IdTurn="+ IdTurn +'}';
    }
}
