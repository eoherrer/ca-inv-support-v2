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
@Table(name = "activo_orden_compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActivoOrdenCompra.findAll", query = "SELECT a FROM ActivoOrdenCompra a"),
    @NamedQuery(name = "ActivoOrdenCompra.findByIdactivoOrdenCompra", query = "SELECT a FROM ActivoOrdenCompra a WHERE a.idactivoOrdenCompra = :idactivoOrdenCompra"),
    @NamedQuery(name = "ActivoOrdenCompra.findByIdForma1h", query = "SELECT a FROM ActivoOrdenCompra a WHERE a.idForma1h = :idForma1h"),
    @NamedQuery(name = "ActivoOrdenCompra.findByIdProveedor", query = "SELECT a FROM ActivoOrdenCompra a WHERE a.idProveedor = :idProveedor"),
    @NamedQuery(name = "ActivoOrdenCompra.findByFechaSolicitud", query = "SELECT a FROM ActivoOrdenCompra a WHERE a.fechaSolicitud = :fechaSolicitud"),
    @NamedQuery(name = "ActivoOrdenCompra.findByUsuario", query = "SELECT a FROM ActivoOrdenCompra a WHERE a.usuario = :usuario"),
    @NamedQuery(name = "ActivoOrdenCompra.findByFecha", query = "SELECT a FROM ActivoOrdenCompra a WHERE a.fecha = :fecha")})
public class ActivoOrdenCompra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idactivo_orden_compra")
    private Integer idactivoOrdenCompra;
    @Column(name = "id_forma1h")
    private Integer idForma1h;
    @Column(name = "id_proveedor")
    private String idProveedor;
    @Column(name = "fecha_solicitud")
    @Temporal(TemporalType.DATE)
    private Date fechaSolicitud;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "fecha")
    private String fecha;

    public ActivoOrdenCompra() {
    }

    public ActivoOrdenCompra(Integer idactivoOrdenCompra) {
        this.idactivoOrdenCompra = idactivoOrdenCompra;
    }

    public Integer getIdactivoOrdenCompra() {
        return idactivoOrdenCompra;
    }

    public void setIdactivoOrdenCompra(Integer idactivoOrdenCompra) {
        this.idactivoOrdenCompra = idactivoOrdenCompra;
    }

    public Integer getIdForma1h() {
        return idForma1h;
    }

    public void setIdForma1h(Integer idForma1h) {
        this.idForma1h = idForma1h;
    }

    public String getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(String idProveedor) {
        this.idProveedor = idProveedor;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idactivoOrdenCompra != null ? idactivoOrdenCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActivoOrdenCompra)) {
            return false;
        }
        ActivoOrdenCompra other = (ActivoOrdenCompra) object;
        if ((this.idactivoOrdenCompra == null && other.idactivoOrdenCompra != null) || (this.idactivoOrdenCompra != null && !this.idactivoOrdenCompra.equals(other.idactivoOrdenCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.orm.activosorm.ActivoOrdenCompra[ idactivoOrdenCompra=" + idactivoOrdenCompra + " ]";
    }
    
}
