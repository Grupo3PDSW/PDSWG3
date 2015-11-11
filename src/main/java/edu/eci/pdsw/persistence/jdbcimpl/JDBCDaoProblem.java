/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistence.jdbcimpl;


import edu.eci.pdsw.entities.Equipo;
import edu.eci.pdsw.entities.Problem;
import edu.eci.pdsw.persistencee.DaoProblem;
import java.sql.Connection;

/**
 *
 * @author 2101751
 */
public class JDBCDaoProblem implements DaoProblem{
    
      Connection con;

    public JDBCDaoProblem(Connection con) {
        this.con = con;
    }

    @Override
    public void save(Problem p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
}
