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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 2703759290608
 */
@Entity
@Table(name = "IDM_TIPO_UNIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IdmTipoUnidad.findAll", query = "SELECT i FROM IdmTipoUnidad i"),
    @NamedQuery(name = "IdmTipoUnidad.findById", query = "SELECT i FROM IdmTipoUnidad i WHERE i.id = :id"),
    @NamedQuery(name = "IdmTipoUnidad.findByNombre", query = "SELECT i FROM IdmTipoUnidad i WHERE i.nombre = :nombre"),
    @NamedQuery(name = "IdmTipoUnidad.findByDescripcion", query = "SELECT i FROM IdmTipoUnidad i WHERE i.descripcion = :descripcion"),
    @NamedQuery(name = "IdmTipoUnidad.findByEstado", query = "SELECT i FROM IdmTipoUnidad i WHERE i.estado = :estado"),
    @NamedQuery(name = "IdmTipoUnidad.findByFechaIng", query = "SELECT i FROM IdmTipoUnidad i WHERE i.fechaIng = :fechaIng"),
    @NamedQuery(name = "IdmTipoUnidad.findByUsuarioIng", query = "SELECT i FROM IdmTipoUnidad i WHERE i.usuarioIng = :usuarioIng")})
public class IdmTipoUnidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 100)
    @Column(name = "DESCRIPCION")
    private String descripcion;
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

    public IdmTipoUnidad() {
    }

    public IdmTipoUnidad(Long id) {
        this.id = id;
    }

    public IdmTipoUnidad(Long id, String nombre, String estado, Date fechaIng) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.fechaIng = fechaIng;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IdmTipoUnidad)) {
            return false;
        }
        IdmTipoUnidad other = (IdmTipoUnidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.model.IdmTipoUnidad[ id=" + id + " ]";
    }
    
}
