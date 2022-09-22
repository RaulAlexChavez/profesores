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
    
    /**
     * FACADE<br>
     * Instancia de una clase que agrupa los métodos de consulta de Unidades de Aprendizaje.
     */
    public final ConsultaUnidadDeAprendizaje consultaUA = new ConsultaUnidadDeAprendizaje();
    
    /**
     * FACADE<br>
     * Guarda una nueva Unidad de Aprendizaje. No hay validación en caso de que ya exista un objeto con el mismo ID.
     * @param ua El objeto UnidadDeAprendizaje a guardar.
     */
    public void saveUnidadDeAprendizaje(UnidadDeAprendizaje ua){
        DelegateUnidadDeAprendizaje.saveUnidadDeAprendizaje(ua);
    }
    
    /**
     * FACADE<br>
     * Borra una Unidad De Aprendizaje. No hay validación en caso de que no exista lo que se quiere borrar.
     * @param ua El objeto UnidadDeAprendizaje a borrar.
     */
    public void deleteUnidadDeAprendizaje(UnidadDeAprendizaje ua) {
        DelegateUnidadDeAprendizaje.deleteUnidadDeAprendizaje(ua);
    }
    
    /**
     * FACADE<br>
     * Clase que agrupa las operaciones de consulta.
     */
    public class ConsultaUnidadDeAprendizaje {
        /**
         * FACADE<br>
         * Busca una Unidad De Aprendizaje por ID y la retorna. No hay validación en caso de que no se encuentre.
         * @param id EL id de la UA a buscar.
         * @return La UnidadDeAprendizaje con la ID.
         */
        public UnidadDeAprendizaje porID(int id) {
            return DelegateUnidadDeAprendizaje.ConsultaUA.porID(id);
        }
    }
    
}
