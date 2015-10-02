/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.renap.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "IDM_TAREA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IdmTarea.findAll", query = "SELECT i FROM IdmTarea i"),
    @NamedQuery(name = "IdmTarea.findById", query = "SELECT i FROM IdmTarea i WHERE i.id = :id"),
    @NamedQuery(name = "IdmTarea.findByNombreTarea", query = "SELECT i FROM IdmTarea i WHERE i.nombreTarea = :nombreTarea"),
    @NamedQuery(name = "IdmTarea.findByDescripcion", query = "SELECT i FROM IdmTarea i WHERE i.descripcion = :descripcion"),
    @NamedQuery(name = "IdmTarea.findByEstado", query = "SELECT i FROM IdmTarea i WHERE i.estado = :estado")})
public class IdmTarea implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE_TAREA")
    private String nombreTarea;
    @Size(max = 300)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ESTADO")
    private String estado;
    @OneToMany(mappedBy = "idTarea", fetch = FetchType.EAGER)
    private List<IdmCaracteristicas> idmCaracteristicasList;

    public IdmTarea() {
    }

    public IdmTarea(Integer id) {
        this.id = id;
    }

    public IdmTarea(Integer id, String nombreTarea, String estado) {
        this.id = id;
        this.nombreTarea = nombreTarea;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreTarea() {
        return nombreTarea;
    }

    public void setNombreTarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
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
    public List<IdmCaracteristicas> getIdmCaracteristicasList() {
        return idmCaracteristicasList;
    }

    public void setIdmCaracteristicasList(List<IdmCaracteristicas> idmCaracteristicasList) {
        this.idmCaracteristicasList = idmCaracteristicasList;
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
        if (!(object instanceof IdmTarea)) {
            return false;
        }
        IdmTarea other = (IdmTarea) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.model.IdmTarea[ id=" + id + " ]";
    }
    
}
