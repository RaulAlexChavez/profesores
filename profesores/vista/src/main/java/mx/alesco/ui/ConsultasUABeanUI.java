/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.alesco.ui;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import mx.alesco.entidad.UnidadDeAprendizaje;
import mx.alesco.helper.ConsultasUAHelper;
/**
 *
 * @author adame
 */
@ManagedBean(name = "consultasUA_UI")
@SessionScoped
public class ConsultasUABeanUI implements Serializable{
    private ConsultasUAHelper uaHelper;
    
    public ConsultasUABeanUI() {
        uaHelper = new ConsultasUAHelper();
    }
    
    public List<UnidadDeAprendizaje> consultaUATodas() {
        return uaHelper.consultaUATodos();
    } 
    
}
