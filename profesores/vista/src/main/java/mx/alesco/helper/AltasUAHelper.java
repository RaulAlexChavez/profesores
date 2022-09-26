/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.alesco.helper;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.faces.context.FacesContext;
import mx.alesco.entidad.UnidadDeAprendizaje;
import mx.alesco.integracion.ServiceFacadeLocator;

/**
 *
 * @author Alex
 */
public class AltasUAHelper implements Serializable{
    
    public boolean altaUA(UnidadDeAprendizaje ua) {
        return ServiceFacadeLocator.getInstanceFacadeUnidadDeAprendizaje().altaUnidadDeAprendizaje(ua);
    }
}