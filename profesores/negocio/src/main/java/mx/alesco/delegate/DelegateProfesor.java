/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.alesco.delegate;

import java.util.List;
import mx.alesco.entidad.Profesor;
import mx.alesco.DAO.ProfesorDAO;
import mx.alesco.integracion.ServiceLocator;

/**
 *
 * @author EduardoCardona <>
 */
public class DelegateProfesor {
    
    /**
     * DELEGATE
     * Guarda un nuevo Profesor si no existe uno ya con el mismo ID.
     * @param ua El objeto Profesor a guardar.
     * @return true si la alta fue exitosa. false si ya existía un Profesor con esa ID.
     */
    public static boolean altaProfesor(Profesor profe){
        ProfesorDAO profeDAO = ServiceLocator.getInstanceProfesorDAO();
        if(profeDAO.profesorAlreadyExistsWithID(profe.getIdprofesor())) {
            return false;
        }
        else{
            profeDAO.save(profe);
            return true;
        }
    }

    /**
     * DELEGATE<br>
     * Clase para agrupar consultas de profesor.
     */
    public static class ConsultaProfesor {
        /**
         * DELEGATE<br>
         * Busca un profesor por id y lo devuelve.
         * @param id El idProfesor que se busca.
         * @return El profesor que coincida con ese ID.
         */
        public static Profesor porID(int id) {
            return ServiceLocator.getInstanceProfesorDAO().find(id);
        }
        
        /**
         * DELEGATE<br>
         * Regresa una lista con todos los profesores registrados en la BD.
         * @return Una lista de todos los registros de profesores de la tabla en la BD.
         */
        public static List<Profesor> todos() {
            return ServiceLocator.getInstanceProfesorDAO().findAll();
        }
    }
    
}
