/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.entities;

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
    
    public Student(int id, String n, String e, boolean is){
        
        idStudent=id;
        name=n;
        email=e;
        isMonitor=is;
    }

    public Student() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean isIsMonitor() {
        return isMonitor;
    }

    public void setIsMonitor(boolean isMonitor) {
        this.isMonitor = isMonitor;
    }
    
 
    
    @Override
    public String toString() {
        return "Student{" + "IDStudent=" + idStudent
                           + ", name=" + name 
                           + ", email=" + email+'}';
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
