/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.renap.model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 2703759290608
 */
@Entity
@Table(name = "IDM_USUARIO_ROL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IdmUsuarioRol.findAll", query = "SELECT i FROM IdmUsuarioRol i"),
    @NamedQuery(name = "IdmUsuarioRol.findByIdRol", query = "SELECT i FROM IdmUsuarioRol i WHERE i.idmUsuarioRolPK.idRol = :idRol"),
    @NamedQuery(name = "IdmUsuarioRol.findByIdUsuario", query = "SELECT i FROM IdmUsuarioRol i WHERE i.idmUsuarioRolPK.idUsuario = :idUsuario")})
public class IdmUsuarioRol implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected IdmUsuarioRolPK idmUsuarioRolPK;

    public IdmUsuarioRol() {
    }

    public IdmUsuarioRol(IdmUsuarioRolPK idmUsuarioRolPK) {
        this.idmUsuarioRolPK = idmUsuarioRolPK;
    }

    public IdmUsuarioRol(long idRol, long idUsuario) {
        this.idmUsuarioRolPK = new IdmUsuarioRolPK(idRol, idUsuario);
    }

    public IdmUsuarioRolPK getIdmUsuarioRolPK() {
        return idmUsuarioRolPK;
    }

    public void setIdmUsuarioRolPK(IdmUsuarioRolPK idmUsuarioRolPK) {
        this.idmUsuarioRolPK = idmUsuarioRolPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmUsuarioRolPK != null ? idmUsuarioRolPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IdmUsuarioRol)) {
            return false;
        }
        IdmUsuarioRol other = (IdmUsuarioRol) object;
        if ((this.idmUsuarioRolPK == null && other.idmUsuarioRolPK != null) || (this.idmUsuarioRolPK != null && !this.idmUsuarioRolPK.equals(other.idmUsuarioRolPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.model.IdmUsuarioRol[ idmUsuarioRolPK=" + idmUsuarioRolPK + " ]";
    }
    
}
