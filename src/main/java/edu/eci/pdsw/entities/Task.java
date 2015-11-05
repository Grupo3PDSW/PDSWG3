/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.entities;

import java.util.Set;

/**
 *
 * @author felipe
 */
public class Task{
    
    public String TaskDescription;
    public String type;
    public String status;
    public int IdTask;
    public String taskCommnets;
    
    public Task(String td, String type, String sta, int idT, String tc){
        TaskDescription=td;
        this.type=type;
        status=sta;
        IdTask=idT;
        taskCommnets=tc;
        
    }
    
    @Override
    public String toString() {
        return "Task{" + "TaskDescription=" + TaskDescription
                           + ", type=" + type
                           + ", status=" + status 
                           + ", IdTask=" + IdTask 
                           + ", taskCommnets="+ taskCommnets+ '}';
    }
     
    public String getTaskCommnets() {
        return taskCommnets;
    }

    public void setTaskCommnets(String taskCommnets) {
        this.taskCommnets = taskCommnets;
    }
   

    public String getTaskDescription() {
        return TaskDescription;
    }

    public void setTaskDescription(String TaskDescription) {
        this.TaskDescription = TaskDescription;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdTask() {
        return IdTask;
    }

    public void setIdTask(int IdTask) {
        this.IdTask = IdTask;
    }
    
}
