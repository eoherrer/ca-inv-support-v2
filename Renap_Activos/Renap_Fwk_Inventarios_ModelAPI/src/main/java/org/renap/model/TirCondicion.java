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
@Table(name = "tir_condicion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TirCondicion.findAll", query = "SELECT t FROM TirCondicion t"),
    @NamedQuery(name = "TirCondicion.findByIdtirCondicion", query = "SELECT t FROM TirCondicion t WHERE t.idtirCondicion = :idtirCondicion"),
    @NamedQuery(name = "TirCondicion.findByCondicion", query = "SELECT t FROM TirCondicion t WHERE t.condicion = :condicion"),
    @NamedQuery(name = "TirCondicion.findByUsuario", query = "SELECT t FROM TirCondicion t WHERE t.usuario = :usuario"),
    @NamedQuery(name = "TirCondicion.findByFecha", query = "SELECT t FROM TirCondicion t WHERE t.fecha = :fecha")})
public class TirCondicion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtir_condicion")
    private Integer idtirCondicion;
    @Column(name = "condicion")
    private String condicion;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tirCondicionIdtirCondicion")
    private Collection<Tir> tirCollection;

    public TirCondicion() {
    }

    public TirCondicion(Integer idtirCondicion) {
        this.idtirCondicion = idtirCondicion;
    }

    public Integer getIdtirCondicion() {
        return idtirCondicion;
    }

    public void setIdtirCondicion(Integer idtirCondicion) {
        this.idtirCondicion = idtirCondicion;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
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
    public Collection<Tir> getTirCollection() {
        return tirCollection;
    }

    public void setTirCollection(Collection<Tir> tirCollection) {
        this.tirCollection = tirCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtirCondicion != null ? idtirCondicion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TirCondicion)) {
            return false;
        }
        TirCondicion other = (TirCondicion) object;
        if ((this.idtirCondicion == null && other.idtirCondicion != null) || (this.idtirCondicion != null && !this.idtirCondicion.equals(other.idtirCondicion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.orm.activosorm.TirCondicion[ idtirCondicion=" + idtirCondicion + " ]";
    }
    
}
