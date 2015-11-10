/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.bean;
import edu.eci.pdsw.entities.Bitacora;
import edu.eci.pdsw.services.ServiceFacadeException;
import edu.eci.pdsw.services.ServicesFacade;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
/**
 *
 * @author 2101751
 */
@ManagedBean (name = "beanMonitores")
@SessionScoped
public class backingBean {
    
    
    
    Bitacora bitacoraBean;

    
    
    
    public Bitacora getBitacoraBean() {
        return bitacoraBean;
    }

    public void setBitacoraBean(Bitacora bitacoraBean) {
        this.bitacoraBean = bitacoraBean;
    }
    
    public void registroBitacora() throws ServiceFacadeException{
        ServicesFacade.getInstance("applicationconfig.properties").registrarBitacora(bitacoraBean);
    }
}
