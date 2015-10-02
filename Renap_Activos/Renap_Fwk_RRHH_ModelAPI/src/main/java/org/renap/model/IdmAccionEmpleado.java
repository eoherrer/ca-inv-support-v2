/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.renap.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 2703759290608
 */
@Entity
@Table(name = "IDM_ACCION_EMPLEADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IdmAccionEmpleado.findAll", query = "SELECT i FROM IdmAccionEmpleado i"),
    @NamedQuery(name = "IdmAccionEmpleado.findById", query = "SELECT i FROM IdmAccionEmpleado i WHERE i.id = :id"),
    @NamedQuery(name = "IdmAccionEmpleado.findByIdEmpleado", query = "SELECT i FROM IdmAccionEmpleado i WHERE i.idEmpleado = :idEmpleado"),
    @NamedQuery(name = "IdmAccionEmpleado.findByIdContrato", query = "SELECT i FROM IdmAccionEmpleado i WHERE i.idContrato = :idContrato"),
    @NamedQuery(name = "IdmAccionEmpleado.findByIdPlaza", query = "SELECT i FROM IdmAccionEmpleado i WHERE i.idPlaza = :idPlaza"),
    @NamedQuery(name = "IdmAccionEmpleado.findByObservaciones", query = "SELECT i FROM IdmAccionEmpleado i WHERE i.observaciones = :observaciones"),
    @NamedQuery(name = "IdmAccionEmpleado.findByEstado", query = "SELECT i FROM IdmAccionEmpleado i WHERE i.estado = :estado"),
    @NamedQuery(name = "IdmAccionEmpleado.findByFechaIng", query = "SELECT i FROM IdmAccionEmpleado i WHERE i.fechaIng = :fechaIng"),
    @NamedQuery(name = "IdmAccionEmpleado.findByUsuarioIng", query = "SELECT i FROM IdmAccionEmpleado i WHERE i.usuarioIng = :usuarioIng")})
public class IdmAccionEmpleado implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "ID_EMPLEADO")
    private BigInteger idEmpleado;
    @Column(name = "ID_CONTRATO")
    private Long idContrato;
    @Column(name = "ID_PLAZA")
    private Long idPlaza;
    @Size(max = 300)
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ESTADO")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_ING")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIng;
    @Size(max = 15)
    @Column(name = "USUARIO_ING")
    private String usuarioIng;
    @JoinColumn(name = "ID_ACCION", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private IdmAccion idAccion;

    public IdmAccionEmpleado() {
    }

    public IdmAccionEmpleado(BigDecimal id) {
        this.id = id;
    }

    public IdmAccionEmpleado(BigDecimal id, String estado, Date fechaIng) {
        this.id = id;
        this.estado = estado;
        this.fechaIng = fechaIng;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(BigInteger idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Long getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(Long idContrato) {
        this.idContrato = idContrato;
    }

    public Long getIdPlaza() {
        return idPlaza;
    }

    public void setIdPlaza(Long idPlaza) {
        this.idPlaza = idPlaza;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaIng() {
        return fechaIng;
    }

    public void setFechaIng(Date fechaIng) {
        this.fechaIng = fechaIng;
    }

    public String getUsuarioIng() {
        return usuarioIng;
    }

    public void setUsuarioIng(String usuarioIng) {
        this.usuarioIng = usuarioIng;
    }

    public IdmAccion getIdAccion() {
        return idAccion;
    }

    public void setIdAccion(IdmAccion idAccion) {
        this.idAccion = idAccion;
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
        if (!(object instanceof IdmAccionEmpleado)) {
            return false;
        }
        IdmAccionEmpleado other = (IdmAccionEmpleado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.model.IdmAccionEmpleado[ id=" + id + " ]";
    }
    
}
