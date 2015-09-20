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
@Table(name = "tir_uso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TirUso.findAll", query = "SELECT t FROM TirUso t"),
    @NamedQuery(name = "TirUso.findByIdtirUso", query = "SELECT t FROM TirUso t WHERE t.idtirUso = :idtirUso"),
    @NamedQuery(name = "TirUso.findByUsoTir", query = "SELECT t FROM TirUso t WHERE t.usoTir = :usoTir"),
    @NamedQuery(name = "TirUso.findByUsuario", query = "SELECT t FROM TirUso t WHERE t.usuario = :usuario"),
    @NamedQuery(name = "TirUso.findByFecha", query = "SELECT t FROM TirUso t WHERE t.fecha = :fecha")})
public class TirUso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtir_uso")
    private Integer idtirUso;
    @Column(name = "uso_tir")
    private String usoTir;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tirUsoIdtirUso")
    private Collection<Tir> tirCollection;

    public TirUso() {
    }

    public TirUso(Integer idtirUso) {
        this.idtirUso = idtirUso;
    }

    public Integer getIdtirUso() {
        return idtirUso;
    }

    public void setIdtirUso(Integer idtirUso) {
        this.idtirUso = idtirUso;
    }

    public String getUsoTir() {
        return usoTir;
    }

    public void setUsoTir(String usoTir) {
        this.usoTir = usoTir;
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
        hash += (idtirUso != null ? idtirUso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TirUso)) {
            return false;
        }
        TirUso other = (TirUso) object;
        if ((this.idtirUso == null && other.idtirUso != null) || (this.idtirUso != null && !this.idtirUso.equals(other.idtirUso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.orm.activosorm.TirUso[ idtirUso=" + idtirUso + " ]";
    }
    
}
