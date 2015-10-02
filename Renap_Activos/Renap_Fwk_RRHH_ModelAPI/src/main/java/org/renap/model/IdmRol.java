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
import javax.persistence.ManyToMany;
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
@Table(name = "IDM_ROL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IdmRol.findAll", query = "SELECT i FROM IdmRol i"),
    @NamedQuery(name = "IdmRol.findById", query = "SELECT i FROM IdmRol i WHERE i.id = :id"),
    @NamedQuery(name = "IdmRol.findByNombre", query = "SELECT i FROM IdmRol i WHERE i.nombre = :nombre"),
    @NamedQuery(name = "IdmRol.findByEstado", query = "SELECT i FROM IdmRol i WHERE i.estado = :estado")})
public class IdmRol implements Serializable {
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ESTADO")
    private String estado;
    @ManyToMany(mappedBy = "idmRolList", fetch = FetchType.EAGER)
    private List<IdmAplicacion> idmAplicacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmRol", fetch = FetchType.EAGER)
    private List<IdmRolFuncion> idmRolFuncionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRol", fetch = FetchType.EAGER)
    private List<IdmPuestoRol> idmPuestoRolList;

    public IdmRol() {
    }

    public IdmRol(Long id) {
        this.id = id;
    }

    public IdmRol(Long id, String nombre, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<IdmAplicacion> getIdmAplicacionList() {
        return idmAplicacionList;
    }

    public void setIdmAplicacionList(List<IdmAplicacion> idmAplicacionList) {
        this.idmAplicacionList = idmAplicacionList;
    }

    @XmlTransient
    public List<IdmRolFuncion> getIdmRolFuncionList() {
        return idmRolFuncionList;
    }

    public void setIdmRolFuncionList(List<IdmRolFuncion> idmRolFuncionList) {
        this.idmRolFuncionList = idmRolFuncionList;
    }

    @XmlTransient
    public List<IdmPuestoRol> getIdmPuestoRolList() {
        return idmPuestoRolList;
    }

    public void setIdmPuestoRolList(List<IdmPuestoRol> idmPuestoRolList) {
        this.idmPuestoRolList = idmPuestoRolList;
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
        if (!(object instanceof IdmRol)) {
            return false;
        }
        IdmRol other = (IdmRol) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.model.IdmRol[ id=" + id + " ]";
    }
    
}
