/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.alesco.facade;

import mx.alesco.delegate.DelegateUnidadDeAprendizaje;
import mx.alesco.entidad.UnidadDeAprendizaje;

/**
 *
 * @author EduardoCardona <>
 */
public class FacadeUnidadDeAprendizaje {
    
    public final ConsultaUnidadDeAprendizaje consultaUA = new ConsultaUnidadDeAprendizaje();
    
    /**
     * Metodo de ejemplo para guardar Usuario
     * @param ua de tipo usuario con id 0 para poder que se cree un id nuevo
     */
    public void saveUnidadDeAprendizaje(UnidadDeAprendizaje ua){
        DelegateUnidadDeAprendizaje.saveUnidadDeAprendizaje(ua);
    }
    
    public class ConsultaUnidadDeAprendizaje {
        public UnidadDeAprendizaje porID(int id) {
            return DelegateUnidadDeAprendizaje.ConsultaUA.porID(id);
        }
    }
    
}
