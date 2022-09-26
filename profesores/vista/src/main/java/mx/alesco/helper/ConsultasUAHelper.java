/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.alesco.helper;

import java.io.IOException;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import javax.faces.context.FacesContext;
import mx.alesco.entidad.Profesor;
import mx.alesco.entidad.UnidadDeAprendizaje;
import mx.alesco.integracion.ServiceFacadeLocator;

/**
 *
 * @author Alex
 */
public class ConsultasUAHelper implements Serializable{
    
    public List<UnidadDeAprendizaje> consultaUATodos() {
        Comparator c = new Comparator<UnidadDeAprendizaje>() {
            @Override
            public int compare(UnidadDeAprendizaje o1, UnidadDeAprendizaje o2) {
                return o1.getNombreUA().compareTo(o2.getNombreUA());
            }
        };
        List<UnidadDeAprendizaje> uas = ServiceFacadeLocator.getInstanceFacadeUnidadDeAprendizaje().consultaUA.todos();
        uas.sort(c);
        return uas;
    }
    
    public UnidadDeAprendizaje uaPorId(int id){
        return ServiceFacadeLocator.getInstanceFacadeUnidadDeAprendizaje().consultaUA.porID(id);
    }
    
}