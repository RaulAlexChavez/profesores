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
import mx.alesco.helper.AltasUAHelper;
import mx.alesco.integracion.ServiceFacadeLocator;
/**
 *
 * @author adame
 */
@ManagedBean(name = "altaUA_UI")
@SessionScoped
public class AltasUABeanUI implements Serializable{
    private AltasUAHelper uaHelper;
    private String nombre;
    private String apellido;
    
    public AltasUABeanUI() {
        uaHelper = new AltasUAHelper();
    }
    
    /**
     * Metodo postconstructor todo lo que este dentro de este metodo
     * sera la primero que haga cuando cargue la pagina
     */
    @PostConstruct
    public void init(){
        return;
    }
    
    public void altaUA() {
        System.out.println("Iniciando alta de profe desde BEAN UI...");
        System.out.println("Nombre: " + nombre);
        UnidadDeAprendizaje ua = new UnidadDeAprendizaje(9595, nombre, 0, 0, 0);
        ServiceFacadeLocator.getInstanceFacadeUnidadDeAprendizaje().altaUnidadDeAprendizaje(ua);
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

}
