/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.renap.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 2703759290608
 */
@Entity
@Table(name = "IDM_ACCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IdmAccion.findAll", query = "SELECT i FROM IdmAccion i"),
    @NamedQuery(name = "IdmAccion.findById", query = "SELECT i FROM IdmAccion i WHERE i.id = :id"),
    @NamedQuery(name = "IdmAccion.findByNombreAccion", query = "SELECT i FROM IdmAccion i WHERE i.nombreAccion = :nombreAccion"),
    @NamedQuery(name = "IdmAccion.findByDescripcion", query = "SELECT i FROM IdmAccion i WHERE i.descripcion = :descripcion"),
    @NamedQuery(name = "IdmAccion.findByEstado", query = "SELECT i FROM IdmAccion i WHERE i.estado = :estado")})
public class IdmAccion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE_ACCION")
    private String nombreAccion;
    @Size(max = 300)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ESTADO")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAccion", fetch = FetchType.EAGER)
    private List<IdmAccionEmpleado> idmAccionEmpleadoList;

    public IdmAccion() {
    }

    public IdmAccion(Integer id) {
        this.id = id;
    }

    public IdmAccion(Integer id, String nombreAccion, String estado) {
        this.id = id;
        this.nombreAccion = nombreAccion;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreAccion() {
        return nombreAccion;
    }

    public void setNombreAccion(String nombreAccion) {
        this.nombreAccion = nombreAccion;
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

    @XmlTransient
    public List<IdmAccionEmpleado> getIdmAccionEmpleadoList() {
        return idmAccionEmpleadoList;
    }

    public void setIdmAccionEmpleadoList(List<IdmAccionEmpleado> idmAccionEmpleadoList) {
        this.idmAccionEmpleadoList = idmAccionEmpleadoList;
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
        if (!(object instanceof IdmAccion)) {
            return false;
        }
        IdmAccion other = (IdmAccion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.model.IdmAccion[ id=" + id + " ]";
    }
    
}
