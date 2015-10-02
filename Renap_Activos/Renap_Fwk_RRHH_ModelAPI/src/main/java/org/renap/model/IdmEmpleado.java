/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.renap.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "IDM_EMPLEADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IdmEmpleado.findAll", query = "SELECT i FROM IdmEmpleado i"),
    @NamedQuery(name = "IdmEmpleado.findById", query = "SELECT i FROM IdmEmpleado i WHERE i.id = :id"),
    @NamedQuery(name = "IdmEmpleado.findByIdContrato", query = "SELECT i FROM IdmEmpleado i WHERE i.idContrato = :idContrato"),
    @NamedQuery(name = "IdmEmpleado.findByNumeroAfiliacion", query = "SELECT i FROM IdmEmpleado i WHERE i.numeroAfiliacion = :numeroAfiliacion"),
    @NamedQuery(name = "IdmEmpleado.findByCorreoElectronico", query = "SELECT i FROM IdmEmpleado i WHERE i.correoElectronico = :correoElectronico"),
    @NamedQuery(name = "IdmEmpleado.findByObservaciones", query = "SELECT i FROM IdmEmpleado i WHERE i.observaciones = :observaciones"),
    @NamedQuery(name = "IdmEmpleado.findByEstado", query = "SELECT i FROM IdmEmpleado i WHERE i.estado = :estado"),
    @NamedQuery(name = "IdmEmpleado.findByFechaIng", query = "SELECT i FROM IdmEmpleado i WHERE i.fechaIng = :fechaIng"),
    @NamedQuery(name = "IdmEmpleado.findByUsuarioIng", query = "SELECT i FROM IdmEmpleado i WHERE i.usuarioIng = :usuarioIng"),
    @NamedQuery(name = "IdmEmpleado.findByFechaAct", query = "SELECT i FROM IdmEmpleado i WHERE i.fechaAct = :fechaAct"),
    @NamedQuery(name = "IdmEmpleado.findByUsuarioAct", query = "SELECT i FROM IdmEmpleado i WHERE i.usuarioAct = :usuarioAct"),
    @NamedQuery(name = "IdmEmpleado.findByNumeroEmpleado", query = "SELECT i FROM IdmEmpleado i WHERE i.numeroEmpleado = :numeroEmpleado")})
public class IdmEmpleado implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "ID_CONTRATO")
    private Long idContrato;
    @Size(max = 15)
    @Column(name = "NUMERO_AFILIACION")
    private String numeroAfiliacion;
    @Size(max = 50)
    @Column(name = "CORREO_ELECTRONICO")
    private String correoElectronico;
    @Size(max = 100)
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
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
    @Column(name = "FECHA_ACT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAct;
    @Size(max = 20)
    @Column(name = "USUARIO_ACT")
    private String usuarioAct;
    @Column(name = "NUMERO_EMPLEADO")
    private Long numeroEmpleado;
    @JoinColumn(name = "ID_BIOMETRICO", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private IdmBiometrico idBiometrico;
    @JoinColumn(name = "ID_PERSONA", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private IdmPersona idPersona;
    @JoinColumn(name = "ID_PLAZA", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private IdmPlaza idPlaza;

    public IdmEmpleado() {
    }

    public IdmEmpleado(BigDecimal id) {
        this.id = id;
    }

    public IdmEmpleado(BigDecimal id, String estado, Date fechaIng) {
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

    public Long getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(Long idContrato) {
        this.idContrato = idContrato;
    }

    public String getNumeroAfiliacion() {
        return numeroAfiliacion;
    }

    public void setNumeroAfiliacion(String numeroAfiliacion) {
        this.numeroAfiliacion = numeroAfiliacion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
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

    public Date getFechaAct() {
        return fechaAct;
    }

    public void setFechaAct(Date fechaAct) {
        this.fechaAct = fechaAct;
    }

    public String getUsuarioAct() {
        return usuarioAct;
    }

    public void setUsuarioAct(String usuarioAct) {
        this.usuarioAct = usuarioAct;
    }

    public Long getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(Long numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    public IdmBiometrico getIdBiometrico() {
        return idBiometrico;
    }

    public void setIdBiometrico(IdmBiometrico idBiometrico) {
        this.idBiometrico = idBiometrico;
    }

    public IdmPersona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(IdmPersona idPersona) {
        this.idPersona = idPersona;
    }

    public IdmPlaza getIdPlaza() {
        return idPlaza;
    }

    public void setIdPlaza(IdmPlaza idPlaza) {
        this.idPlaza = idPlaza;
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
        if (!(object instanceof IdmEmpleado)) {
            return false;
        }
        IdmEmpleado other = (IdmEmpleado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.model.IdmEmpleado[ id=" + id + " ]";
    }
    
}
