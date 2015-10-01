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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "activo_solicitud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActivoSolicitud.findAll", query = "SELECT a FROM ActivoSolicitud a"),
    @NamedQuery(name = "ActivoSolicitud.findByIdsolicitudActivo", query = "SELECT a FROM ActivoSolicitud a WHERE a.idsolicitudActivo = :idsolicitudActivo"),
    @NamedQuery(name = "ActivoSolicitud.findByNumero", query = "SELECT a FROM ActivoSolicitud a WHERE a.numero = :numero"),
    @NamedQuery(name = "ActivoSolicitud.findByFechaSolicitud", query = "SELECT a FROM ActivoSolicitud a WHERE a.fechaSolicitud = :fechaSolicitud"),
    @NamedQuery(name = "ActivoSolicitud.findByJustificacion", query = "SELECT a FROM ActivoSolicitud a WHERE a.justificacion = :justificacion"),
    @NamedQuery(name = "ActivoSolicitud.findByEstado", query = "SELECT a FROM ActivoSolicitud a WHERE a.estado = :estado"),
    @NamedQuery(name = "ActivoSolicitud.findByUsuario", query = "SELECT a FROM ActivoSolicitud a WHERE a.usuario = :usuario"),
    @NamedQuery(name = "ActivoSolicitud.findByFecha", query = "SELECT a FROM ActivoSolicitud a WHERE a.fecha = :fecha")})
public class ActivoSolicitud implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsolicitud_activo")
    private Integer idsolicitudActivo;
    @Column(name = "numero")
    private Integer numero;
    @Column(name = "fecha_solicitud")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSolicitud;
    @Column(name = "justificacion")
    private String justificacion;
    @Column(name = "estado")
    private Character estado;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "activo_solicitud_det_idactivo_solicitud_det", referencedColumnName = "idactivo_solicitud_det")
    @ManyToOne(optional = false)
    private ActivoSolicitudDet activoSolicitudDetIdactivoSolicitudDet;
    @JoinColumn(name = "empleado_idempleado", referencedColumnName = "idempleado")
    @ManyToOne(optional = false)
    private Empleado empleadoIdempleado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "activoSolicitudIdsolicitudActivo")
    private Collection<SolicitudCompra> solicitudCompraCollection;

    public ActivoSolicitud() {
    }

    public ActivoSolicitud(Integer idsolicitudActivo) {
        this.idsolicitudActivo = idsolicitudActivo;
    }

    public Integer getIdsolicitudActivo() {
        return idsolicitudActivo;
    }

    public void setIdsolicitudActivo(Integer idsolicitudActivo) {
        this.idsolicitudActivo = idsolicitudActivo;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
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

    public ActivoSolicitudDet getActivoSolicitudDetIdactivoSolicitudDet() {
        return activoSolicitudDetIdactivoSolicitudDet;
    }

    public void setActivoSolicitudDetIdactivoSolicitudDet(ActivoSolicitudDet activoSolicitudDetIdactivoSolicitudDet) {
        this.activoSolicitudDetIdactivoSolicitudDet = activoSolicitudDetIdactivoSolicitudDet;
    }

    public Empleado getEmpleadoIdempleado() {
        return empleadoIdempleado;
    }

    public void setEmpleadoIdempleado(Empleado empleadoIdempleado) {
        this.empleadoIdempleado = empleadoIdempleado;
    }

    @XmlTransient
    public Collection<SolicitudCompra> getSolicitudCompraCollection() {
        return solicitudCompraCollection;
    }

    public void setSolicitudCompraCollection(Collection<SolicitudCompra> solicitudCompraCollection) {
        this.solicitudCompraCollection = solicitudCompraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsolicitudActivo != null ? idsolicitudActivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActivoSolicitud)) {
            return false;
        }
        ActivoSolicitud other = (ActivoSolicitud) object;
        if ((this.idsolicitudActivo == null && other.idsolicitudActivo != null) || (this.idsolicitudActivo != null && !this.idsolicitudActivo.equals(other.idsolicitudActivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.orm.activosorm.ActivoSolicitud[ idsolicitudActivo=" + idsolicitudActivo + " ]";
    }
    
}
