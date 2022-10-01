/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.alesco.ui;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import mx.alesco.entidad.Profesor;
import mx.alesco.entidad.UnidadDeAprendizaje;
import mx.alesco.helper.AltasProfesorHelper;
import mx.alesco.helper.ConsultasUAHelper;
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
    private ArrayList<String> selectedUAsID;
    private List<UnidadDeAprendizaje> unidadDeAprendizajeList;
    
    public enum Resultado {
        None,
        Success,
        Error,
        MissingFields,
        UAWithIdDoesntExist
    } 
    Resultado resultado = Resultado.None;
    
    public AltasProfesorBeanUI() {
        profeHelper = new AltasProfesorHelper();
    }
    
    public String altaProfe() {
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message;
        
        if(!todosLosCamposLlenos()) {
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "No se han llenado todos los campos necesarios.", "");
            context.addMessage("general-altasProfesores", message);
            return "altasProfesores.xhtml";
        }
        
        if(!isRFCValid()) {
            return "altasProfesores.xhtml";
        }
        
        unidadDeAprendizajeList = new ArrayList<>();
        ConsultasUAHelper uaHelper = new ConsultasUAHelper();
        for(String ua_id_s : selectedUAsID){
            int ua_id = Integer.parseInt(ua_id_s);
            UnidadDeAprendizaje uaAux = uaHelper.uaPorId(ua_id);
            unidadDeAprendizajeList.add(uaAux);
        }
        
        Profesor profe = new Profesor(idProfe, nombre, apellido, rfc, unidadDeAprendizajeList/*unidadDeAprendizaje*/);
        boolean success = profeHelper.altaProfe(profe);
        
        if(success) {
            resetValues();
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, ("El/la profesor(a) " + nombre + " se ha dado de alta correctamente."), "");
            context.addMessage("general-altasProfesores", message);
        }
        else{
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se ha podido dar la alta.", "Es posible que el ID ya esté ocupado.");
            context.addMessage("general-altasProfesores", message);
        }
        
        return "altasProfesores.xhtml";
    }
    
    public boolean todosLosCamposLlenos() {
        return
        !"".equals(nombre) &&
        !"".equals(apellido) &&
        !"".equals(rfc);
    }
    
    public boolean isRFCValid() {
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message;
        
        if(rfc.length() != 13) {
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "El RFC debe tener 13 caracteres.", "");
            context.addMessage("rfc-altasProfesores", message);
            return false;
        }
        
        return true;
    }
    
    public void resetValues(){
        idProfe = 0;
        nombre = "";
        apellido = "";
        rfc = "";
        ua = null;
        /*unidadDeAprendizajeList = null;*/
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

    public ArrayList<String> getSelectedUAsID() {
        return selectedUAsID;
    }

    public void setSelectedUAsID(ArrayList<String> selectedUAsID) {
        this.selectedUAsID = selectedUAsID;
    }

}
