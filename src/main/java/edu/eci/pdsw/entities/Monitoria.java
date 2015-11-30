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
public class Monitoria {
    public String LenguajeDeProgramacion;
    public String tema;
    public String DarSoporte;
    public int id;
    
    public Monitoria(String lg, String tema,int id){
        LenguajeDeProgramacion=lg;
        this.tema=tema;
        DarSoporte = "Y";
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Monitoria(){
        
    }

    public String getDarSoporte() {
        return DarSoporte;
    }

    public void setDarSoporte(String DarSoporte) {
        this.DarSoporte = DarSoporte;
    }
    
    @Override
    public String toString() {
        return "Monitoria{" + "LenguajeDeProgramacion=" + LenguajeDeProgramacion
                           + ", tema=" + tema+ '}';
    }

    public String getLenguajeDeProgramacion() {
        return LenguajeDeProgramacion;
    }

    public void setLenguajeDeProgramacion(String LenguajeDeProgramacion) {
        this.LenguajeDeProgramacion = LenguajeDeProgramacion;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }


}
