/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.renap.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "IDM_CARACTERISTICAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IdmCaracteristicas.findAll", query = "SELECT i FROM IdmCaracteristicas i"),
    @NamedQuery(name = "IdmCaracteristicas.findById", query = "SELECT i FROM IdmCaracteristicas i WHERE i.id = :id"),
    @NamedQuery(name = "IdmCaracteristicas.findByEstado", query = "SELECT i FROM IdmCaracteristicas i WHERE i.estado = :estado")})
public class IdmCaracteristicas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ESTADO")
    private String estado;
    @JoinColumn(name = "ID_PUESTO", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private IdmPuesto idPuesto;
    @JoinColumn(name = "ID_TAREA", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private IdmTarea idTarea;

    public IdmCaracteristicas() {
    }

    public IdmCaracteristicas(Long id) {
        this.id = id;
    }

    public IdmCaracteristicas(Long id, String estado) {
        this.id = id;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @JsonIgnore
    public IdmPuesto getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(IdmPuesto idPuesto) {
        this.idPuesto = idPuesto;
    }

    public IdmTarea getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(IdmTarea idTarea) {
        this.idTarea = idTarea;
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
        if (!(object instanceof IdmCaracteristicas)) {
            return false;
        }
        IdmCaracteristicas other = (IdmCaracteristicas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.model.IdmCaracteristicas[ id=" + id + " ]";
    }

}
