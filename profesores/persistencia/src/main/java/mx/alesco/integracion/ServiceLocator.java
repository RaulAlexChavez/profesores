/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.alesco.integracion;

import mx.alesco.DAO.ProfesorDAO;
import mx.alesco.DAO.UnidadDeAprendizajeDAO;


/**
 *
 * @author total
 */
public class ServiceLocator {
    
    private static ProfesorDAO profesorDAO;
    private static UnidadDeAprendizajeDAO unidadDeAprendizajeDAO;
    /**
     * se crea la instancia para profesor DAO si esta no existe
     */
    public static ProfesorDAO getInstanceAlumnoDAO(){
        if(profesorDAO == null){
            profesorDAO = new ProfesorDAO();
            return profesorDAO;
        } else{
            return profesorDAO;
        }
    }
    /**
     * se crea la instancia de unidadDeAprendizajeDAO si esta no existe
     */
    public static UnidadDeAprendizajeDAO getInstanceUsuarioDAO(){
        if(unidadDeAprendizajeDAO == null){
            unidadDeAprendizajeDAO = new UnidadDeAprendizajeDAO();
            return unidadDeAprendizajeDAO;
        } else{
            return unidadDeAprendizajeDAO;
        }
    }
    
}
