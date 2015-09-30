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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 1808236120101
 */
@Entity
@Table(name = "traslado_responsabilidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrasladoResponsabilidad.findAll", query = "SELECT t FROM TrasladoResponsabilidad t"),
    @NamedQuery(name = "TrasladoResponsabilidad.findByIdtrasladoResponsabilidad", query = "SELECT t FROM TrasladoResponsabilidad t WHERE t.idtrasladoResponsabilidad = :idtrasladoResponsabilidad"),
    @NamedQuery(name = "TrasladoResponsabilidad.findByCuiOrigen", query = "SELECT t FROM TrasladoResponsabilidad t WHERE t.cuiOrigen = :cuiOrigen"),
    @NamedQuery(name = "TrasladoResponsabilidad.findByCuiDestino", query = "SELECT t FROM TrasladoResponsabilidad t WHERE t.cuiDestino = :cuiDestino"),
    @NamedQuery(name = "TrasladoResponsabilidad.findByActivoId", query = "SELECT t FROM TrasladoResponsabilidad t WHERE t.activoId = :activoId"),
    @NamedQuery(name = "TrasladoResponsabilidad.findByTrasladoResponsabilidadcol", query = "SELECT t FROM TrasladoResponsabilidad t WHERE t.trasladoResponsabilidadcol = :trasladoResponsabilidadcol")})
public class TrasladoResponsabilidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idtraslado_responsabilidad")
    private Integer idtrasladoResponsabilidad;
    @Column(name = "cui_origen")
    private String cuiOrigen;
    @Column(name = "cui_destino")
    private String cuiDestino;
    @Column(name = "activo_id")
    private String activoId;
    @Column(name = "traslado_responsabilidadcol")
    private String trasladoResponsabilidadcol;

    public TrasladoResponsabilidad() {
    }

    public TrasladoResponsabilidad(Integer idtrasladoResponsabilidad) {
        this.idtrasladoResponsabilidad = idtrasladoResponsabilidad;
    }

    public Integer getIdtrasladoResponsabilidad() {
        return idtrasladoResponsabilidad;
    }

    public void setIdtrasladoResponsabilidad(Integer idtrasladoResponsabilidad) {
        this.idtrasladoResponsabilidad = idtrasladoResponsabilidad;
    }

    public String getCuiOrigen() {
        return cuiOrigen;
    }

    public void setCuiOrigen(String cuiOrigen) {
        this.cuiOrigen = cuiOrigen;
    }

    public String getCuiDestino() {
        return cuiDestino;
    }

    public void setCuiDestino(String cuiDestino) {
        this.cuiDestino = cuiDestino;
    }

    public String getActivoId() {
        return activoId;
    }

    public void setActivoId(String activoId) {
        this.activoId = activoId;
    }

    public String getTrasladoResponsabilidadcol() {
        return trasladoResponsabilidadcol;
    }

    public void setTrasladoResponsabilidadcol(String trasladoResponsabilidadcol) {
        this.trasladoResponsabilidadcol = trasladoResponsabilidadcol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtrasladoResponsabilidad != null ? idtrasladoResponsabilidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrasladoResponsabilidad)) {
            return false;
        }
        TrasladoResponsabilidad other = (TrasladoResponsabilidad) object;
        if ((this.idtrasladoResponsabilidad == null && other.idtrasladoResponsabilidad != null) || (this.idtrasladoResponsabilidad != null && !this.idtrasladoResponsabilidad.equals(other.idtrasladoResponsabilidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.orm.activosorm.TrasladoResponsabilidad[ idtrasladoResponsabilidad=" + idtrasladoResponsabilidad + " ]";
    }
    
}
