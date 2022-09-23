/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.alesco.DAO;

import java.util.List;
import mx.alesco.entidad.Profesor;
import mx.alesco.persistencia.AbstractDAO;

/**
 *
 * @author Raúl Alex Chávez
 */
public class ProfesorDAO extends AbstractDAO<Integer, Profesor>{
    
    /**
     * Revisa si en la BD existe un registro con un ID y regresa true si es así.
     * @param id El id a buscar.
     * @return true si encuentra un registro con el id. false si no.
     */
    public boolean profesorAlreadyExistsWithID(int id) {
        List<Profesor> listProfes = findAll();
        for(Profesor profe : listProfes) {
            if(profe.getIdprofesor() == id) {
                return true;
            }
        }
        return false;
    }
    
}
