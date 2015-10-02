/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.renap.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 *
 * @author 2703759290608
 */
@Entity
@Table(name = "IDM_RENGLON")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IdmRenglon.findAll", query = "SELECT i FROM IdmRenglon i"),
    @NamedQuery(name = "IdmRenglon.findById", query = "SELECT i FROM IdmRenglon i WHERE i.id = :id"),
    @NamedQuery(name = "IdmRenglon.findByNumeroRenglon", query = "SELECT i FROM IdmRenglon i WHERE i.numeroRenglon = :numeroRenglon"),
    @NamedQuery(name = "IdmRenglon.findByDescripcion", query = "SELECT i FROM IdmRenglon i WHERE i.descripcion = :descripcion"),
    @NamedQuery(name = "IdmRenglon.findByEstado", query = "SELECT i FROM IdmRenglon i WHERE i.estado = :estado")})
public class IdmRenglon implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "NUMERO_RENGLON")
    private String numeroRenglon;
    @Size(max = 100)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ESTADO")
    private String estado;
    @OneToMany(mappedBy = "idRenglon", fetch = FetchType.EAGER)
    @RestResource(exported = false)
    private List<IdmPlaza> idmPlazaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRenglon", fetch = FetchType.EAGER)
    @RestResource(exported = false)
    private List<IdmContrato> idmContratoList;

    public IdmRenglon() {
    }

    public IdmRenglon(Integer id) {
        this.id = id;
    }

    public IdmRenglon(Integer id, String numeroRenglon, String estado) {
        this.id = id;
        this.numeroRenglon = numeroRenglon;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroRenglon() {
        return numeroRenglon;
    }

    public void setNumeroRenglon(String numeroRenglon) {
        this.numeroRenglon = numeroRenglon;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<IdmPlaza> getIdmPlazaList() {
        return idmPlazaList;
    }

    public void setIdmPlazaList(List<IdmPlaza> idmPlazaList) {
        this.idmPlazaList = idmPlazaList;
    }

    @XmlTransient
    public List<IdmContrato> getIdmContratoList() {
        return idmContratoList;
    }

    public void setIdmContratoList(List<IdmContrato> idmContratoList) {
        this.idmContratoList = idmContratoList;
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
        if (!(object instanceof IdmRenglon)) {
            return false;
        }
        IdmRenglon other = (IdmRenglon) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.model.IdmRenglon[ id=" + id + " ]";
    }
    
}
