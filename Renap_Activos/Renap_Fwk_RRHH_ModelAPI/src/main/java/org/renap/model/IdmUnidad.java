/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.renap.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 2703759290608
 */
@Entity
@Table(name = "IDM_UNIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IdmUnidad.findAll", query = "SELECT i FROM IdmUnidad i"),
    @NamedQuery(name = "IdmUnidad.findById", query = "SELECT i FROM IdmUnidad i WHERE i.id = :id"),
    @NamedQuery(name = "IdmUnidad.findByNombreUnidad", query = "SELECT i FROM IdmUnidad i WHERE i.nombreUnidad = :nombreUnidad"),
    @NamedQuery(name = "IdmUnidad.findByTipoUnidad", query = "SELECT i FROM IdmUnidad i WHERE i.tipoUnidad = :tipoUnidad"),
    @NamedQuery(name = "IdmUnidad.findByEstado", query = "SELECT i FROM IdmUnidad i WHERE i.estado = :estado"),
    @NamedQuery(name = "IdmUnidad.findByFechaIng", query = "SELECT i FROM IdmUnidad i WHERE i.fechaIng = :fechaIng"),
    @NamedQuery(name = "IdmUnidad.findByUsuarioIng", query = "SELECT i FROM IdmUnidad i WHERE i.usuarioIng = :usuarioIng")})
public class IdmUnidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE_UNIDAD")
    private String nombreUnidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPO_UNIDAD")
    private long tipoUnidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ESTADO")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_ING")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIng;
    @Size(max = 15)
    @Column(name = "USUARIO_ING")
    private String usuarioIng;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnidad", fetch = FetchType.EAGER)
    private List<IdmPlaza> idmPlazaList;
    @OneToMany(mappedBy = "unidadPadre", fetch = FetchType.EAGER)
    private List<IdmUnidad> idmUnidadList;
    @JoinColumn(name = "UNIDAD_PADRE", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private IdmUnidad unidadPadre;

    public IdmUnidad() {
    }

    public IdmUnidad(Long id) {
        this.id = id;
    }

    public IdmUnidad(Long id, String nombreUnidad, long tipoUnidad, String estado, Date fechaIng) {
        this.id = id;
        this.nombreUnidad = nombreUnidad;
        this.tipoUnidad = tipoUnidad;
        this.estado = estado;
        this.fechaIng = fechaIng;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreUnidad() {
        return nombreUnidad;
    }

    public void setNombreUnidad(String nombreUnidad) {
        this.nombreUnidad = nombreUnidad;
    }

    public long getTipoUnidad() {
        return tipoUnidad;
    }

    public void setTipoUnidad(long tipoUnidad) {
        this.tipoUnidad = tipoUnidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaIng() {
        return fechaIng;
    }

    public void setFechaIng(Date fechaIng) {
        this.fechaIng = fechaIng;
    }

    public String getUsuarioIng() {
        return usuarioIng;
    }

    public void setUsuarioIng(String usuarioIng) {
        this.usuarioIng = usuarioIng;
    }

    @XmlTransient
    public List<IdmPlaza> getIdmPlazaList() {
        return idmPlazaList;
    }

    public void setIdmPlazaList(List<IdmPlaza> idmPlazaList) {
        this.idmPlazaList = idmPlazaList;
    }

    @XmlTransient
    public List<IdmUnidad> getIdmUnidadList() {
        return idmUnidadList;
    }

    public void setIdmUnidadList(List<IdmUnidad> idmUnidadList) {
        this.idmUnidadList = idmUnidadList;
    }

    public IdmUnidad getUnidadPadre() {
        return unidadPadre;
    }

    public void setUnidadPadre(IdmUnidad unidadPadre) {
        this.unidadPadre = unidadPadre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IdmUnidad)) {
            return false;
        }
        IdmUnidad other = (IdmUnidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.model.IdmUnidad[ id=" + id + " ]";
    }
    
}
