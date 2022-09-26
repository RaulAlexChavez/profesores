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
 * @author Alex
 */
@ManagedBean(name = "altaUA_UI")
@SessionScoped
public class AltasUABeanUI implements Serializable{
    private AltasUAHelper uaHelper;
    private String nombre;
    private int hc;
    private int ht;
    private int hl;
    
    public AltasUABeanUI() {
        uaHelper = new AltasUAHelper();
    }
    
    
    /**
     * Metodo postconstructor todo lo que este dentro de este metodo
     * sera la primero que haga cuando cargue la pagina
     */
    @PostConstruct
    public void init(){
        System.out.println("Init postconstruct AltasUABeanUI");
    }
    
    public String altaUA() {
        System.out.println("Iniciando alta de profe desde BEAN UI...");
        System.out.println("Nombre: " + nombre);
        UnidadDeAprendizaje ua = new UnidadDeAprendizaje(9595, nombre, 0, 0, 0);
        boolean success = ServiceFacadeLocator.getInstanceFacadeUnidadDeAprendizaje().altaUnidadDeAprendizaje(ua);
        
        nombre = "";
        hc = 0;
        ht = 0;
        hl = 0;
        
        if(success) {
            return "consultaProfesores.xhtml";
        }
        return "index.xhtml";
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHc() {
        return hc;
    }

    public void setHc(int hc) {
        this.hc = hc;
    }

    public int getHt() {
        return ht;
    }

    public void setHt(int ht) {
        this.ht = ht;
    }

    public int getHl() {
        return hl;
    }

    public void setHl(int hl) {
        this.hl = hl;
    }

    

}
