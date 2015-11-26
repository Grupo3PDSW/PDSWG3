/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistencee;

import edu.eci.pdsw.entities.Equipo;
import edu.eci.pdsw.entities.Problem;
import java.util.HashSet;


/**
 *
 * @author 2098167
 */
public interface DaoProblem {
     public void save(Problem p);
     
     public Problem load (int idProblem);

    public HashSet<Problem> loadSegundo()throws PersistenceException;
  
}
