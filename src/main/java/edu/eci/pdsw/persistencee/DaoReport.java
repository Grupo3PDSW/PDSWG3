/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistencee;

import edu.eci.pdsw.entities.Report;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.management.Query;

/**
 *
 * @author 2091854
 */
public interface DaoReport {
    
     
     public HashSet<Report> load (Date fecha1, Date fecha2) throws PersistenceException;
     
     public HashSet<Report> loadSegundo (Date fecha1, Date fecha2) throws PersistenceException;
    
}
