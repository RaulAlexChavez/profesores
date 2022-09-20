/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.alesco.entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author chave
 */
@Entity
@Table(name = "profesor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profesor.findAll", query = "SELECT p FROM Profesor p")
    , @NamedQuery(name = "Profesor.findByIdprofesor", query = "SELECT p FROM Profesor p WHERE p.idprofesor = :idprofesor")
    , @NamedQuery(name = "Profesor.findByNombre", query = "SELECT p FROM Profesor p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Profesor.findByApellido", query = "SELECT p FROM Profesor p WHERE p.apellido = :apellido")
    , @NamedQuery(name = "Profesor.findByRfc", query = "SELECT p FROM Profesor p WHERE p.rfc = :rfc")})
public class Profesor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idprofesor")
    private Integer idprofesor;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "RFC")
    private String rfc;
    @JoinTable(name = "relacion", joinColumns = {
        @JoinColumn(name = "profesor_idprofesor", referencedColumnName = "idprofesor")}, inverseJoinColumns = {
        @JoinColumn(name = "unidad_de_aprendizaje_idunidad_de_aprendizaje", referencedColumnName = "idunidad_de_aprendizaje")})
    @ManyToMany
    private List<UnidadDeAprendizaje> unidadDeAprendizajeList;

    public Profesor() {
    }

    public Profesor(Integer idprofesor) {
        this.idprofesor = idprofesor;
    }

    public Integer getIdprofesor() {
        return idprofesor;
    }

    public void setIdprofesor(Integer idprofesor) {
        this.idprofesor = idprofesor;
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

    @XmlTransient
    public List<UnidadDeAprendizaje> getUnidadDeAprendizajeList() {
        return unidadDeAprendizajeList;
    }

    public void setUnidadDeAprendizajeList(List<UnidadDeAprendizaje> unidadDeAprendizajeList) {
        this.unidadDeAprendizajeList = unidadDeAprendizajeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprofesor != null ? idprofesor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesor)) {
            return false;
        }
        Profesor other = (Profesor) object;
        if ((this.idprofesor == null && other.idprofesor != null) || (this.idprofesor != null && !this.idprofesor.equals(other.idprofesor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.alesco.entidad.Profesor[ idprofesor=" + idprofesor + " ]";
    }
    
}
