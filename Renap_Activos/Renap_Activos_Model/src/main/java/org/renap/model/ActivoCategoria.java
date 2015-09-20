/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.renap.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 1808236120101
 */
@Entity
@Table(name = "activo_categoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActivoCategoria.findAll", query = "SELECT a FROM ActivoCategoria a"),
    @NamedQuery(name = "ActivoCategoria.findByIdcategoria", query = "SELECT a FROM ActivoCategoria a WHERE a.idcategoria = :idcategoria"),
    @NamedQuery(name = "ActivoCategoria.findByNombre", query = "SELECT a FROM ActivoCategoria a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "ActivoCategoria.findByDescripcion", query = "SELECT a FROM ActivoCategoria a WHERE a.descripcion = :descripcion"),
    @NamedQuery(name = "ActivoCategoria.findByIdCuentaCont", query = "SELECT a FROM ActivoCategoria a WHERE a.idCuentaCont = :idCuentaCont"),
    @NamedQuery(name = "ActivoCategoria.findByIdFuentaFin", query = "SELECT a FROM ActivoCategoria a WHERE a.idFuentaFin = :idFuentaFin"),
    @NamedQuery(name = "ActivoCategoria.findByIdPoliza", query = "SELECT a FROM ActivoCategoria a WHERE a.idPoliza = :idPoliza"),
    @NamedQuery(name = "ActivoCategoria.findByEstado", query = "SELECT a FROM ActivoCategoria a WHERE a.estado = :estado"),
    @NamedQuery(name = "ActivoCategoria.findByUsuario", query = "SELECT a FROM ActivoCategoria a WHERE a.usuario = :usuario"),
    @NamedQuery(name = "ActivoCategoria.findByFecha", query = "SELECT a FROM ActivoCategoria a WHERE a.fecha = :fecha")})
public class ActivoCategoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcategoria")
    private Integer idcategoria;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "id_cuenta_cont")
    private Integer idCuentaCont;
    @Column(name = "id_fuenta_fin")
    private Integer idFuentaFin;
    @Column(name = "id_poliza")
    private Integer idPoliza;
    @Column(name = "estado")
    private Character estado;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "cuentas_idcuentas", referencedColumnName = "idcuentas")
    @ManyToOne(optional = false)
    private Cuentas cuentasIdcuentas;

    public ActivoCategoria() {
    }

    public ActivoCategoria(Integer idcategoria) {
        this.idcategoria = idcategoria;
    }

    public Integer getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(Integer idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdCuentaCont() {
        return idCuentaCont;
    }

    public void setIdCuentaCont(Integer idCuentaCont) {
        this.idCuentaCont = idCuentaCont;
    }

    public Integer getIdFuentaFin() {
        return idFuentaFin;
    }

    public void setIdFuentaFin(Integer idFuentaFin) {
        this.idFuentaFin = idFuentaFin;
    }

    public Integer getIdPoliza() {
        return idPoliza;
    }

    public void setIdPoliza(Integer idPoliza) {
        this.idPoliza = idPoliza;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
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

    public Cuentas getCuentasIdcuentas() {
        return cuentasIdcuentas;
    }

    public void setCuentasIdcuentas(Cuentas cuentasIdcuentas) {
        this.cuentasIdcuentas = cuentasIdcuentas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcategoria != null ? idcategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActivoCategoria)) {
            return false;
        }
        ActivoCategoria other = (ActivoCategoria) object;
        if ((this.idcategoria == null && other.idcategoria != null) || (this.idcategoria != null && !this.idcategoria.equals(other.idcategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.orm.activosorm.ActivoCategoria[ idcategoria=" + idcategoria + " ]";
    }
    
}
