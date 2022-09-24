/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.alesco.facade;

import java.util.List;
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
    public boolean altaUnidadDeAprendizaje(UnidadDeAprendizaje ua){
        return DelegateUnidadDeAprendizaje.altaUnidadDeAprendizaje(ua);
    }
    
    /**
     * FACADE<br>
     * Borra una Unidad De Aprendizaje y regresa true si la operación fue exitosa.
     * @param ua El objeto UnidadDeAprendizaje a borrar.
     * @return true si la operación fue exitosa. false si no existe la id a borrar.
     */
    public boolean borrarUnidadDeAprendizaje(UnidadDeAprendizaje ua) {
        return DelegateUnidadDeAprendizaje.borrarUnidadDeAprendizaje(ua);
    }
    
    /**
     * FACADE<br>
     * Borra una Unidad De Aprendizaje por ID y regresa true si la operación fue exitosa.
     * @param id El id del registro a borrar.
     * @return true si la operación fue exitosa. false si no existe la id a borrar.
     */
    public boolean borrarUnidadDeAprendizaje(int id) {
        UnidadDeAprendizaje ua = new UnidadDeAprendizaje();
        ua.setIdunidadDeAprendizaje(id);
        return borrarUnidadDeAprendizaje(ua);
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
        
        /**
         * FACADE<br>
         * Regresa una lista con todas las UAs registrados en la BD.
         * @return Una lista de todos los registros de UAs de la tabla en la BD.
         */
        public List<UnidadDeAprendizaje> todos() {
            return DelegateUnidadDeAprendizaje.ConsultaUA.todos();
        }
    }
    
}
