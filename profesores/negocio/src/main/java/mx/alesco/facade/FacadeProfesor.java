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
    
    public final ConsultaProfesor consultaProfesor = new ConsultaProfesor();
    
    public void guardarProfesor(Profesor profe){
        DelegateProfesor.saveProfesor(profe);
    }
    
    /**
     * Clase que agrupa los métodos de consulta de profesores.
     */
    public class ConsultaProfesor{
        /**
         * Busca un profesor por id y lo devuelve.
         * @param id El idProfesor que se busca.
         * @return El profesor que coincida con ese ID.
         */
        public Profesor porID(int id) {
            return DelegateProfesor.ConsultaProfesor.porID(id);
        } 
    }
    
}
