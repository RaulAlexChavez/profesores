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
import mx.alesco.integracion.ServiceFacadeLocator;

/**
 *
 * @author Alex
 */
public class ConsultasProfesoresHelper implements Serializable{
    
    public List<Profesor> consultaProfesorTodos() {
        Comparator c = new Comparator<Profesor>() {
            @Override
            public int compare(Profesor o1, Profesor o2) {
                return o1.getNombre().compareTo(o2.getNombre());
            }
        };
        List<Profesor> profes = ServiceFacadeLocator.getInstanceFacadeProfesor().consultaProfesor.todos();
        profes.sort(c);
        return profes;
    }
    
}