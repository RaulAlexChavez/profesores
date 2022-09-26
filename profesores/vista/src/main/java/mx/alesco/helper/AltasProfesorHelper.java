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
import mx.alesco.entidad.UnidadDeAprendizaje;
import mx.alesco.integracion.ServiceFacadeLocator;

/**
 *
 * @author Alex
 */
public class AltasProfesorHelper implements Serializable{
    
    public boolean altaProfe(Profesor profe) {
        return ServiceFacadeLocator.getInstanceFacadeProfesor().altaProfesor(profe);
    }
    
    public UnidadDeAprendizaje unidadDeAprendizajePorId(int id){
        return ServiceFacadeLocator.getInstanceFacadeUnidadDeAprendizaje().consultaUA.porID(id);
    }
}