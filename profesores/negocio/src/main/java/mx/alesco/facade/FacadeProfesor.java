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
    
    /**
     * FACADE<br>
     * Instancia de una clase que agrupa los métodos de consulta de profesores.
     */
    public final ConsultaProfesor consultaProfesor = new ConsultaProfesor();
    
    /**
     * FACADE<br>
     * Guarda un nuevo Profesor. No hay validación en caso de que ya exista un objeto con el mismo ID.
     * @param profe El objeto Profesor a guardar.
     */
    public void guardarProfesor(Profesor profe){
        DelegateProfesor.saveProfesor(profe);
    }
    
    /**
     * FACADE<br>
     * Clase que agrupa los métodos de consulta de profesores.
     */
    public class ConsultaProfesor{
        /**
         * FACADE<br>
         * Busca un profesor por id y lo devuelve.
         * @param id El idProfesor que se busca.
         * @return El profesor que coincida con ese ID.
         */
        public Profesor porID(int id) {
            return DelegateProfesor.ConsultaProfesor.porID(id);
        } 
    }
    
}
