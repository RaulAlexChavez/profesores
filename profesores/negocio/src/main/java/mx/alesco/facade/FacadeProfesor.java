/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.alesco.facade;

import java.util.List;
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
     * Guarda un nuevo Profesor si no existe uno ya con esa ID.
     * @param profe El objeto Profesor a actualizar.
     * @return true si la alta fue exitosa. false si ya existía un Profesor con esa ID.
     */
    public boolean altaProfesor(Profesor profe){
        return DelegateProfesor.altaProfesor(profe);
    }
    
    /**
     * FACADE<br>
     * Actualiza un Profesor si es que existe en la BD.
     * @param profe El objeto Profesor a actualizar.
     * @return true si la alta fue exitosa. false si ya existía un Profesor con esa ID.
     */
    public boolean actualizarProfesor(Profesor profe){
        return DelegateProfesor.actualizarProfesor(profe);
    }
    
    /**
     * FACADE<br>
     * Borra un Profesor y regresa true si la operación fue exitosa.
     * @param profe El objeto Profesor a borrar.
     * @return true si la operación fue exitosa. false si no existe la id a borrar.
     */
    public boolean borrarProfesor(Profesor profe) {
        return DelegateProfesor.borrarProfesor(profe);
    }
    
    /**
     * FACADE<br>
     * Borra un Profesor por ID y regresa true si la operación fue exitosa.
     * @param id El id del registro a borrar.
     * @return true si la operación fue exitosa. false si no existe la id a borrar.
     */
    public boolean borrarProfesor(int id) {
        Profesor profe = new Profesor();
        profe.setIdprofesor(id);
        return borrarProfesor(profe);
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
        
        /**
         * FACADE<br>
         * Regresa una lista con todos los profesores registrados en la BD.
         * @return Una lista de todos los registros de profesores de la tabla en la BD.
         */
        public List<Profesor> todos() {
            return DelegateProfesor.ConsultaProfesor.todos();
        }
    }
    
}
