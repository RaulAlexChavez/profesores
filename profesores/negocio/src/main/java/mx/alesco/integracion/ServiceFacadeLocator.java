/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.alesco.integracion;

import mx.alesco.facade.FacadeProfesor;
import mx.alesco.facade.FacadeUnidadDeAprendizaje;

/**
 *
 * @author EduardoCardona <>
 */
public class ServiceFacadeLocator {
    
    private static FacadeProfesor facadeProfesor;
    private static FacadeUnidadDeAprendizaje facadeUnidadDeAprendizaje;
    
    public static FacadeProfesor getInstanceFacadeProfesor() {
        if (facadeProfesor == null) {
            facadeProfesor = new FacadeProfesor();
            return facadeProfesor;
        } else {
            return facadeProfesor;
        }
    }
    
    public static FacadeUnidadDeAprendizaje getInstanceFacadeUnidadDeAprendizaje() {
        if (facadeUnidadDeAprendizaje == null) {
            facadeUnidadDeAprendizaje = new FacadeUnidadDeAprendizaje();
            return facadeUnidadDeAprendizaje;
        } else {
            return facadeUnidadDeAprendizaje;
        }
    }
}
