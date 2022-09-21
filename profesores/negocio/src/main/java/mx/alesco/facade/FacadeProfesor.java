/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.alesco.facade;

import mx.alesco.delegate.DelegateProfesor;
import mx.alesco.entidad.Profesor;

/**
 *
 * @author EduardoCardona <>
 */
public class FacadeProfesor {
    
    private final DelegateProfesor delegateProfesor;

    public FacadeProfesor() {
        this.delegateProfesor = new DelegateProfesor();
    }
    
    public void guardarProfesor(Profesor profe){
        delegateProfesor.saveProfesor(profe);
    }
    
    public Profesor consultarProfesor(Profesor profe) {
        return delegateProfesor.consultarProfesor(profe);
    }
    
}
