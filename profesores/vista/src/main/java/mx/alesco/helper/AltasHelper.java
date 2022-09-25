/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.alesco.helper;

import java.io.IOException;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import mx.alesco.entidad.Profesor_;
import mx.alesco.entidad.UnidadDeAprendizaje;
import mx.alesco.integracion.ServiceFacadeLocator;

/**
 *
 * @author Kevin
 */
public class AltasHelper implements Serializable{
    

    /**
     * Metodo para hacer login llamara a la instancia de usuarioFacade
     * @param correo
     * @param password
     * @return 
     */
    public Usuario Login(String correo, String password){
        return ServiceFacadeLocator.getInstanceFacadeUsuario().login(password, correo);
    }
    
    
    
}