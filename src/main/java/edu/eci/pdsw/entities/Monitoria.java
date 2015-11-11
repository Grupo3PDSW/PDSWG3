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
    public int IdMonitoria;
    public String DarSoporte;
    
    public Monitoria(String lg, String tema, int IdM, String DarSo){
        LenguajeDeProgramacion=lg;
        this.tema=tema;
        IdMonitoria=IdM;
        DarSoporte = DarSo;
        
        
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
                           + ", tema=" + tema
                           + ", IdMonitoria=" + IdMonitoria + '}';
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

    public int getIdMonitoria() {
        return IdMonitoria;
    }

    public void setIdMonitoria(int IdMonitoria) {
        this.IdMonitoria = IdMonitoria;
    }
}
