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
     * DELEGATE<br>
     * Guarda una nueva Unidad de Aprendizaje. No hay validación en caso de que ya exista un objeto con el mismo ID.
     * @param ua El objeto UnidadDeAprendizaje a guardar.
     */
    public static void saveUnidadDeAprendizaje(UnidadDeAprendizaje ua){
        ServiceLocator.getInstanceUnidadDeAprendizajeDAO().save(ua);
    }
    
    /**
     * DELEGATE<br>
     * Borra una Unidad De Aprendizaje. No hay validación en caso de que no exista lo que se quiere borrar.
     * @param ua El objeto UnidadDeAprendizaje a borrar.
     */
    public static void deleteUnidadDeAprendizaje(UnidadDeAprendizaje ua) {
        ServiceLocator.getInstanceUnidadDeAprendizajeDAO().delete(ua);
    }
    
    /**
     * DELEGATE<br>
     * Clase que agrupa las operaciones de consulta.
     */
    public static class ConsultaUA {
        /**
         * DELEGATE<br>
         * Busca una Unidad De Aprendizaje por ID y la retorna. No hay validación en caso de que no se encuentre.
         * @param id EL id de la UA a buscar.
         * @return La UnidadDeAprendizaje con la ID.
         */
        public static UnidadDeAprendizaje porID(int id_ua) {
            return ServiceLocator.getInstanceUnidadDeAprendizajeDAO().find(id_ua);
        }
    }
    
}