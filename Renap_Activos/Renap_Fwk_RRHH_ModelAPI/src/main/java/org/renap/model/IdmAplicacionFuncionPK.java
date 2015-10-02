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
public class IdmAplicacionFuncionPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_APLICACION")
    private long idAplicacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_FUNCION")
    private long idFuncion;

    public IdmAplicacionFuncionPK() {
    }

    public IdmAplicacionFuncionPK(long idAplicacion, long idFuncion) {
        this.idAplicacion = idAplicacion;
        this.idFuncion = idFuncion;
    }

    public long getIdAplicacion() {
        return idAplicacion;
    }

    public void setIdAplicacion(long idAplicacion) {
        this.idAplicacion = idAplicacion;
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
        hash += (int) idAplicacion;
        hash += (int) idFuncion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IdmAplicacionFuncionPK)) {
            return false;
        }
        IdmAplicacionFuncionPK other = (IdmAplicacionFuncionPK) object;
        if (this.idAplicacion != other.idAplicacion) {
            return false;
        }
        if (this.idFuncion != other.idFuncion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.model.IdmAplicacionFuncionPK[ idAplicacion=" + idAplicacion + ", idFuncion=" + idFuncion + " ]";
    }
    
}
