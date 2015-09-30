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
@Table(name = "activo_detalle_doc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActivoDetalleDoc.findAll", query = "SELECT a FROM ActivoDetalleDoc a"),
    @NamedQuery(name = "ActivoDetalleDoc.findByIdactivoDetalleDoc", query = "SELECT a FROM ActivoDetalleDoc a WHERE a.idactivoDetalleDoc = :idactivoDetalleDoc"),
    @NamedQuery(name = "ActivoDetalleDoc.findByFechaOperacion", query = "SELECT a FROM ActivoDetalleDoc a WHERE a.fechaOperacion = :fechaOperacion"),
    @NamedQuery(name = "ActivoDetalleDoc.findByIdTipoDoc", query = "SELECT a FROM ActivoDetalleDoc a WHERE a.idTipoDoc = :idTipoDoc"),
    @NamedQuery(name = "ActivoDetalleDoc.findByNoDoc", query = "SELECT a FROM ActivoDetalleDoc a WHERE a.noDoc = :noDoc"),
    @NamedQuery(name = "ActivoDetalleDoc.findByIdRenap", query = "SELECT a FROM ActivoDetalleDoc a WHERE a.idRenap = :idRenap"),
    @NamedQuery(name = "ActivoDetalleDoc.findByIdOperador", query = "SELECT a FROM ActivoDetalleDoc a WHERE a.idOperador = :idOperador"),
    @NamedQuery(name = "ActivoDetalleDoc.findByUsuario", query = "SELECT a FROM ActivoDetalleDoc a WHERE a.usuario = :usuario"),
    @NamedQuery(name = "ActivoDetalleDoc.findByFecha", query = "SELECT a FROM ActivoDetalleDoc a WHERE a.fecha = :fecha")})
public class ActivoDetalleDoc implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idactivo_detalle_doc")
    private Integer idactivoDetalleDoc;
    @Column(name = "fecha_operacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaOperacion;
    @Column(name = "id_tipo_doc")
    private Integer idTipoDoc;
    @Column(name = "no_doc")
    private String noDoc;
    @Column(name = "id_renap")
    private String idRenap;
    @Column(name = "id_operador")
    private Integer idOperador;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    public ActivoDetalleDoc() {
    }

    public ActivoDetalleDoc(Integer idactivoDetalleDoc) {
        this.idactivoDetalleDoc = idactivoDetalleDoc;
    }

    public Integer getIdactivoDetalleDoc() {
        return idactivoDetalleDoc;
    }

    public void setIdactivoDetalleDoc(Integer idactivoDetalleDoc) {
        this.idactivoDetalleDoc = idactivoDetalleDoc;
    }

    public Date getFechaOperacion() {
        return fechaOperacion;
    }

    public void setFechaOperacion(Date fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }

    public Integer getIdTipoDoc() {
        return idTipoDoc;
    }

    public void setIdTipoDoc(Integer idTipoDoc) {
        this.idTipoDoc = idTipoDoc;
    }

    public String getNoDoc() {
        return noDoc;
    }

    public void setNoDoc(String noDoc) {
        this.noDoc = noDoc;
    }

    public String getIdRenap() {
        return idRenap;
    }

    public void setIdRenap(String idRenap) {
        this.idRenap = idRenap;
    }

    public Integer getIdOperador() {
        return idOperador;
    }

    public void setIdOperador(Integer idOperador) {
        this.idOperador = idOperador;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idactivoDetalleDoc != null ? idactivoDetalleDoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActivoDetalleDoc)) {
            return false;
        }
        ActivoDetalleDoc other = (ActivoDetalleDoc) object;
        if ((this.idactivoDetalleDoc == null && other.idactivoDetalleDoc != null) || (this.idactivoDetalleDoc != null && !this.idactivoDetalleDoc.equals(other.idactivoDetalleDoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.orm.activosorm.ActivoDetalleDoc[ idactivoDetalleDoc=" + idactivoDetalleDoc + " ]";
    }
    
}
