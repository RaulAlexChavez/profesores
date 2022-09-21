/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.alesco.delegate;

import java.util.List;
import mx.alesco.entidad.UnidadDeAprendizaje;
import mx.alesco.integracion.ServiceLocator;

/**
 *
 * @author EduardoCardona <>
 */
public class DelegateUnidadDeAprendizaje {
    
    /**
     * Metodo de ejemplo para guardar UnidadDeAprendizaje
     * @param ua de tipo UnidadDeAprendizaje con id 0 para poder que se cree un id nuevo
     */
    public void saveUnidadDeAprendizaje(UnidadDeAprendizaje ua){
        ServiceLocator.getInstanceUnidadDeAprendizaje().save(ua);
    }
    
}
