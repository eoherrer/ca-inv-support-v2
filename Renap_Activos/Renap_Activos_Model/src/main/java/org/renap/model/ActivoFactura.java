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
@Table(name = "activo_factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActivoFactura.findAll", query = "SELECT a FROM ActivoFactura a"),
    @NamedQuery(name = "ActivoFactura.findByIdactivoFactura", query = "SELECT a FROM ActivoFactura a WHERE a.idactivoFactura = :idactivoFactura"),
    @NamedQuery(name = "ActivoFactura.findByFechaDoc", query = "SELECT a FROM ActivoFactura a WHERE a.fechaDoc = :fechaDoc"),
    @NamedQuery(name = "ActivoFactura.findBySerieDoc", query = "SELECT a FROM ActivoFactura a WHERE a.serieDoc = :serieDoc"),
    @NamedQuery(name = "ActivoFactura.findByNumeroDoc", query = "SELECT a FROM ActivoFactura a WHERE a.numeroDoc = :numeroDoc"),
    @NamedQuery(name = "ActivoFactura.findByNitProveedor", query = "SELECT a FROM ActivoFactura a WHERE a.nitProveedor = :nitProveedor"),
    @NamedQuery(name = "ActivoFactura.findByIdProveedor", query = "SELECT a FROM ActivoFactura a WHERE a.idProveedor = :idProveedor"),
    @NamedQuery(name = "ActivoFactura.findByUsuario", query = "SELECT a FROM ActivoFactura a WHERE a.usuario = :usuario"),
    @NamedQuery(name = "ActivoFactura.findByFecha", query = "SELECT a FROM ActivoFactura a WHERE a.fecha = :fecha")})
public class ActivoFactura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idactivo_factura")
    private Integer idactivoFactura;
    @Column(name = "fecha_doc")
    @Temporal(TemporalType.DATE)
    private Date fechaDoc;
    @Column(name = "serie_doc")
    private String serieDoc;
    @Column(name = "numero_doc")
    private String numeroDoc;
    @Column(name = "nit_proveedor")
    private String nitProveedor;
    @Column(name = "id_proveedor")
    private Integer idProveedor;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "formas1H_idformas1H", referencedColumnName = "idformas1H")
    @ManyToOne(optional = false)
    private Formas1h formas1Hidformas1H;
    @JoinColumn(name = "libro_idlibro", referencedColumnName = "idlibro")
    @ManyToOne(optional = false)
    private Libro libroIdlibro;
    @JoinColumn(name = "proveedor_idproveedor", referencedColumnName = "idproveedor")
    @ManyToOne(optional = false)
    private Proveedor proveedorIdproveedor;

    public ActivoFactura() {
    }

    public ActivoFactura(Integer idactivoFactura) {
        this.idactivoFactura = idactivoFactura;
    }

    public Integer getIdactivoFactura() {
        return idactivoFactura;
    }

    public void setIdactivoFactura(Integer idactivoFactura) {
        this.idactivoFactura = idactivoFactura;
    }

    public Date getFechaDoc() {
        return fechaDoc;
    }

    public void setFechaDoc(Date fechaDoc) {
        this.fechaDoc = fechaDoc;
    }

    public String getSerieDoc() {
        return serieDoc;
    }

    public void setSerieDoc(String serieDoc) {
        this.serieDoc = serieDoc;
    }

    public String getNumeroDoc() {
        return numeroDoc;
    }

    public void setNumeroDoc(String numeroDoc) {
        this.numeroDoc = numeroDoc;
    }

    public String getNitProveedor() {
        return nitProveedor;
    }

    public void setNitProveedor(String nitProveedor) {
        this.nitProveedor = nitProveedor;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
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

    public Formas1h getFormas1Hidformas1H() {
        return formas1Hidformas1H;
    }

    public void setFormas1Hidformas1H(Formas1h formas1Hidformas1H) {
        this.formas1Hidformas1H = formas1Hidformas1H;
    }

    public Libro getLibroIdlibro() {
        return libroIdlibro;
    }

    public void setLibroIdlibro(Libro libroIdlibro) {
        this.libroIdlibro = libroIdlibro;
    }

    public Proveedor getProveedorIdproveedor() {
        return proveedorIdproveedor;
    }

    public void setProveedorIdproveedor(Proveedor proveedorIdproveedor) {
        this.proveedorIdproveedor = proveedorIdproveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idactivoFactura != null ? idactivoFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActivoFactura)) {
            return false;
        }
        ActivoFactura other = (ActivoFactura) object;
        if ((this.idactivoFactura == null && other.idactivoFactura != null) || (this.idactivoFactura != null && !this.idactivoFactura.equals(other.idactivoFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.orm.activosorm.ActivoFactura[ idactivoFactura=" + idactivoFactura + " ]";
    }
    
}
