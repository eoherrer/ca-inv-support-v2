/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.renap.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 2703759290608
 */
@Entity
@Table(name = "IDM_PLAZA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IdmPlaza.findAll", query = "SELECT i FROM IdmPlaza i"),
    @NamedQuery(name = "IdmPlaza.findById", query = "SELECT i FROM IdmPlaza i WHERE i.id = :id"),
    @NamedQuery(name = "IdmPlaza.findByPartidaPresupuestaria", query = "SELECT i FROM IdmPlaza i WHERE i.partidaPresupuestaria = :partidaPresupuestaria"),
    @NamedQuery(name = "IdmPlaza.findBySalarioBase", query = "SELECT i FROM IdmPlaza i WHERE i.salarioBase = :salarioBase"),
    @NamedQuery(name = "IdmPlaza.findByBonoProfesional", query = "SELECT i FROM IdmPlaza i WHERE i.bonoProfesional = :bonoProfesional"),
    @NamedQuery(name = "IdmPlaza.findByBonoDecreto372001", query = "SELECT i FROM IdmPlaza i WHERE i.bonoDecreto372001 = :bonoDecreto372001"),
    @NamedQuery(name = "IdmPlaza.findBySalarioMensual", query = "SELECT i FROM IdmPlaza i WHERE i.salarioMensual = :salarioMensual"),
    @NamedQuery(name = "IdmPlaza.findByEstado", query = "SELECT i FROM IdmPlaza i WHERE i.estado = :estado"),
    @NamedQuery(name = "IdmPlaza.findByFechaIng", query = "SELECT i FROM IdmPlaza i WHERE i.fechaIng = :fechaIng"),
    @NamedQuery(name = "IdmPlaza.findByUsuarioIng", query = "SELECT i FROM IdmPlaza i WHERE i.usuarioIng = :usuarioIng")})
public class IdmPlaza implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PARTIDA_PRESUPUESTARIA")
    private String partidaPresupuestaria;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "SALARIO_BASE")
    private BigDecimal salarioBase;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BONO_PROFESIONAL")
    private BigDecimal bonoProfesional;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BONO_DECRETO_37_2001")
    private BigDecimal bonoDecreto372001;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SALARIO_MENSUAL")
    private BigDecimal salarioMensual;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
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
    @JoinColumn(name = "ID_PUESTO", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private IdmPuesto idPuesto;
    @JoinColumn(name = "ID_RENGLON", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private IdmRenglon idRenglon;
    @JoinColumn(name = "ID_UNIDAD", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private IdmUnidad idUnidad;
    @OneToMany(mappedBy = "idPlaza", fetch = FetchType.EAGER)
    private List<IdmEmpleado> idmEmpleadoList;

    public IdmPlaza() {
    }

    public IdmPlaza(Long id) {
        this.id = id;
    }

    public IdmPlaza(Long id, String partidaPresupuestaria, BigDecimal salarioBase, BigDecimal bonoProfesional, BigDecimal bonoDecreto372001, BigDecimal salarioMensual, String estado, Date fechaIng) {
        this.id = id;
        this.partidaPresupuestaria = partidaPresupuestaria;
        this.salarioBase = salarioBase;
        this.bonoProfesional = bonoProfesional;
        this.bonoDecreto372001 = bonoDecreto372001;
        this.salarioMensual = salarioMensual;
        this.estado = estado;
        this.fechaIng = fechaIng;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPartidaPresupuestaria() {
        return partidaPresupuestaria;
    }

    public void setPartidaPresupuestaria(String partidaPresupuestaria) {
        this.partidaPresupuestaria = partidaPresupuestaria;
    }

    public BigDecimal getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(BigDecimal salarioBase) {
        this.salarioBase = salarioBase;
    }

    public BigDecimal getBonoProfesional() {
        return bonoProfesional;
    }

    public void setBonoProfesional(BigDecimal bonoProfesional) {
        this.bonoProfesional = bonoProfesional;
    }

    public BigDecimal getBonoDecreto372001() {
        return bonoDecreto372001;
    }

    public void setBonoDecreto372001(BigDecimal bonoDecreto372001) {
        this.bonoDecreto372001 = bonoDecreto372001;
    }

    public BigDecimal getSalarioMensual() {
        return salarioMensual;
    }

    public void setSalarioMensual(BigDecimal salarioMensual) {
        this.salarioMensual = salarioMensual;
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

    public IdmPuesto getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(IdmPuesto idPuesto) {
        this.idPuesto = idPuesto;
    }

    public IdmRenglon getIdRenglon() {
        return idRenglon;
    }

    public void setIdRenglon(IdmRenglon idRenglon) {
        this.idRenglon = idRenglon;
    }

    public IdmUnidad getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(IdmUnidad idUnidad) {
        this.idUnidad = idUnidad;
    }

    @XmlTransient
    public List<IdmEmpleado> getIdmEmpleadoList() {
        return idmEmpleadoList;
    }

    public void setIdmEmpleadoList(List<IdmEmpleado> idmEmpleadoList) {
        this.idmEmpleadoList = idmEmpleadoList;
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
        if (!(object instanceof IdmPlaza)) {
            return false;
        }
        IdmPlaza other = (IdmPlaza) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.model.IdmPlaza[ id=" + id + " ]";
    }
    
}
