/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.entities;

/**
 *
 * @author 2098167
 */
public class Equipo {
    public int id;
    public int Laboratorio_id;
    public String descripcion;

    public Equipo(int id, int Laboratorio_id, String descripcion) {
        this.id = id;
        this.Laboratorio_id = Laboratorio_id;
        this.descripcion = descripcion;
    }

    public Equipo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Equipo{" + "id=" + id + ", Laboratorio_id=" + Laboratorio_id + ", descripcion=" + descripcion + '}';
    }
    
        

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLaboratorio_id() {
        return Laboratorio_id;
    }

    public void setLaboratorio_id(int Laboratorio_id) {
        this.Laboratorio_id = Laboratorio_id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
