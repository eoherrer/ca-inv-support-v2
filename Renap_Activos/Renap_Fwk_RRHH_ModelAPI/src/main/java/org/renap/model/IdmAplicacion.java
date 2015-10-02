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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "IDM_APLICACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IdmAplicacion.findAll", query = "SELECT i FROM IdmAplicacion i"),
    @NamedQuery(name = "IdmAplicacion.findById", query = "SELECT i FROM IdmAplicacion i WHERE i.id = :id"),
    @NamedQuery(name = "IdmAplicacion.findByNombre", query = "SELECT i FROM IdmAplicacion i WHERE i.nombre = :nombre"),
    @NamedQuery(name = "IdmAplicacion.findByUbicacion", query = "SELECT i FROM IdmAplicacion i WHERE i.ubicacion = :ubicacion"),
    @NamedQuery(name = "IdmAplicacion.findByImagen", query = "SELECT i FROM IdmAplicacion i WHERE i.imagen = :imagen"),
    @NamedQuery(name = "IdmAplicacion.findByEstado", query = "SELECT i FROM IdmAplicacion i WHERE i.estado = :estado"),
    @NamedQuery(name = "IdmAplicacion.findByFechaIng", query = "SELECT i FROM IdmAplicacion i WHERE i.fechaIng = :fechaIng"),
    @NamedQuery(name = "IdmAplicacion.findByUsuarioIng", query = "SELECT i FROM IdmAplicacion i WHERE i.usuarioIng = :usuarioIng")})
public class IdmAplicacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 200)
    @Column(name = "UBICACION")
    private String ubicacion;
    @Size(max = 200)
    @Column(name = "IMAGEN")
    private String imagen;
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
    @JoinTable(name = "IDM_ROL_APLICACION", joinColumns = {
        @JoinColumn(name = "ID_APLICACION", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_ROL", referencedColumnName = "ID")})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<IdmRol> idmRolList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmAplicacion", fetch = FetchType.EAGER)
    private List<IdmAplicacionFuncion> idmAplicacionFuncionList;

    public IdmAplicacion() {
    }

    public IdmAplicacion(Long id) {
        this.id = id;
    }

    public IdmAplicacion(Long id, String nombre, String estado, Date fechaIng) {
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

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
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
    public List<IdmRol> getIdmRolList() {
        return idmRolList;
    }

    public void setIdmRolList(List<IdmRol> idmRolList) {
        this.idmRolList = idmRolList;
    }

    @XmlTransient
    public List<IdmAplicacionFuncion> getIdmAplicacionFuncionList() {
        return idmAplicacionFuncionList;
    }

    public void setIdmAplicacionFuncionList(List<IdmAplicacionFuncion> idmAplicacionFuncionList) {
        this.idmAplicacionFuncionList = idmAplicacionFuncionList;
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
        if (!(object instanceof IdmAplicacion)) {
            return false;
        }
        IdmAplicacion other = (IdmAplicacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.model.IdmAplicacion[ id=" + id + " ]";
    }
    
}
