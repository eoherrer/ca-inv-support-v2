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
@Table(name = "activo_encabezado_doc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActivoEncabezadoDoc.findAll", query = "SELECT a FROM ActivoEncabezadoDoc a"),
    @NamedQuery(name = "ActivoEncabezadoDoc.findByIdactivoEncabezadoDoc", query = "SELECT a FROM ActivoEncabezadoDoc a WHERE a.idactivoEncabezadoDoc = :idactivoEncabezadoDoc"),
    @NamedQuery(name = "ActivoEncabezadoDoc.findByFechaRecibido", query = "SELECT a FROM ActivoEncabezadoDoc a WHERE a.fechaRecibido = :fechaRecibido"),
    @NamedQuery(name = "ActivoEncabezadoDoc.findByTipoDoc", query = "SELECT a FROM ActivoEncabezadoDoc a WHERE a.tipoDoc = :tipoDoc"),
    @NamedQuery(name = "ActivoEncabezadoDoc.findByAnoDoc", query = "SELECT a FROM ActivoEncabezadoDoc a WHERE a.anoDoc = :anoDoc"),
    @NamedQuery(name = "ActivoEncabezadoDoc.findByNoDoc", query = "SELECT a FROM ActivoEncabezadoDoc a WHERE a.noDoc = :noDoc"),
    @NamedQuery(name = "ActivoEncabezadoDoc.findByIdReceptor", query = "SELECT a FROM ActivoEncabezadoDoc a WHERE a.idReceptor = :idReceptor"),
    @NamedQuery(name = "ActivoEncabezadoDoc.findByFechaDoc", query = "SELECT a FROM ActivoEncabezadoDoc a WHERE a.fechaDoc = :fechaDoc"),
    @NamedQuery(name = "ActivoEncabezadoDoc.findByCuiEntrega", query = "SELECT a FROM ActivoEncabezadoDoc a WHERE a.cuiEntrega = :cuiEntrega"),
    @NamedQuery(name = "ActivoEncabezadoDoc.findByIdEmpleadoEntrega", query = "SELECT a FROM ActivoEncabezadoDoc a WHERE a.idEmpleadoEntrega = :idEmpleadoEntrega"),
    @NamedQuery(name = "ActivoEncabezadoDoc.findByIdDependencia", query = "SELECT a FROM ActivoEncabezadoDoc a WHERE a.idDependencia = :idDependencia"),
    @NamedQuery(name = "ActivoEncabezadoDoc.findByUsuario", query = "SELECT a FROM ActivoEncabezadoDoc a WHERE a.usuario = :usuario"),
    @NamedQuery(name = "ActivoEncabezadoDoc.findByFecha", query = "SELECT a FROM ActivoEncabezadoDoc a WHERE a.fecha = :fecha")})
public class ActivoEncabezadoDoc implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idactivo_encabezado_doc")
    private Integer idactivoEncabezadoDoc;
    @Column(name = "fecha_recibido")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRecibido;
    @Column(name = "tipo_doc")
    private String tipoDoc;
    @Column(name = "ano_doc")
    private String anoDoc;
    @Column(name = "no_doc")
    private String noDoc;
    @Column(name = "id_receptor")
    private Integer idReceptor;
    @Column(name = "fecha_doc")
    @Temporal(TemporalType.DATE)
    private Date fechaDoc;
    @Column(name = "cui_entrega")
    private String cuiEntrega;
    @Column(name = "id_empleado_entrega")
    private Integer idEmpleadoEntrega;
    @Column(name = "id_dependencia")
    private Integer idDependencia;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    public ActivoEncabezadoDoc() {
    }

    public ActivoEncabezadoDoc(Integer idactivoEncabezadoDoc) {
        this.idactivoEncabezadoDoc = idactivoEncabezadoDoc;
    }

    public Integer getIdactivoEncabezadoDoc() {
        return idactivoEncabezadoDoc;
    }

    public void setIdactivoEncabezadoDoc(Integer idactivoEncabezadoDoc) {
        this.idactivoEncabezadoDoc = idactivoEncabezadoDoc;
    }

    public Date getFechaRecibido() {
        return fechaRecibido;
    }

    public void setFechaRecibido(Date fechaRecibido) {
        this.fechaRecibido = fechaRecibido;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getAnoDoc() {
        return anoDoc;
    }

    public void setAnoDoc(String anoDoc) {
        this.anoDoc = anoDoc;
    }

    public String getNoDoc() {
        return noDoc;
    }

    public void setNoDoc(String noDoc) {
        this.noDoc = noDoc;
    }

    public Integer getIdReceptor() {
        return idReceptor;
    }

    public void setIdReceptor(Integer idReceptor) {
        this.idReceptor = idReceptor;
    }

    public Date getFechaDoc() {
        return fechaDoc;
    }

    public void setFechaDoc(Date fechaDoc) {
        this.fechaDoc = fechaDoc;
    }

    public String getCuiEntrega() {
        return cuiEntrega;
    }

    public void setCuiEntrega(String cuiEntrega) {
        this.cuiEntrega = cuiEntrega;
    }

    public Integer getIdEmpleadoEntrega() {
        return idEmpleadoEntrega;
    }

    public void setIdEmpleadoEntrega(Integer idEmpleadoEntrega) {
        this.idEmpleadoEntrega = idEmpleadoEntrega;
    }

    public Integer getIdDependencia() {
        return idDependencia;
    }

    public void setIdDependencia(Integer idDependencia) {
        this.idDependencia = idDependencia;
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
        hash += (idactivoEncabezadoDoc != null ? idactivoEncabezadoDoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActivoEncabezadoDoc)) {
            return false;
        }
        ActivoEncabezadoDoc other = (ActivoEncabezadoDoc) object;
        if ((this.idactivoEncabezadoDoc == null && other.idactivoEncabezadoDoc != null) || (this.idactivoEncabezadoDoc != null && !this.idactivoEncabezadoDoc.equals(other.idactivoEncabezadoDoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.orm.activosorm.ActivoEncabezadoDoc[ idactivoEncabezadoDoc=" + idactivoEncabezadoDoc + " ]";
    }
    
}
