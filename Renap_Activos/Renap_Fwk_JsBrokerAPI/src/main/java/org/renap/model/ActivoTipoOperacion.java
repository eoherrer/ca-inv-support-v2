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
@Table(name = "activo_tipo_operacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActivoTipoOperacion.findAll", query = "SELECT a FROM ActivoTipoOperacion a"),
    @NamedQuery(name = "ActivoTipoOperacion.findByIdactivoTipoOperacion", query = "SELECT a FROM ActivoTipoOperacion a WHERE a.idactivoTipoOperacion = :idactivoTipoOperacion"),
    @NamedQuery(name = "ActivoTipoOperacion.findByOperacion", query = "SELECT a FROM ActivoTipoOperacion a WHERE a.operacion = :operacion"),
    @NamedQuery(name = "ActivoTipoOperacion.findByUsuario", query = "SELECT a FROM ActivoTipoOperacion a WHERE a.usuario = :usuario"),
    @NamedQuery(name = "ActivoTipoOperacion.findByFecha", query = "SELECT a FROM ActivoTipoOperacion a WHERE a.fecha = :fecha")})
public class ActivoTipoOperacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idactivo_tipo_operacion")
    private Integer idactivoTipoOperacion;
    @Column(name = "operacion")
    private String operacion;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "activoTipoOperacionIdactivoTipoOperacion")
    private Collection<ActivoTransac> activoTransacCollection;

    public ActivoTipoOperacion() {
    }

    public ActivoTipoOperacion(Integer idactivoTipoOperacion) {
        this.idactivoTipoOperacion = idactivoTipoOperacion;
    }

    public Integer getIdactivoTipoOperacion() {
        return idactivoTipoOperacion;
    }

    public void setIdactivoTipoOperacion(Integer idactivoTipoOperacion) {
        this.idactivoTipoOperacion = idactivoTipoOperacion;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
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
    public Collection<ActivoTransac> getActivoTransacCollection() {
        return activoTransacCollection;
    }

    public void setActivoTransacCollection(Collection<ActivoTransac> activoTransacCollection) {
        this.activoTransacCollection = activoTransacCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idactivoTipoOperacion != null ? idactivoTipoOperacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActivoTipoOperacion)) {
            return false;
        }
        ActivoTipoOperacion other = (ActivoTipoOperacion) object;
        if ((this.idactivoTipoOperacion == null && other.idactivoTipoOperacion != null) || (this.idactivoTipoOperacion != null && !this.idactivoTipoOperacion.equals(other.idactivoTipoOperacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.orm.activosorm.ActivoTipoOperacion[ idactivoTipoOperacion=" + idactivoTipoOperacion + " ]";
    }
    
}
