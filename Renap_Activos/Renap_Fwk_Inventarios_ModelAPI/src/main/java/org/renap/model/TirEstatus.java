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
@Table(name = "tir_estatus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TirEstatus.findAll", query = "SELECT t FROM TirEstatus t"),
    @NamedQuery(name = "TirEstatus.findByIdtirEstatus", query = "SELECT t FROM TirEstatus t WHERE t.idtirEstatus = :idtirEstatus"),
    @NamedQuery(name = "TirEstatus.findByDescripcion", query = "SELECT t FROM TirEstatus t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TirEstatus.findByUsuario", query = "SELECT t FROM TirEstatus t WHERE t.usuario = :usuario"),
    @NamedQuery(name = "TirEstatus.findByFecha", query = "SELECT t FROM TirEstatus t WHERE t.fecha = :fecha")})
public class TirEstatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtir_estatus")
    private Integer idtirEstatus;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tirEstatusIdtirEstatus")
    private Collection<Tir> tirCollection;

    public TirEstatus() {
    }

    public TirEstatus(Integer idtirEstatus) {
        this.idtirEstatus = idtirEstatus;
    }

    public Integer getIdtirEstatus() {
        return idtirEstatus;
    }

    public void setIdtirEstatus(Integer idtirEstatus) {
        this.idtirEstatus = idtirEstatus;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        hash += (idtirEstatus != null ? idtirEstatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TirEstatus)) {
            return false;
        }
        TirEstatus other = (TirEstatus) object;
        if ((this.idtirEstatus == null && other.idtirEstatus != null) || (this.idtirEstatus != null && !this.idtirEstatus.equals(other.idtirEstatus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.orm.activosorm.TirEstatus[ idtirEstatus=" + idtirEstatus + " ]";
    }
    
}
