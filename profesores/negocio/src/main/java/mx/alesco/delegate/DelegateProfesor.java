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
     * Metodo de ejemplo para guardar Profesor
     * @param profe de tipo Profesor con id 0 para que se cree un id nuevo.
     */
    public static void saveProfesor(Profesor profe){
        ServiceLocator.getInstanceProfesorDAO().save(profe);
    }

    public static class ConsultaProfesor {
        public static Profesor porID(int id) {
            return ServiceLocator.getInstanceProfesorDAO().find(id);
        }
    }
    
}
