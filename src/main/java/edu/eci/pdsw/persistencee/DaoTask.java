/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistencee;

import edu.eci.pdsw.entities.Task;
import java.util.HashSet;
import java.util.List;
import javax.faces.model.SelectItem;

/**
 *
 * @author 2101751
 */
public interface DaoTask {
    
    public void save(Task t);
    
    public void UpdateEstado(int id, String estado);
    
    public Task load(String tipo);

    public HashSet<Task> loadSegundo()throws PersistenceException;
    
    public int consultarUltimoID();
    
    public void actualizar(String estado, String comentario, int id);
    
    public List<SelectItem> loadTodosIdTipo();
}
