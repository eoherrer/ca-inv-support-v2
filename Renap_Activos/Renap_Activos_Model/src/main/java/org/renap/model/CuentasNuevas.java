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
@Table(name = "cuentas_nuevas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CuentasNuevas.findAll", query = "SELECT c FROM CuentasNuevas c"),
    @NamedQuery(name = "CuentasNuevas.findByIdcuentasNuevas", query = "SELECT c FROM CuentasNuevas c WHERE c.idcuentasNuevas = :idcuentasNuevas"),
    @NamedQuery(name = "CuentasNuevas.findByNoCuenta", query = "SELECT c FROM CuentasNuevas c WHERE c.noCuenta = :noCuenta"),
    @NamedQuery(name = "CuentasNuevas.findByNombre", query = "SELECT c FROM CuentasNuevas c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "CuentasNuevas.findByIdLibro", query = "SELECT c FROM CuentasNuevas c WHERE c.idLibro = :idLibro"),
    @NamedQuery(name = "CuentasNuevas.findByUsuario", query = "SELECT c FROM CuentasNuevas c WHERE c.usuario = :usuario"),
    @NamedQuery(name = "CuentasNuevas.findByFecha", query = "SELECT c FROM CuentasNuevas c WHERE c.fecha = :fecha")})
public class CuentasNuevas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcuentas_nuevas")
    private Integer idcuentasNuevas;
    @Column(name = "no_cuenta")
    private String noCuenta;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "id_libro")
    private String idLibro;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuentasNuevasIdcuentasNuevas")
    private Collection<Cuentas> cuentasCollection;

    public CuentasNuevas() {
    }

    public CuentasNuevas(Integer idcuentasNuevas) {
        this.idcuentasNuevas = idcuentasNuevas;
    }

    public Integer getIdcuentasNuevas() {
        return idcuentasNuevas;
    }

    public void setIdcuentasNuevas(Integer idcuentasNuevas) {
        this.idcuentasNuevas = idcuentasNuevas;
    }

    public String getNoCuenta() {
        return noCuenta;
    }

    public void setNoCuenta(String noCuenta) {
        this.noCuenta = noCuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(String idLibro) {
        this.idLibro = idLibro;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcuentasNuevas != null ? idcuentasNuevas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuentasNuevas)) {
            return false;
        }
        CuentasNuevas other = (CuentasNuevas) object;
        if ((this.idcuentasNuevas == null && other.idcuentasNuevas != null) || (this.idcuentasNuevas != null && !this.idcuentasNuevas.equals(other.idcuentasNuevas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.orm.activosorm.CuentasNuevas[ idcuentasNuevas=" + idcuentasNuevas + " ]";
    }
    
}
