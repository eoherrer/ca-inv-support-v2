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
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "IDM_SERVICIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IdmServicio.findAll", query = "SELECT i FROM IdmServicio i"),
    @NamedQuery(name = "IdmServicio.findById", query = "SELECT i FROM IdmServicio i WHERE i.id = :id"),
    @NamedQuery(name = "IdmServicio.findByNombre", query = "SELECT i FROM IdmServicio i WHERE i.nombre = :nombre"),
    @NamedQuery(name = "IdmServicio.findByFechaInicio", query = "SELECT i FROM IdmServicio i WHERE i.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "IdmServicio.findByFechaFin", query = "SELECT i FROM IdmServicio i WHERE i.fechaFin = :fechaFin"),
    @NamedQuery(name = "IdmServicio.findByHoraInicioJornada", query = "SELECT i FROM IdmServicio i WHERE i.horaInicioJornada = :horaInicioJornada"),
    @NamedQuery(name = "IdmServicio.findByHoraFinJornada", query = "SELECT i FROM IdmServicio i WHERE i.horaFinJornada = :horaFinJornada"),
    @NamedQuery(name = "IdmServicio.findBySalario", query = "SELECT i FROM IdmServicio i WHERE i.salario = :salario"),
    @NamedQuery(name = "IdmServicio.findByIdRenglon", query = "SELECT i FROM IdmServicio i WHERE i.idRenglon = :idRenglon"),
    @NamedQuery(name = "IdmServicio.findByEstado", query = "SELECT i FROM IdmServicio i WHERE i.estado = :estado"),
    @NamedQuery(name = "IdmServicio.findByFechaIng", query = "SELECT i FROM IdmServicio i WHERE i.fechaIng = :fechaIng"),
    @NamedQuery(name = "IdmServicio.findByUsuarioIng", query = "SELECT i FROM IdmServicio i WHERE i.usuarioIng = :usuarioIng"),
    @NamedQuery(name = "IdmServicio.findByFechaAct", query = "SELECT i FROM IdmServicio i WHERE i.fechaAct = :fechaAct"),
    @NamedQuery(name = "IdmServicio.findByUsuarioAct", query = "SELECT i FROM IdmServicio i WHERE i.usuarioAct = :usuarioAct")})
public class IdmServicio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Size(max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
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
    @Column(name = "ID_RENGLON")
    private int idRenglon;
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
    @Lob
    @Column(name = "ARCHIVO")
    private String archivo;

    public IdmServicio() {
    }

    public IdmServicio(Long id) {
        this.id = id;
    }

    public IdmServicio(Long id, int idRenglon, String estado, Date fechaIng) {
        this.id = id;
        this.idRenglon = idRenglon;
        this.estado = estado;
        this.fechaIng = fechaIng;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public int getIdRenglon() {
        return idRenglon;
    }

    public void setIdRenglon(int idRenglon) {
        this.idRenglon = idRenglon;
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

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
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
        if (!(object instanceof IdmServicio)) {
            return false;
        }
        IdmServicio other = (IdmServicio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.model.IdmServicio[ id=" + id + " ]";
    }
    
}
