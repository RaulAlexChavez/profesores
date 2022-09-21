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
    public void saveProfesor(Profesor profe){
        ServiceLocator.getInstanceProfesor().save(profe);
    }
    
    public Profesor consultarProfesor(Profesor profe) {
        return ServiceLocator.getInstanceProfesor().find(profe.getIdprofesor());
    }
    
}
