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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 2703759290608
 */
@Entity
@Table(name = "IDM_BIOMETRICO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IdmBiometrico.findAll", query = "SELECT i FROM IdmBiometrico i"),
    @NamedQuery(name = "IdmBiometrico.findById", query = "SELECT i FROM IdmBiometrico i WHERE i.id = :id")})
public class IdmBiometrico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Lob
    @Column(name = "INDICE_DERECHO")
    private String indiceDerecho;
    @Lob
    @Column(name = "INDICE_IZQUIERDO")
    private String indiceIzquierdo;
    @OneToMany(mappedBy = "idBiometrico", fetch = FetchType.EAGER)
    private List<IdmEmpleado> idmEmpleadoList;

    public IdmBiometrico() {
    }

    public IdmBiometrico(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIndiceDerecho() {
        return indiceDerecho;
    }

    public void setIndiceDerecho(String indiceDerecho) {
        this.indiceDerecho = indiceDerecho;
    }

    public String getIndiceIzquierdo() {
        return indiceIzquierdo;
    }

    public void setIndiceIzquierdo(String indiceIzquierdo) {
        this.indiceIzquierdo = indiceIzquierdo;
    }

    @XmlTransient
    public List<IdmEmpleado> getIdmEmpleadoList() {
        return idmEmpleadoList;
    }

    public void setIdmEmpleadoList(List<IdmEmpleado> idmEmpleadoList) {
        this.idmEmpleadoList = idmEmpleadoList;
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
        if (!(object instanceof IdmBiometrico)) {
            return false;
        }
        IdmBiometrico other = (IdmBiometrico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.model.IdmBiometrico[ id=" + id + " ]";
    }
    
}
