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
@Table(name = "IDM_APLICACION_FUNCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IdmAplicacionFuncion.findAll", query = "SELECT i FROM IdmAplicacionFuncion i"),
    @NamedQuery(name = "IdmAplicacionFuncion.findByIdAplicacion", query = "SELECT i FROM IdmAplicacionFuncion i WHERE i.idmAplicacionFuncionPK.idAplicacion = :idAplicacion"),
    @NamedQuery(name = "IdmAplicacionFuncion.findByIdFuncion", query = "SELECT i FROM IdmAplicacionFuncion i WHERE i.idmAplicacionFuncionPK.idFuncion = :idFuncion")})
public class IdmAplicacionFuncion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected IdmAplicacionFuncionPK idmAplicacionFuncionPK;
    @JoinColumn(name = "ID_APLICACION", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private IdmAplicacion idmAplicacion;

    public IdmAplicacionFuncion() {
    }

    public IdmAplicacionFuncion(IdmAplicacionFuncionPK idmAplicacionFuncionPK) {
        this.idmAplicacionFuncionPK = idmAplicacionFuncionPK;
    }

    public IdmAplicacionFuncion(long idAplicacion, long idFuncion) {
        this.idmAplicacionFuncionPK = new IdmAplicacionFuncionPK(idAplicacion, idFuncion);
    }

    public IdmAplicacionFuncionPK getIdmAplicacionFuncionPK() {
        return idmAplicacionFuncionPK;
    }

    public void setIdmAplicacionFuncionPK(IdmAplicacionFuncionPK idmAplicacionFuncionPK) {
        this.idmAplicacionFuncionPK = idmAplicacionFuncionPK;
    }

    public IdmAplicacion getIdmAplicacion() {
        return idmAplicacion;
    }

    public void setIdmAplicacion(IdmAplicacion idmAplicacion) {
        this.idmAplicacion = idmAplicacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmAplicacionFuncionPK != null ? idmAplicacionFuncionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IdmAplicacionFuncion)) {
            return false;
        }
        IdmAplicacionFuncion other = (IdmAplicacionFuncion) object;
        if ((this.idmAplicacionFuncionPK == null && other.idmAplicacionFuncionPK != null) || (this.idmAplicacionFuncionPK != null && !this.idmAplicacionFuncionPK.equals(other.idmAplicacionFuncionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.model.IdmAplicacionFuncion[ idmAplicacionFuncionPK=" + idmAplicacionFuncionPK + " ]";
    }
    
}
