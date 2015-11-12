/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistencee;

import edu.eci.pdsw.entities.Report;
import java.sql.Date;

/**
 *
 * @author 2091854
 */
public interface DaoReport {
    
    public void save(Report r);
     
     public Report load (Date fecha1, Date fecha2);
    
}
