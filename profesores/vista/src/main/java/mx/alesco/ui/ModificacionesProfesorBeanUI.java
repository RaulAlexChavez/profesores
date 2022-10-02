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
import mx.alesco.helper.ConsultasUAHelper;
import mx.alesco.helper.ModificacionesProfesorHelper;
import mx.alesco.integracion.ServiceFacadeLocator;
/**
 *
 * @author Alex
 */
@ManagedBean(name = "modProfe_UI")
@SessionScoped
public class ModificacionesProfesorBeanUI implements Serializable{
    private ModificacionesProfesorHelper profeHelper;
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
    
    public ModificacionesProfesorBeanUI() {
        profeHelper = new ModificacionesProfesorHelper();
    }
    
    public String modificarProfesor(int id) {
        defineValues(id);
        selectedUAsID = profeHelper.uasDeProfeEnString(idProfe);
        return "modifProfesores.xhtml?faces-redirect=true";
    }
    
    public void defineValues(int id){
        idProfe = id;
        Profesor profe = profeHelper.profesorPorId(id);
        nombre = profe.getNombre();
        apellido = profe.getApellido();
        rfc = profe.getRfc();
    }
    
    public String confirmarModificacionProfe() {
        if(!todosLosCamposLlenos()) {
            resultado = Resultado.MissingFields;
            return "modifProfesores.xhtml?faces-redirect=true";
        }
        
         /*UnidadDeAprendizaje unidadDeAprendizaje = profeHelper.unidadDeAprendizajePorId(idUA);
        if(unidadDeAprendizaje == null){
            resultado = Resultado.UAWithIdDoesntExist;
            return "altasProfesores.xhtml";
        }*/
        
        unidadDeAprendizajeList = new ArrayList<>();
        ConsultasUAHelper uaHelper = new ConsultasUAHelper();
        for(String ua_id_s : selectedUAsID){
            int ua_id = Integer.parseInt(ua_id_s);
            UnidadDeAprendizaje uaAux = uaHelper.uaPorId(ua_id);
            unidadDeAprendizajeList.add(uaAux);
        }
        
        Profesor profe = new Profesor(idProfe, nombre, apellido, rfc, unidadDeAprendizajeList);
        boolean success = profeHelper.modificarProfe(profe);
        
        if(success) {
            resultado = Resultado.Success;
            resetValues();
            return "consultaUA.xhtml";
        }
        else{
            resultado = Resultado.Error;
        }
        
        return "modifProfesores.xhtml?faces-redirect=true";
    }
    
    public String resultadoText() {
        switch(resultado) {
            case None:
                return "";
            case Success:
                return "La modificación de Profesor ha sido exitosa.";
            case Error:
                return "No se ha podido realizar la modificación de Profesor. Es posible que el ID ya esté ocupado.";
            case MissingFields:
                return "No se han llenado todos los campos necesarios.";
            case UAWithIdDoesntExist:
                return "No existe ninguna unidad de aprendizaje con el ID especificado.";
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
            case UAWithIdDoesntExist:
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

    public ArrayList<String> getSelectedUAsID() {
        return selectedUAsID;
    }

    public void setSelectedUAsID(ArrayList<String> selectedUAsID) {
        this.selectedUAsID = selectedUAsID;
    }

}
