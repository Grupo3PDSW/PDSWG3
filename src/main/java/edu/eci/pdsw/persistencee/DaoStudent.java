/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistencee;

import edu.eci.pdsw.entities.Student;

/**
 *
 * @author 2101751
 */
public interface DaoStudent {
    
    public void save(Student stu);
    
    public Student load(int id);
    
    public String loadContraseña(int id);
}
