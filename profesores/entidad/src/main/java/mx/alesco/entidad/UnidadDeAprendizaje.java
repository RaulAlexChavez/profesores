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
@Table(name = "unidad_de_aprendizaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UnidadDeAprendizaje.findAll", query = "SELECT u FROM UnidadDeAprendizaje u")
    , @NamedQuery(name = "UnidadDeAprendizaje.findByIdunidadDeAprendizaje", query = "SELECT u FROM UnidadDeAprendizaje u WHERE u.idunidadDeAprendizaje = :idunidadDeAprendizaje")
    , @NamedQuery(name = "UnidadDeAprendizaje.findByNombreUA", query = "SELECT u FROM UnidadDeAprendizaje u WHERE u.nombreUA = :nombreUA")
    , @NamedQuery(name = "UnidadDeAprendizaje.findByHorasClase", query = "SELECT u FROM UnidadDeAprendizaje u WHERE u.horasClase = :horasClase")
    , @NamedQuery(name = "UnidadDeAprendizaje.findByHorasTaller", query = "SELECT u FROM UnidadDeAprendizaje u WHERE u.horasTaller = :horasTaller")
    , @NamedQuery(name = "UnidadDeAprendizaje.findByHorasLaboratorio", query = "SELECT u FROM UnidadDeAprendizaje u WHERE u.horasLaboratorio = :horasLaboratorio")})
public class UnidadDeAprendizaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idunidad_de_aprendizaje")
    private Integer idunidadDeAprendizaje;
    @Column(name = "nombreUA")
    private String nombreUA;
    @Column(name = "horasClase")
    private Integer horasClase;
    @Column(name = "horasTaller")
    private Integer horasTaller;
    @Column(name = "horasLaboratorio")
    private Integer horasLaboratorio;
    @ManyToMany(mappedBy = "unidadDeAprendizajeList")
    private List<Profesor> profesorList;

    public UnidadDeAprendizaje() {
    }

    public UnidadDeAprendizaje(Integer idunidadDeAprendizaje) {
        this.idunidadDeAprendizaje = idunidadDeAprendizaje;
    }

    public UnidadDeAprendizaje(Integer idunidadDeAprendizaje, String nombreUA, Integer horasClase, Integer horasTaller, Integer horasLaboratorio) {
        this.idunidadDeAprendizaje = idunidadDeAprendizaje;
        this.nombreUA = nombreUA;
        this.horasClase = horasClase;
        this.horasTaller = horasTaller;
        this.horasLaboratorio = horasLaboratorio;
    }

    public Integer getIdunidadDeAprendizaje() {
        return idunidadDeAprendizaje;
    }

    public void setIdunidadDeAprendizaje(Integer idunidadDeAprendizaje) {
        this.idunidadDeAprendizaje = idunidadDeAprendizaje;
    }

    public String getNombreUA() {
        return nombreUA;
    }

    public void setNombreUA(String nombreUA) {
        this.nombreUA = nombreUA;
    }

    public Integer getHorasClase() {
        return horasClase;
    }

    public void setHorasClase(Integer horasClase) {
        this.horasClase = horasClase;
    }

    public Integer getHorasTaller() {
        return horasTaller;
    }

    public void setHorasTaller(Integer horasTaller) {
        this.horasTaller = horasTaller;
    }

    public Integer getHorasLaboratorio() {
        return horasLaboratorio;
    }

    public void setHorasLaboratorio(Integer horasLaboratorio) {
        this.horasLaboratorio = horasLaboratorio;
    }

    @XmlTransient
    public List<Profesor> getProfesorList() {
        return profesorList;
    }

    public void setProfesorList(List<Profesor> profesorList) {
        this.profesorList = profesorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idunidadDeAprendizaje != null ? idunidadDeAprendizaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnidadDeAprendizaje)) {
            return false;
        }
        UnidadDeAprendizaje other = (UnidadDeAprendizaje) object;
        if ((this.idunidadDeAprendizaje == null && other.idunidadDeAprendizaje != null) || (this.idunidadDeAprendizaje != null && !this.idunidadDeAprendizaje.equals(other.idunidadDeAprendizaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.alesco.entidad.UnidadDeAprendizaje[ idunidadDeAprendizaje=" + idunidadDeAprendizaje + " ]";
    }
    
}
