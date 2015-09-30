/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.renap.model;

import java.io.Serializable;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 1808236120101
 */
@Entity
@Table(name = "municipios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Municipios.findAll", query = "SELECT m FROM Municipios m"),
    @NamedQuery(name = "Municipios.findByIdmunicipios", query = "SELECT m FROM Municipios m WHERE m.idmunicipios = :idmunicipios"),
    @NamedQuery(name = "Municipios.findByNombre", query = "SELECT m FROM Municipios m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "Municipios.findByCodMuni", query = "SELECT m FROM Municipios m WHERE m.codMuni = :codMuni"),
    @NamedQuery(name = "Municipios.findByIdDepto", query = "SELECT m FROM Municipios m WHERE m.idDepto = :idDepto")})
public class Municipios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmunicipios")
    private Integer idmunicipios;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "cod_muni")
    private String codMuni;
    @Column(name = "id_depto")
    private Integer idDepto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "municipiosIdmunicipios")
    private Collection<Bodega> bodegaCollection;

    public Municipios() {
    }

    public Municipios(Integer idmunicipios) {
        this.idmunicipios = idmunicipios;
    }

    public Integer getIdmunicipios() {
        return idmunicipios;
    }

    public void setIdmunicipios(Integer idmunicipios) {
        this.idmunicipios = idmunicipios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodMuni() {
        return codMuni;
    }

    public void setCodMuni(String codMuni) {
        this.codMuni = codMuni;
    }

    public Integer getIdDepto() {
        return idDepto;
    }

    public void setIdDepto(Integer idDepto) {
        this.idDepto = idDepto;
    }

    @XmlTransient
    public Collection<Bodega> getBodegaCollection() {
        return bodegaCollection;
    }

    public void setBodegaCollection(Collection<Bodega> bodegaCollection) {
        this.bodegaCollection = bodegaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmunicipios != null ? idmunicipios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipios)) {
            return false;
        }
        Municipios other = (Municipios) object;
        if ((this.idmunicipios == null && other.idmunicipios != null) || (this.idmunicipios != null && !this.idmunicipios.equals(other.idmunicipios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.orm.activosorm.Municipios[ idmunicipios=" + idmunicipios + " ]";
    }
    
}
