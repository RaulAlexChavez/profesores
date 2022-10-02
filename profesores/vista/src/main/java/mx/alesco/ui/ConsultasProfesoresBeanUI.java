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
import mx.alesco.helper.ConsultasProfesoresHelper;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.MatchMode;
import org.primefaces.model.SortMeta;
import org.primefaces.model.SortOrder;
/**
 *
 * @author Alex
 */
@ManagedBean(name = "consultasProfesorUI")
@SessionScoped
public class ConsultasProfesoresBeanUI implements Serializable{
    private ConsultasProfesoresHelper profeHelper;
    private List<Profesor> profesores;

    private List<SortMeta> sortBy;
    private List<FilterMeta> filterBy;
    private List<Profesor> filterProfesores;
    private boolean globalFilterOnly;
    
    @PostConstruct
    public void init(){
        globalFilterOnly = false;
        profesores = consultaProfesoresTodos();
        
        sortBy = new ArrayList<>();
        sortBy.add(SortMeta.builder()
                .field("nombre")
                .order(SortOrder.ASCENDING)
                .build());
        
        filterBy = new ArrayList<>();
        filterBy.add(FilterMeta.builder()
                .field("nombre")
                .filterValue("e")
                .matchMode(MatchMode.CONTAINS)
                .build());
    }
    
    public ConsultasProfesoresBeanUI() {
        profeHelper = new ConsultasProfesoresHelper();
    }
    
    public List<Profesor> consultaProfesoresTodos() {
        return profeHelper.consultaProfesorTodos();
    }
    
    public void actualizarConsultas() {
        profesores = consultaProfesoresTodos();
    }

    public List<SortMeta> getSortBy() {
        return sortBy;
    }

    public void setSortBy(List<SortMeta> sortBy) {
        this.sortBy = sortBy;
    }

    public List<FilterMeta> getFilterBy() {
        return filterBy;
    }

    public void setFilterBy(List<FilterMeta> filterBy) {
        this.filterBy = filterBy;
    }
    
    public List<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
    }

    public boolean isGlobalFilterOnly() {
        return globalFilterOnly;
    }

    public void setGlobalFilterOnly(boolean globalFilterOnly) {
        this.globalFilterOnly = globalFilterOnly;
    }    

    public List<Profesor> getFilterProfesores() {
        return filterProfesores;
    }

    public void setFilterProfesores(List<Profesor> filterProfesoresName) {
        this.filterProfesores = filterProfesoresName;
    }
    
}
