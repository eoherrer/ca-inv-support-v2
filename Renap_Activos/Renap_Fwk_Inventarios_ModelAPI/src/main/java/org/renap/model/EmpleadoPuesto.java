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
@Table(name = "empleado_puesto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmpleadoPuesto.findAll", query = "SELECT e FROM EmpleadoPuesto e"),
    @NamedQuery(name = "EmpleadoPuesto.findByIdpuesto", query = "SELECT e FROM EmpleadoPuesto e WHERE e.idpuesto = :idpuesto"),
    @NamedQuery(name = "EmpleadoPuesto.findByNombre", query = "SELECT e FROM EmpleadoPuesto e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "EmpleadoPuesto.findByDescripcion", query = "SELECT e FROM EmpleadoPuesto e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "EmpleadoPuesto.findByEstado", query = "SELECT e FROM EmpleadoPuesto e WHERE e.estado = :estado"),
    @NamedQuery(name = "EmpleadoPuesto.findByUsuario", query = "SELECT e FROM EmpleadoPuesto e WHERE e.usuario = :usuario"),
    @NamedQuery(name = "EmpleadoPuesto.findByFecha", query = "SELECT e FROM EmpleadoPuesto e WHERE e.fecha = :fecha")})
public class EmpleadoPuesto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpuesto")
    private Integer idpuesto;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "estado")
    private Character estado;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleadoPuestoIdpuesto")
    private Collection<Empleado> empleadoCollection;

    public EmpleadoPuesto() {
    }

    public EmpleadoPuesto(Integer idpuesto) {
        this.idpuesto = idpuesto;
    }

    public Integer getIdpuesto() {
        return idpuesto;
    }

    public void setIdpuesto(Integer idpuesto) {
        this.idpuesto = idpuesto;
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

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
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
        hash += (idpuesto != null ? idpuesto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpleadoPuesto)) {
            return false;
        }
        EmpleadoPuesto other = (EmpleadoPuesto) object;
        if ((this.idpuesto == null && other.idpuesto != null) || (this.idpuesto != null && !this.idpuesto.equals(other.idpuesto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.orm.activosorm.EmpleadoPuesto[ idpuesto=" + idpuesto + " ]";
    }
    
}
