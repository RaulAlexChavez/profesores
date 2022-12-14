/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.alesco.helper;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
import mx.alesco.entidad.Profesor;
import mx.alesco.entidad.UnidadDeAprendizaje;
import mx.alesco.integracion.ServiceFacadeLocator;

/**
 *
 * @author Alex
 */
public class ModificacionesProfesorHelper implements Serializable{
    
    public boolean modificarProfe(Profesor profe) {
        return ServiceFacadeLocator.getInstanceFacadeProfesor().actualizarProfesor(profe);
    }
    
    public Profesor profesorPorId(int id) {
        return ServiceFacadeLocator.getInstanceFacadeProfesor().consultaProfesor.porID(id);
    }
    
    public UnidadDeAprendizaje unidadDeAprendizajePorId(int id){
        return ServiceFacadeLocator.getInstanceFacadeUnidadDeAprendizaje().consultaUA.porID(id);
    }
    
    public ArrayList<Integer> uasDeProfeEnID(int idProfe){
        Profesor profe = profesorPorId(idProfe);
        ArrayList<Integer> intList = new ArrayList<>();
        for(UnidadDeAprendizaje ua : profe.getUnidadDeAprendizajeList()) {
            intList.add(ua.getIdunidadDeAprendizaje());
        }
        return intList;
    }
    
    public ArrayList<String> uasDeProfeEnString(int idProfe){
        ArrayList<Integer> ints = uasDeProfeEnID(idProfe);
        ArrayList<String> strings = new ArrayList<>();
        for(Integer i : ints){
            strings.add("" + i);
        }
        return strings;
    }
}