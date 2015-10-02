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
import javax.persistence.Lob;
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
@Table(name = "IDM_CONTRATO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IdmContrato.findAll", query = "SELECT i FROM IdmContrato i"),
    @NamedQuery(name = "IdmContrato.findById", query = "SELECT i FROM IdmContrato i WHERE i.id = :id"),
    @NamedQuery(name = "IdmContrato.findByNombreContrato", query = "SELECT i FROM IdmContrato i WHERE i.nombreContrato = :nombreContrato"),
    @NamedQuery(name = "IdmContrato.findByFechaInicio", query = "SELECT i FROM IdmContrato i WHERE i.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "IdmContrato.findByFechaFin", query = "SELECT i FROM IdmContrato i WHERE i.fechaFin = :fechaFin"),
    @NamedQuery(name = "IdmContrato.findByHoraInicioJornada", query = "SELECT i FROM IdmContrato i WHERE i.horaInicioJornada = :horaInicioJornada"),
    @NamedQuery(name = "IdmContrato.findByHoraFinJornada", query = "SELECT i FROM IdmContrato i WHERE i.horaFinJornada = :horaFinJornada"),
    @NamedQuery(name = "IdmContrato.findBySalario", query = "SELECT i FROM IdmContrato i WHERE i.salario = :salario"),
    @NamedQuery(name = "IdmContrato.findByEstado", query = "SELECT i FROM IdmContrato i WHERE i.estado = :estado"),
    @NamedQuery(name = "IdmContrato.findByFechaIng", query = "SELECT i FROM IdmContrato i WHERE i.fechaIng = :fechaIng"),
    @NamedQuery(name = "IdmContrato.findByUsuarioIng", query = "SELECT i FROM IdmContrato i WHERE i.usuarioIng = :usuarioIng"),
    @NamedQuery(name = "IdmContrato.findByFechaAct", query = "SELECT i FROM IdmContrato i WHERE i.fechaAct = :fechaAct"),
    @NamedQuery(name = "IdmContrato.findByUsuarioAct", query = "SELECT i FROM IdmContrato i WHERE i.usuarioAct = :usuarioAct"),
    @NamedQuery(name = "IdmContrato.findByTipoContrato", query = "SELECT i FROM IdmContrato i WHERE i.tipoContrato = :tipoContrato")})
public class IdmContrato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Size(max = 100)
    @Column(name = "NOMBRE_CONTRATO")
    private String nombreContrato;
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Column(name = "HORA_INICIO_JORNADA")
    private Long horaInicioJornada;
    @Column(name = "HORA_FIN_JORNADA")
    private Long horaFinJornada;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SALARIO")
    private BigDecimal salario;
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
    @Column(name = "TIPO_CONTRATO")
    private Short tipoContrato;
    @Lob
    @Column(name = "ARCHIVO")
    private String archivo;
    @JoinColumn(name = "ID_RENGLON", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private IdmRenglon idRenglon;

    public IdmContrato() {
    }

    public IdmContrato(Long id) {
        this.id = id;
    }

    public IdmContrato(Long id, String estado, Date fechaIng) {
        this.id = id;
        this.estado = estado;
        this.fechaIng = fechaIng;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreContrato() {
        return nombreContrato;
    }

    public void setNombreContrato(String nombreContrato) {
        this.nombreContrato = nombreContrato;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Long getHoraInicioJornada() {
        return horaInicioJornada;
    }

    public void setHoraInicioJornada(Long horaInicioJornada) {
        this.horaInicioJornada = horaInicioJornada;
    }

    public Long getHoraFinJornada() {
        return horaFinJornada;
    }

    public void setHoraFinJornada(Long horaFinJornada) {
        this.horaFinJornada = horaFinJornada;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
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

    public Short getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(Short tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public IdmRenglon getIdRenglon() {
        return idRenglon;
    }

    public void setIdRenglon(IdmRenglon idRenglon) {
        this.idRenglon = idRenglon;
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
        if (!(object instanceof IdmContrato)) {
            return false;
        }
        IdmContrato other = (IdmContrato) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.model.IdmContrato[ id=" + id + " ]";
    }
    
}
