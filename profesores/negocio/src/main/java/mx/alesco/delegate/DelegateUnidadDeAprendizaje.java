/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.alesco.delegate;

import java.util.List;
import mx.alesco.entidad.UnidadDeAprendizaje;
import mx.alesco.DAO.UnidadDeAprendizajeDAO;
import mx.alesco.entidad.Profesor;
import mx.alesco.integracion.ServiceLocator;

/**
 *
 * @author EduardoCardona <>
 */
public class DelegateUnidadDeAprendizaje {
    
    /**
     * DELEGATE
     * Guarda una nueva Unidad de Aprendizaje si no existe una ya con el mismo ID.
     * @param ua El objeto UnidadDeAprendizaje a guardar.
     * @return true si la alta fue exitosa. false si ya existía una UA con esa ID.
     */
    public static boolean altaUnidadDeAprendizaje(UnidadDeAprendizaje ua){
        UnidadDeAprendizajeDAO uaDAO = ServiceLocator.getInstanceUnidadDeAprendizajeDAO();
        if(uaDAO.unidadDeAprendizajeAlreadyExistsWithID(ua.getIdunidadDeAprendizaje())) {
            return false;
        }
        else{
            uaDAO.save(ua);
            return true;
        }
    }
    
    /**
     * DELEGATE<br>
     * Borra una Unidad De Aprendizaje. No hay validación en caso de que no exista lo que se quiere borrar.
     * @param ua El objeto UnidadDeAprendizaje a borrar.
     */
    public static void borrarUnidadDeAprendizaje(UnidadDeAprendizaje ua) {
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
        
        /**
         * DELEGATE<br>
         * Regresa una lista con todas las UAs registrados en la BD.
         * @return Una lista de todos los registros de UAs de la tabla en la BD.
         */
        public static List<UnidadDeAprendizaje> todos() {
            return ServiceLocator.getInstanceUnidadDeAprendizajeDAO().findAll();
        }
    }
    
}