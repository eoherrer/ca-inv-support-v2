/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.renap.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 2703759290608
 */
@Entity
@Table(name = "IDM_PUESTO_ROL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IdmPuestoRol.findAll", query = "SELECT i FROM IdmPuestoRol i"),
    @NamedQuery(name = "IdmPuestoRol.findById", query = "SELECT i FROM IdmPuestoRol i WHERE i.id = :id"),
    @NamedQuery(name = "IdmPuestoRol.findByIdPuesto", query = "SELECT i FROM IdmPuestoRol i WHERE i.idPuesto = :idPuesto"),
    @NamedQuery(name = "IdmPuestoRol.findByEstado", query = "SELECT i FROM IdmPuestoRol i WHERE i.estado = :estado")})
public class IdmPuestoRol implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PUESTO")
    private long idPuesto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "ESTADO")
    private String estado;
    @JoinColumn(name = "ID_ROL", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private IdmRol idRol;

    public IdmPuestoRol() {
    }

    public IdmPuestoRol(Long id) {
        this.id = id;
    }

    public IdmPuestoRol(Long id, long idPuesto, String estado) {
        this.id = id;
        this.idPuesto = idPuesto;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(long idPuesto) {
        this.idPuesto = idPuesto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public IdmRol getIdRol() {
        return idRol;
    }

    public void setIdRol(IdmRol idRol) {
        this.idRol = idRol;
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
        if (!(object instanceof IdmPuestoRol)) {
            return false;
        }
        IdmPuestoRol other = (IdmPuestoRol) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.model.IdmPuestoRol[ id=" + id + " ]";
    }
    
}
