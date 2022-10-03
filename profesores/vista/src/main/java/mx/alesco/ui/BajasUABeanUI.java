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
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import mx.alesco.entidad.Profesor;
import mx.alesco.entidad.UnidadDeAprendizaje;
import mx.alesco.helper.BajasUAHelper;
import mx.alesco.integracion.ServiceFacadeLocator;
/**
 *
 * @author Alex
 */
@ManagedBean(name = "bajaUA_UI")
@SessionScoped
public class BajasUABeanUI implements Serializable{
    private BajasUAHelper UAHelper;
    private int idUA;
    private String nombreUA;
    private int horasClase;
    private int horasTaller;
    private int horasLab;
    private List<UnidadDeAprendizaje> unidadDeAprendizajeList;
    
    @ManagedProperty(value="#{consultasUA_UI}")
    private ConsultasUABeanUI consultasUAUI;
    
    public enum Resultado {
        None,
        Success,
        Error,
        MissingFields,
        UAWithIdDoesntExist
    } 
    Resultado resultado = Resultado.None;
    
    public BajasUABeanUI() {
        UAHelper = new BajasUAHelper();
    }
    
    public String borrarConfirmacion(int id) {
        defineValues(id);
        return "bajaUA.xhtml";
    }
    
    public void defineValues(int id){
        idUA = id;
        UnidadDeAprendizaje ua = UAHelper.unidadDeAprendizajePorId(id);
        nombreUA = ua.getNombreUA();
        horasClase = ua.getHorasClase();
        horasTaller = ua.getHorasTaller();
        horasLab = ua.getHorasLaboratorio();
    }
    
    public String bajaUA() {
        if(!todosLosCamposLlenos()) {
            resultado = Resultado.MissingFields;
            return "bajaUA.xhtml";
        }
        
        //UnidadDeAprendizaje unidadDeAprendizaje = null;
        UnidadDeAprendizaje ua = new UnidadDeAprendizaje(idUA, nombreUA, horasClase, horasTaller, horasLab);
        ua.setProfesorList(null);
        //UnidadDeAprendizaje ua = UAHelper.unidadDeAprendizajePorId(idUA);
        boolean success = UAHelper.bajaUA(ua);
        
        if(success) {
            resultado = Resultado.Success;
            resetValues();
            //consultasUAUI.actualizarConsultas();
            return "consultaUA.xhtml";
        }
        else{
            resultado = Resultado.Error;
        }
        
        return "bajaUA.xhtml";
    }
    
    public String resultadoText() {
        switch(resultado) {
            case None:
                return "";
            case Success:
                return "La baja de la Unidad de Aprendizaje ha sido exitosa.";
            case Error:
                return "No se ha podido realizar la baja de la Unidad de Aprendizaje. Es posible que el ID no exista.";
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
        !"".equals(nombreUA) &&
        !"".equals(horasClase) &&
        !"".equals(horasTaller) &&
        !"".equals(horasLab);
    }
    
    public void resetValues(){
        idUA = 0;
        nombreUA = "";
        horasClase = 0;
        horasTaller = 0;
        horasLab = 0;
        unidadDeAprendizajeList = null;
    }

    public int getIdUA() {
        return idUA;
    }

    public void setIdUA(int idUA) {
        this.idUA = idUA;
    }

    public String getNombreUA() {
        return nombreUA;
    }

    public void setNombreUA(String nombreUA) {
        this.nombreUA = nombreUA;
    }

    public int getHorasClase() {
        return horasClase;
    }

    public void setHorasClase(int horasClase) {
        this.horasClase = horasClase;
    }

    public int getHorasTaller() {
        return horasTaller;
    }

    public void setHorasTaller(int horasTaller) {
        this.horasTaller = horasTaller;
    }

    public int getHorasLab() {
        return horasLab;
    }

    public void setHorasLab(int horasLab) {
        this.horasLab = horasLab;
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

    public ConsultasUABeanUI getConsultasUAUI() {
        return consultasUAUI;
    }

    public void setConsultasUAUI(ConsultasUABeanUI consultasProfeUI) {
        this.consultasUAUI = consultasUAUI;
    }

}
