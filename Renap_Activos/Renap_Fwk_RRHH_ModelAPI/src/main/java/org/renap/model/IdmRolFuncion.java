/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.renap.model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 2703759290608
 */
@Entity
@Table(name = "IDM_ROL_FUNCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IdmRolFuncion.findAll", query = "SELECT i FROM IdmRolFuncion i"),
    @NamedQuery(name = "IdmRolFuncion.findByIdRol", query = "SELECT i FROM IdmRolFuncion i WHERE i.idmRolFuncionPK.idRol = :idRol"),
    @NamedQuery(name = "IdmRolFuncion.findByIdFuncion", query = "SELECT i FROM IdmRolFuncion i WHERE i.idmRolFuncionPK.idFuncion = :idFuncion")})
public class IdmRolFuncion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected IdmRolFuncionPK idmRolFuncionPK;
    @JoinColumn(name = "ID_ROL", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private IdmRol idmRol;

    public IdmRolFuncion() {
    }

    public IdmRolFuncion(IdmRolFuncionPK idmRolFuncionPK) {
        this.idmRolFuncionPK = idmRolFuncionPK;
    }

    public IdmRolFuncion(long idRol, long idFuncion) {
        this.idmRolFuncionPK = new IdmRolFuncionPK(idRol, idFuncion);
    }

    public IdmRolFuncionPK getIdmRolFuncionPK() {
        return idmRolFuncionPK;
    }

    public void setIdmRolFuncionPK(IdmRolFuncionPK idmRolFuncionPK) {
        this.idmRolFuncionPK = idmRolFuncionPK;
    }

    public IdmRol getIdmRol() {
        return idmRol;
    }

    public void setIdmRol(IdmRol idmRol) {
        this.idmRol = idmRol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmRolFuncionPK != null ? idmRolFuncionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IdmRolFuncion)) {
            return false;
        }
        IdmRolFuncion other = (IdmRolFuncion) object;
        if ((this.idmRolFuncionPK == null && other.idmRolFuncionPK != null) || (this.idmRolFuncionPK != null && !this.idmRolFuncionPK.equals(other.idmRolFuncionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.model.IdmRolFuncion[ idmRolFuncionPK=" + idmRolFuncionPK + " ]";
    }
    
}
