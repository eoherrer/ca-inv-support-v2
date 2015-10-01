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
@Table(name = "dependencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dependencia.findAll", query = "SELECT d FROM Dependencia d"),
    @NamedQuery(name = "Dependencia.findByIddependencia", query = "SELECT d FROM Dependencia d WHERE d.iddependencia = :iddependencia"),
    @NamedQuery(name = "Dependencia.findByNombre", query = "SELECT d FROM Dependencia d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "Dependencia.findByObservaciones", query = "SELECT d FROM Dependencia d WHERE d.observaciones = :observaciones"),
    @NamedQuery(name = "Dependencia.findByUsuario", query = "SELECT d FROM Dependencia d WHERE d.usuario = :usuario"),
    @NamedQuery(name = "Dependencia.findByFecha", query = "SELECT d FROM Dependencia d WHERE d.fecha = :fecha")})
public class Dependencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddependencia")
    private Integer iddependencia;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "observaciones")
    private String observaciones;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dependenciaIddependencia")
    private Collection<Empleado> empleadoCollection;

    public Dependencia() {
    }

    public Dependencia(Integer iddependencia) {
        this.iddependencia = iddependencia;
    }

    public Integer getIddependencia() {
        return iddependencia;
    }

    public void setIddependencia(Integer iddependencia) {
        this.iddependencia = iddependencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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
        hash += (iddependencia != null ? iddependencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dependencia)) {
            return false;
        }
        Dependencia other = (Dependencia) object;
        if ((this.iddependencia == null && other.iddependencia != null) || (this.iddependencia != null && !this.iddependencia.equals(other.iddependencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.orm.activosorm.Dependencia[ iddependencia=" + iddependencia + " ]";
    }
    
}
