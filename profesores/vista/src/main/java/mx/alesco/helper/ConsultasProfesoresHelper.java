/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.alesco.helper;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.faces.context.FacesContext;
import mx.alesco.entidad.Profesor;
import mx.alesco.integracion.ServiceFacadeLocator;

/**
 *
 * @author Alex
 */
public class ConsultasProfesoresHelper implements Serializable{
    
    public List<Profesor> consultaProfesorTodos() {
        return ServiceFacadeLocator.getInstanceFacadeProfesor().consultaProfesor.todos();
    }
    
}