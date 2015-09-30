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
@Table(name = "bodega")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bodega.findAll", query = "SELECT b FROM Bodega b"),
    @NamedQuery(name = "Bodega.findByIdbodega", query = "SELECT b FROM Bodega b WHERE b.idbodega = :idbodega"),
    @NamedQuery(name = "Bodega.findByBodega", query = "SELECT b FROM Bodega b WHERE b.bodega = :bodega"),
    @NamedQuery(name = "Bodega.findByDescripcion", query = "SELECT b FROM Bodega b WHERE b.descripcion = :descripcion"),
    @NamedQuery(name = "Bodega.findByIdDepto", query = "SELECT b FROM Bodega b WHERE b.idDepto = :idDepto"),
    @NamedQuery(name = "Bodega.findByIdMunic", query = "SELECT b FROM Bodega b WHERE b.idMunic = :idMunic"),
    @NamedQuery(name = "Bodega.findByUsuario", query = "SELECT b FROM Bodega b WHERE b.usuario = :usuario"),
    @NamedQuery(name = "Bodega.findByFecha", query = "SELECT b FROM Bodega b WHERE b.fecha = :fecha")})
public class Bodega implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idbodega")
    private Integer idbodega;
    @Basic(optional = false)
    @Column(name = "bodega")
    private String bodega;
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "id_depto")
    private int idDepto;
    @Basic(optional = false)
    @Column(name = "id_munic")
    private int idMunic;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "departamento_iddepartamento", referencedColumnName = "iddepartamento")
    @ManyToOne(optional = false)
    private Departamento departamentoIddepartamento;
    @JoinColumn(name = "municipios_idmunicipios", referencedColumnName = "idmunicipios")
    @ManyToOne(optional = false)
    private Municipios municipiosIdmunicipios;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bodegaIdbodega")
    private Collection<BodegaTransac> bodegaTransacCollection;

    public Bodega() {
    }

    public Bodega(Integer idbodega) {
        this.idbodega = idbodega;
    }

    public Bodega(Integer idbodega, String bodega, int idDepto, int idMunic) {
        this.idbodega = idbodega;
        this.bodega = bodega;
        this.idDepto = idDepto;
        this.idMunic = idMunic;
    }

    public Integer getIdbodega() {
        return idbodega;
    }

    public void setIdbodega(Integer idbodega) {
        this.idbodega = idbodega;
    }

    public String getBodega() {
        return bodega;
    }

    public void setBodega(String bodega) {
        this.bodega = bodega;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdDepto() {
        return idDepto;
    }

    public void setIdDepto(int idDepto) {
        this.idDepto = idDepto;
    }

    public int getIdMunic() {
        return idMunic;
    }

    public void setIdMunic(int idMunic) {
        this.idMunic = idMunic;
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

    public Departamento getDepartamentoIddepartamento() {
        return departamentoIddepartamento;
    }

    public void setDepartamentoIddepartamento(Departamento departamentoIddepartamento) {
        this.departamentoIddepartamento = departamentoIddepartamento;
    }

    public Municipios getMunicipiosIdmunicipios() {
        return municipiosIdmunicipios;
    }

    public void setMunicipiosIdmunicipios(Municipios municipiosIdmunicipios) {
        this.municipiosIdmunicipios = municipiosIdmunicipios;
    }

    @XmlTransient
    public Collection<BodegaTransac> getBodegaTransacCollection() {
        return bodegaTransacCollection;
    }

    public void setBodegaTransacCollection(Collection<BodegaTransac> bodegaTransacCollection) {
        this.bodegaTransacCollection = bodegaTransacCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbodega != null ? idbodega.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bodega)) {
            return false;
        }
        Bodega other = (Bodega) object;
        if ((this.idbodega == null && other.idbodega != null) || (this.idbodega != null && !this.idbodega.equals(other.idbodega))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.orm.activosorm.Bodega[ idbodega=" + idbodega + " ]";
    }
    
}
