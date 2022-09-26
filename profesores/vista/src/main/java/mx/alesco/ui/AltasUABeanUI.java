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
    private int idUA;
    private String nombre;
    private int hc;
    private int ht;
    private int hl;
    
    public enum Resultado {
        None,
        Success,
        Error
    } 
    Resultado resultado = Resultado.None;
    
    public AltasUABeanUI() {
        uaHelper = new AltasUAHelper();
    }
    
    public String altaUA() {
        UnidadDeAprendizaje ua = new UnidadDeAprendizaje(idUA, nombre, hc, ht, hl);
        boolean success = uaHelper.altaUA(ua);
        
        if(success) {
            resultado = Resultado.Success;
            resetValues();
        }
        else{
            resultado = Resultado.Error;
        }
        
        return "altasUA.xhtml";
    }
    
    public String resultadoText() {
        switch(resultado) {
            case None:
                return "";
            case Success:
                return "La alta ha sido exitosa.";
            case Error:
                return "No se ha podido realizar la alta. Es posible que el ID ya esté ocupado.";
        }
        return "";
    }
    
    public String resultadoClass() {
        switch(resultado) {
            case None:
                return "invisible";
            case Success:
                return "success";
            case Error:
                return "error";
        }
        return "invisible";
    }
    
    public void resetValues(){
        nombre = "";
        hc = 0;
        ht = 0;
        hl = 0;
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

    public int getIdUA() {
        return idUA;
    }

    public void setIdUA(int idUA) {
        this.idUA = idUA;
    }

}
