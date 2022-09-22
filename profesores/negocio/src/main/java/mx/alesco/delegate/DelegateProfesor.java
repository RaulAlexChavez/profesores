/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.alesco.delegate;

import mx.alesco.entidad.Profesor;
import mx.alesco.integracion.ServiceLocator;

/**
 *
 * @author EduardoCardona <>
 */
public class DelegateProfesor {
    
    /**
     * DELEGATE<br>
     * Guarda un nuevo Profesor. No hay validación en caso de que ya exista un objeto con el mismo ID.
     * @param profe El objeto Profesor a guardar.
     */
    public static void saveProfesor(Profesor profe){
        ServiceLocator.getInstanceProfesorDAO().save(profe);
    }

    /**
     * DELEGATE<br>
     * Clase para agrupar consultas de profesor.
     */
    public static class ConsultaProfesor {
        /**
         * FACADE<br>
         * Busca un profesor por id y lo devuelve.
         * @param id El idProfesor que se busca.
         * @return El profesor que coincida con ese ID.
         */
        public static Profesor porID(int id) {
            return ServiceLocator.getInstanceProfesorDAO().find(id);
        }
    }
    
}
