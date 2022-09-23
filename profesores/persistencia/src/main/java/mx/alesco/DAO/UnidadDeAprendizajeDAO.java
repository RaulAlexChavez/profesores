/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.alesco.DAO;

import java.util.List;
import mx.alesco.entidad.UnidadDeAprendizaje;
import mx.alesco.persistencia.AbstractDAO;

/**
 *
 * @author total
 */
public class UnidadDeAprendizajeDAO extends AbstractDAO<Integer, UnidadDeAprendizaje>{
    
    public boolean unidadDeAprendizajeAlreadyExistsWithID(int id) {
        List<UnidadDeAprendizaje> listUA = findAll();
        for(UnidadDeAprendizaje ua : listUA) {
            if(ua.getIdunidadDeAprendizaje() == id) {
                return true;
            }
        }
        return false;
    }
            
}
