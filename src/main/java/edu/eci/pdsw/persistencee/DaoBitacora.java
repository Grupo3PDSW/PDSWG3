/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistencee;

import edu.eci.pdsw.entities.Bitacora;

/**
 *
 * @author 
 */
public interface DaoBitacora {
    
    
   public void save(Bitacora b) throws PersistenceException;
   
   public Bitacora load(int idBitacora) throws PersistenceException;
   
   
}
