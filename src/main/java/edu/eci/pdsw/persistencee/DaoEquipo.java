/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistencee;

import edu.eci.pdsw.entities.Equipo;

/**
 *
 * @author 2098167
 */
public interface DaoEquipo {
    
    public void save(Equipo e);
    
    public Equipo load(int id);
}
