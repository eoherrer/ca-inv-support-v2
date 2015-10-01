/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.renap.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 1808236120101
 */
@Entity
@Table(name = "empleado_reglon")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmpleadoReglon.findAll", query = "SELECT e FROM EmpleadoReglon e"),
    @NamedQuery(name = "EmpleadoReglon.findByIdempleadoReglon", query = "SELECT e FROM EmpleadoReglon e WHERE e.idempleadoReglon = :idempleadoReglon"),
    @NamedQuery(name = "EmpleadoReglon.findByNombre", query = "SELECT e FROM EmpleadoReglon e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "EmpleadoReglon.findByDescripcion", query = "SELECT e FROM EmpleadoReglon e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "EmpleadoReglon.findByEstado", query = "SELECT e FROM EmpleadoReglon e WHERE e.estado = :estado"),
    @NamedQuery(name = "EmpleadoReglon.findByUsuario", query = "SELECT e FROM EmpleadoReglon e WHERE e.usuario = :usuario"),
    @NamedQuery(name = "EmpleadoReglon.findByFecha", query = "SELECT e FROM EmpleadoReglon e WHERE e.fecha = :fecha")})
public class EmpleadoReglon implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idempleado_reglon")
    private Integer idempleadoReglon;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "estado")
    private String estado;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleadoReglonIdempleadoReglon")
    private Collection<Empleado> empleadoCollection;

    public EmpleadoReglon() {
    }

    public EmpleadoReglon(Integer idempleadoReglon) {
        this.idempleadoReglon = idempleadoReglon;
    }

    public Integer getIdempleadoReglon() {
        return idempleadoReglon;
    }

    public void setIdempleadoReglon(Integer idempleadoReglon) {
        this.idempleadoReglon = idempleadoReglon;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @XmlTransient
    public Collection<Empleado> getEmpleadoCollection() {
        return empleadoCollection;
    }

    public void setEmpleadoCollection(Collection<Empleado> empleadoCollection) {
        this.empleadoCollection = empleadoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idempleadoReglon != null ? idempleadoReglon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpleadoReglon)) {
            return false;
        }
        EmpleadoReglon other = (EmpleadoReglon) object;
        if ((this.idempleadoReglon == null && other.idempleadoReglon != null) || (this.idempleadoReglon != null && !this.idempleadoReglon.equals(other.idempleadoReglon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.orm.activosorm.EmpleadoReglon[ idempleadoReglon=" + idempleadoReglon + " ]";
    }
    
}
