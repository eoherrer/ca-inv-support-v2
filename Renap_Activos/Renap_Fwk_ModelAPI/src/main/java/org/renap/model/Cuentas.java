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
@Table(name = "cuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuentas.findAll", query = "SELECT c FROM Cuentas c"),
    @NamedQuery(name = "Cuentas.findByIdcuentas", query = "SELECT c FROM Cuentas c WHERE c.idcuentas = :idcuentas"),
    @NamedQuery(name = "Cuentas.findByNumeroCuenta", query = "SELECT c FROM Cuentas c WHERE c.numeroCuenta = :numeroCuenta"),
    @NamedQuery(name = "Cuentas.findByNombre", query = "SELECT c FROM Cuentas c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Cuentas.findByIdCuentaNueva", query = "SELECT c FROM Cuentas c WHERE c.idCuentaNueva = :idCuentaNueva"),
    @NamedQuery(name = "Cuentas.findByIdReglon", query = "SELECT c FROM Cuentas c WHERE c.idReglon = :idReglon"),
    @NamedQuery(name = "Cuentas.findByUsuario", query = "SELECT c FROM Cuentas c WHERE c.usuario = :usuario"),
    @NamedQuery(name = "Cuentas.findByFecha", query = "SELECT c FROM Cuentas c WHERE c.fecha = :fecha")})
public class Cuentas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcuentas")
    private Integer idcuentas;
    @Column(name = "numero_cuenta")
    private String numeroCuenta;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "id_cuenta_nueva")
    private Integer idCuentaNueva;
    @Column(name = "id_reglon")
    private String idReglon;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "cuentas_nuevas_idcuentas_nuevas", referencedColumnName = "idcuentas_nuevas")
    @ManyToOne(optional = false)
    private CuentasNuevas cuentasNuevasIdcuentasNuevas;
    @JoinColumn(name = "departamento_region_idregiones", referencedColumnName = "idregiones")
    @ManyToOne(optional = false)
    private DepartamentoRegion departamentoRegionIdregiones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuentasIdcuentas")
    private Collection<ActivoCategoria> activoCategoriaCollection;

    public Cuentas() {
    }

    public Cuentas(Integer idcuentas) {
        this.idcuentas = idcuentas;
    }

    public Integer getIdcuentas() {
        return idcuentas;
    }

    public void setIdcuentas(Integer idcuentas) {
        this.idcuentas = idcuentas;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdCuentaNueva() {
        return idCuentaNueva;
    }

    public void setIdCuentaNueva(Integer idCuentaNueva) {
        this.idCuentaNueva = idCuentaNueva;
    }

    public String getIdReglon() {
        return idReglon;
    }

    public void setIdReglon(String idReglon) {
        this.idReglon = idReglon;
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

    public CuentasNuevas getCuentasNuevasIdcuentasNuevas() {
        return cuentasNuevasIdcuentasNuevas;
    }

    public void setCuentasNuevasIdcuentasNuevas(CuentasNuevas cuentasNuevasIdcuentasNuevas) {
        this.cuentasNuevasIdcuentasNuevas = cuentasNuevasIdcuentasNuevas;
    }

    public DepartamentoRegion getDepartamentoRegionIdregiones() {
        return departamentoRegionIdregiones;
    }

    public void setDepartamentoRegionIdregiones(DepartamentoRegion departamentoRegionIdregiones) {
        this.departamentoRegionIdregiones = departamentoRegionIdregiones;
    }

    @XmlTransient
    public Collection<ActivoCategoria> getActivoCategoriaCollection() {
        return activoCategoriaCollection;
    }

    public void setActivoCategoriaCollection(Collection<ActivoCategoria> activoCategoriaCollection) {
        this.activoCategoriaCollection = activoCategoriaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcuentas != null ? idcuentas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuentas)) {
            return false;
        }
        Cuentas other = (Cuentas) object;
        if ((this.idcuentas == null && other.idcuentas != null) || (this.idcuentas != null && !this.idcuentas.equals(other.idcuentas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.orm.activosorm.Cuentas[ idcuentas=" + idcuentas + " ]";
    }
    
}
