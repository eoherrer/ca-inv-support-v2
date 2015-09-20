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
@Table(name = "activo_solicitud_det")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActivoSolicitudDet.findAll", query = "SELECT a FROM ActivoSolicitudDet a"),
    @NamedQuery(name = "ActivoSolicitudDet.findByIdactivoSolicitudDet", query = "SELECT a FROM ActivoSolicitudDet a WHERE a.idactivoSolicitudDet = :idactivoSolicitudDet"),
    @NamedQuery(name = "ActivoSolicitudDet.findByCantidad", query = "SELECT a FROM ActivoSolicitudDet a WHERE a.cantidad = :cantidad"),
    @NamedQuery(name = "ActivoSolicitudDet.findByDescripcion", query = "SELECT a FROM ActivoSolicitudDet a WHERE a.descripcion = :descripcion"),
    @NamedQuery(name = "ActivoSolicitudDet.findByUnidadMedida", query = "SELECT a FROM ActivoSolicitudDet a WHERE a.unidadMedida = :unidadMedida"),
    @NamedQuery(name = "ActivoSolicitudDet.findByUsuario", query = "SELECT a FROM ActivoSolicitudDet a WHERE a.usuario = :usuario"),
    @NamedQuery(name = "ActivoSolicitudDet.findByFecha", query = "SELECT a FROM ActivoSolicitudDet a WHERE a.fecha = :fecha")})
public class ActivoSolicitudDet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idactivo_solicitud_det")
    private Integer idactivoSolicitudDet;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "unidad_medida")
    private String unidadMedida;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "activoSolicitudDetIdactivoSolicitudDet")
    private Collection<ActivoSolicitud> activoSolicitudCollection;

    public ActivoSolicitudDet() {
    }

    public ActivoSolicitudDet(Integer idactivoSolicitudDet) {
        this.idactivoSolicitudDet = idactivoSolicitudDet;
    }

    public Integer getIdactivoSolicitudDet() {
        return idactivoSolicitudDet;
    }

    public void setIdactivoSolicitudDet(Integer idactivoSolicitudDet) {
        this.idactivoSolicitudDet = idactivoSolicitudDet;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
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
    public Collection<ActivoSolicitud> getActivoSolicitudCollection() {
        return activoSolicitudCollection;
    }

    public void setActivoSolicitudCollection(Collection<ActivoSolicitud> activoSolicitudCollection) {
        this.activoSolicitudCollection = activoSolicitudCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idactivoSolicitudDet != null ? idactivoSolicitudDet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActivoSolicitudDet)) {
            return false;
        }
        ActivoSolicitudDet other = (ActivoSolicitudDet) object;
        if ((this.idactivoSolicitudDet == null && other.idactivoSolicitudDet != null) || (this.idactivoSolicitudDet != null && !this.idactivoSolicitudDet.equals(other.idactivoSolicitudDet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.orm.activosorm.ActivoSolicitudDet[ idactivoSolicitudDet=" + idactivoSolicitudDet + " ]";
    }
    
}
