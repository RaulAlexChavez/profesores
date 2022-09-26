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
import mx.alesco.helper.ConsultasProfesoresHelper;
/**
 *
 * @author adame
 */
@ManagedBean(name = "consultasProfesorUI")
@SessionScoped
public class AltasUABeanUI implements Serializable{
    private ConsultasProfesoresHelper profeHelper;
    private List<Profesor> profesoresTodos;
    
    public AltasUABeanUI() {
        profeHelper = new ConsultasProfesoresHelper();
    }
    
    /**
     * Metodo postconstructor todo lo que este dentro de este metodo
     * sera la primero que haga cuando cargue la pagina
     */
    @PostConstruct
    public void init(){
        profesoresTodos = consultaProfesoresTodos();
    }
    
    public List<Profesor> consultaProfesoresTodos() {
        return profeHelper.consultaProfesorTodos();
    }
    
    public List<Profesor> getProfesoresTodos() {
        return profesoresTodos;
    }

    public void setProfesoresTodos(List<Profesor> profesoresTodos) {
        this.profesoresTodos = profesoresTodos;
    }

}
