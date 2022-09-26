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
import mx.alesco.helper.BajasProfesorHelper;
import mx.alesco.integracion.ServiceFacadeLocator;
/**
 *
 * @author Alex
 */
@ManagedBean(name = "bajaProfe_UI")
@SessionScoped
public class BajasProfesorBeanUI implements Serializable{
    private BajasProfesorHelper profeHelper;
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
        Error,
        MissingFields,
        UAWithIdDoesntExist
    } 
    Resultado resultado = Resultado.None;
    
    public BajasProfesorBeanUI() {
        profeHelper = new BajasProfesorHelper();
    }
    
    public String borrarConfirmacion(int id) {
        defineValues(id);
        return "bajaProfesores.xhtml";
    }
    
    public void defineValues(int id){
        idProfe = id;
        Profesor profe = profeHelper.profesorPorId(id);
        nombre = profe.getNombre();
        apellido = profe.getApellido();
        rfc = profe.getRfc();
    }
    
    public String bajaProfe() {
        if(!todosLosCamposLlenos()) {
            resultado = Resultado.MissingFields;
            return "bajaProfesores.xhtml";
        }
        
        UnidadDeAprendizaje unidadDeAprendizaje = null;
        Profesor profe = new Profesor(idProfe, nombre, apellido, rfc, unidadDeAprendizaje);
        boolean success = profeHelper.bajaProfe(profe);
        
        if(success) {
            resultado = Resultado.Success;
            resetValues();
            return "consultaProfesores.xhtml";
        }
        else{
            resultado = Resultado.Error;
        }
        
        return "bajaProfesores.xhtml";
    }
    
    public String resultadoText() {
        switch(resultado) {
            case None:
                return "";
            case Success:
                return "La baja de Profesor ha sido exitosa.";
            case Error:
                return "No se ha podido realizar la baja de Profesor. Es posible que el ID no exista.";
            case MissingFields:
                return "No se han llenado todos los campos necesarios.";
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
            case MissingFields:
                return "error";
        }
        return "invisible";
    }
    
    public boolean todosLosCamposLlenos() {
        return
        !"".equals(nombre) &&
        !"".equals(apellido) &&
        !"".equals(rfc);
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
