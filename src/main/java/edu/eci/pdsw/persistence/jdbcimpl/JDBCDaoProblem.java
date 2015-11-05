/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistence.jdbcimpl;

import edu.eci.pdsw.persistencee.DaoReportProblem;
import java.sql.Connection;

/**
 *
 * @author 2101751
 */
public class JDBCDaoProblem implements DaoReportProblem{
    
      Connection con;

    public JDBCDaoProblem(Connection con) {
        this.con = con;
    }
}
