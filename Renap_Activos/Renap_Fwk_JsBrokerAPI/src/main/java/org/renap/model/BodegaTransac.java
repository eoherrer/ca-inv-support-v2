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
@Table(name = "bodega_transac")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BodegaTransac.findAll", query = "SELECT b FROM BodegaTransac b"),
    @NamedQuery(name = "BodegaTransac.findByIdbodegaTransac", query = "SELECT b FROM BodegaTransac b WHERE b.idbodegaTransac = :idbodegaTransac"),
    @NamedQuery(name = "BodegaTransac.findByIdProducto", query = "SELECT b FROM BodegaTransac b WHERE b.idProducto = :idProducto"),
    @NamedQuery(name = "BodegaTransac.findByTipoTransac", query = "SELECT b FROM BodegaTransac b WHERE b.tipoTransac = :tipoTransac"),
    @NamedQuery(name = "BodegaTransac.findByCreatedDate", query = "SELECT b FROM BodegaTransac b WHERE b.createdDate = :createdDate"),
    @NamedQuery(name = "BodegaTransac.findByIdResponsable", query = "SELECT b FROM BodegaTransac b WHERE b.idResponsable = :idResponsable")})
public class BodegaTransac implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idbodega_transac")
    private Long idbodegaTransac;
    @Column(name = "id_producto")
    private String idProducto;
    @Column(name = "tipo_transac")
    private String tipoTransac;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "id_responsable")
    private String idResponsable;
    @JoinColumn(name = "bodega_idbodega", referencedColumnName = "idbodega")
    @ManyToOne(optional = false)
    private Bodega bodegaIdbodega;
    @JoinColumn(name = "empleado_idempleado", referencedColumnName = "idempleado")
    @ManyToOne(optional = false)
    private Empleado empleadoIdempleado;

    public BodegaTransac() {
    }

    public BodegaTransac(Long idbodegaTransac) {
        this.idbodegaTransac = idbodegaTransac;
    }

    public Long getIdbodegaTransac() {
        return idbodegaTransac;
    }

    public void setIdbodegaTransac(Long idbodegaTransac) {
        this.idbodegaTransac = idbodegaTransac;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getTipoTransac() {
        return tipoTransac;
    }

    public void setTipoTransac(String tipoTransac) {
        this.tipoTransac = tipoTransac;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getIdResponsable() {
        return idResponsable;
    }

    public void setIdResponsable(String idResponsable) {
        this.idResponsable = idResponsable;
    }

    public Bodega getBodegaIdbodega() {
        return bodegaIdbodega;
    }

    public void setBodegaIdbodega(Bodega bodegaIdbodega) {
        this.bodegaIdbodega = bodegaIdbodega;
    }

    public Empleado getEmpleadoIdempleado() {
        return empleadoIdempleado;
    }

    public void setEmpleadoIdempleado(Empleado empleadoIdempleado) {
        this.empleadoIdempleado = empleadoIdempleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbodegaTransac != null ? idbodegaTransac.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BodegaTransac)) {
            return false;
        }
        BodegaTransac other = (BodegaTransac) object;
        if ((this.idbodegaTransac == null && other.idbodegaTransac != null) || (this.idbodegaTransac != null && !this.idbodegaTransac.equals(other.idbodegaTransac))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.orm.activosorm.BodegaTransac[ idbodegaTransac=" + idbodegaTransac + " ]";
    }
    
}
