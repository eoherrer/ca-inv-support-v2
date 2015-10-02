/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.renap.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author 2703759290608
 */
@Embeddable
public class IdmRolFuncionPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ROL")
    private long idRol;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_FUNCION")
    private long idFuncion;

    public IdmRolFuncionPK() {
    }

    public IdmRolFuncionPK(long idRol, long idFuncion) {
        this.idRol = idRol;
        this.idFuncion = idFuncion;
    }

    public long getIdRol() {
        return idRol;
    }

    public void setIdRol(long idRol) {
        this.idRol = idRol;
    }

    public long getIdFuncion() {
        return idFuncion;
    }

    public void setIdFuncion(long idFuncion) {
        this.idFuncion = idFuncion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idRol;
        hash += (int) idFuncion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IdmRolFuncionPK)) {
            return false;
        }
        IdmRolFuncionPK other = (IdmRolFuncionPK) object;
        if (this.idRol != other.idRol) {
            return false;
        }
        if (this.idFuncion != other.idFuncion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.model.IdmRolFuncionPK[ idRol=" + idRol + ", idFuncion=" + idFuncion + " ]";
    }
    
}
