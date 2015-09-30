/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.renap.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 1808236120101
 */
@Entity
@Table(name = "solicitud_compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SolicitudCompra.findAll", query = "SELECT s FROM SolicitudCompra s"),
    @NamedQuery(name = "SolicitudCompra.findByIdsolicitudCompra", query = "SELECT s FROM SolicitudCompra s WHERE s.idsolicitudCompra = :idsolicitudCompra"),
    @NamedQuery(name = "SolicitudCompra.findByNumero", query = "SELECT s FROM SolicitudCompra s WHERE s.numero = :numero"),
    @NamedQuery(name = "SolicitudCompra.findByFechaSolicitud", query = "SELECT s FROM SolicitudCompra s WHERE s.fechaSolicitud = :fechaSolicitud"),
    @NamedQuery(name = "SolicitudCompra.findByUsuario", query = "SELECT s FROM SolicitudCompra s WHERE s.usuario = :usuario"),
    @NamedQuery(name = "SolicitudCompra.findByDescripcion", query = "SELECT s FROM SolicitudCompra s WHERE s.descripcion = :descripcion"),
    @NamedQuery(name = "SolicitudCompra.findByResumen", query = "SELECT s FROM SolicitudCompra s WHERE s.resumen = :resumen"),
    @NamedQuery(name = "SolicitudCompra.findByReferenciaNo", query = "SELECT s FROM SolicitudCompra s WHERE s.referenciaNo = :referenciaNo"),
    @NamedQuery(name = "SolicitudCompra.findByFechaEntrega", query = "SELECT s FROM SolicitudCompra s WHERE s.fechaEntrega = :fechaEntrega"),
    @NamedQuery(name = "SolicitudCompra.findByFecha", query = "SELECT s FROM SolicitudCompra s WHERE s.fecha = :fecha")})
public class SolicitudCompra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsolicitud_compra")
    private Integer idsolicitudCompra;
    @Basic(optional = false)
    @Column(name = "numero")
    private String numero;
    @Column(name = "fecha_solicitud")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSolicitud;
    @Basic(optional = false)
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "resumen")
    private String resumen;
    @Column(name = "referencia_no")
    private String referenciaNo;
    @Column(name = "fecha_entrega")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEntrega;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "activo_solicitud_idsolicitud_activo", referencedColumnName = "idsolicitud_activo")
    @ManyToOne(optional = false)
    private ActivoSolicitud activoSolicitudIdsolicitudActivo;

    public SolicitudCompra() {
    }

    public SolicitudCompra(Integer idsolicitudCompra) {
        this.idsolicitudCompra = idsolicitudCompra;
    }

    public SolicitudCompra(Integer idsolicitudCompra, String numero, String usuario, Date fecha) {
        this.idsolicitudCompra = idsolicitudCompra;
        this.numero = numero;
        this.usuario = usuario;
        this.fecha = fecha;
    }

    public Integer getIdsolicitudCompra() {
        return idsolicitudCompra;
    }

    public void setIdsolicitudCompra(Integer idsolicitudCompra) {
        this.idsolicitudCompra = idsolicitudCompra;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getReferenciaNo() {
        return referenciaNo;
    }

    public void setReferenciaNo(String referenciaNo) {
        this.referenciaNo = referenciaNo;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ActivoSolicitud getActivoSolicitudIdsolicitudActivo() {
        return activoSolicitudIdsolicitudActivo;
    }

    public void setActivoSolicitudIdsolicitudActivo(ActivoSolicitud activoSolicitudIdsolicitudActivo) {
        this.activoSolicitudIdsolicitudActivo = activoSolicitudIdsolicitudActivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsolicitudCompra != null ? idsolicitudCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolicitudCompra)) {
            return false;
        }
        SolicitudCompra other = (SolicitudCompra) object;
        if ((this.idsolicitudCompra == null && other.idsolicitudCompra != null) || (this.idsolicitudCompra != null && !this.idsolicitudCompra.equals(other.idsolicitudCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.orm.activosorm.SolicitudCompra[ idsolicitudCompra=" + idsolicitudCompra + " ]";
    }
    
}
