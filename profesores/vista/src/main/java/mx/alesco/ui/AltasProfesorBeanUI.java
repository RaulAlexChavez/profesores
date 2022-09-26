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
import mx.alesco.entidad.Profesor;
import mx.alesco.entidad.UnidadDeAprendizaje;
import mx.alesco.helper.AltasProfesorHelper;
import mx.alesco.integracion.ServiceFacadeLocator;
/**
 *
 * @author Alex
 */
@ManagedBean(name = "altaProfe_UI")
@SessionScoped
public class AltasProfesorBeanUI implements Serializable{
    private AltasProfesorHelper profeHelper;
    private int idProfe;
    private String nombre;
    private String apellido;
    private String rfc;
    private int idUA;
    private UnidadDeAprendizaje ua;
    private List<UnidadDeAprendizaje> unidadDeAprendizajeList;
    
    public enum Resultado {
        None,
        Success,
        Error
    } 
    Resultado resultado = Resultado.None;
    
    public AltasProfesorBeanUI() {
        profeHelper = new AltasProfesorHelper();
    }
    
    public String altaProfe() {
        UnidadDeAprendizaje unidadDeAprendizaje = profeHelper.unidadDeAprendizajePorId(idUA);
        Profesor profe = new Profesor(idProfe, nombre, apellido, rfc, unidadDeAprendizaje);
        boolean success = profeHelper.altaProfe(profe);
        
        if(success) {
            resultado = Resultado.Success;
            resetValues();
        }
        else{
            resultado = Resultado.Error;
        }
        
        return "altasProfesores.xhtml";
    }
    
    public String resultadoText() {
        switch(resultado) {
            case None:
                return "";
            case Success:
                return "La alta de Profesor ha sido exitosa.";
            case Error:
                return "No se ha podido realizar la alta de Profesor. Es posible que el ID ya esté ocupado.";
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
        idProfe = 0;
        nombre = "";
        apellido = "";
        rfc = "";
        ua = null;
        unidadDeAprendizajeList = null;
    }

    public int getIdProfe() {
        return idProfe;
    }

    public void setIdProfe(int idProfe) {
        this.idProfe = idProfe;
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

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public int getIdUA() {
        return idUA;
    }

    public void setIdUA(int idUA) {
        this.idUA = idUA;
    }

    public UnidadDeAprendizaje getUa() {
        return ua;
    }

    public void setUa(UnidadDeAprendizaje ua) {
        this.ua = ua;
    }

    public List<UnidadDeAprendizaje> getUnidadDeAprendizajeList() {
        return unidadDeAprendizajeList;
    }

    public void setUnidadDeAprendizajeList(List<UnidadDeAprendizaje> unidadDeAprendizajeList) {
        this.unidadDeAprendizajeList = unidadDeAprendizajeList;
    }

    public Resultado getResultado() {
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }
    
    

}
