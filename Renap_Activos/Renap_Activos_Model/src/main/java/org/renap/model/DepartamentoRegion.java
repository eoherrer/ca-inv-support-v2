/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.renap.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 1808236120101
 */
@Entity
@Table(name = "departamento_region")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DepartamentoRegion.findAll", query = "SELECT d FROM DepartamentoRegion d"),
    @NamedQuery(name = "DepartamentoRegion.findByIdregiones", query = "SELECT d FROM DepartamentoRegion d WHERE d.idregiones = :idregiones"),
    @NamedQuery(name = "DepartamentoRegion.findByRegion", query = "SELECT d FROM DepartamentoRegion d WHERE d.region = :region"),
    @NamedQuery(name = "DepartamentoRegion.findByUsuario", query = "SELECT d FROM DepartamentoRegion d WHERE d.usuario = :usuario"),
    @NamedQuery(name = "DepartamentoRegion.findByFecha", query = "SELECT d FROM DepartamentoRegion d WHERE d.fecha = :fecha")})
public class DepartamentoRegion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idregiones")
    private Integer idregiones;
    @Column(name = "region")
    private String region;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departamentoRegionIdregiones")
    private Collection<Cuentas> cuentasCollection;
    @JoinColumn(name = "departamento_iddepartamento", referencedColumnName = "iddepartamento")
    @ManyToOne(optional = false)
    private Departamento departamentoIddepartamento;

    public DepartamentoRegion() {
    }

    public DepartamentoRegion(Integer idregiones) {
        this.idregiones = idregiones;
    }

    public Integer getIdregiones() {
        return idregiones;
    }

    public void setIdregiones(Integer idregiones) {
        this.idregiones = idregiones;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @XmlTransient
    public Collection<Cuentas> getCuentasCollection() {
        return cuentasCollection;
    }

    public void setCuentasCollection(Collection<Cuentas> cuentasCollection) {
        this.cuentasCollection = cuentasCollection;
    }

    public Departamento getDepartamentoIddepartamento() {
        return departamentoIddepartamento;
    }

    public void setDepartamentoIddepartamento(Departamento departamentoIddepartamento) {
        this.departamentoIddepartamento = departamentoIddepartamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idregiones != null ? idregiones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DepartamentoRegion)) {
            return false;
        }
        DepartamentoRegion other = (DepartamentoRegion) object;
        if ((this.idregiones == null && other.idregiones != null) || (this.idregiones != null && !this.idregiones.equals(other.idregiones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.orm.activosorm.DepartamentoRegion[ idregiones=" + idregiones + " ]";
    }
    
}
