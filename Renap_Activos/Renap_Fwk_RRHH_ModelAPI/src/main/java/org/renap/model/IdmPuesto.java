/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.renap.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 *
 * @author 2703759290608
 */
@Entity
@Table(name = "IDM_PUESTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IdmPuesto.findAll", query = "SELECT i FROM IdmPuesto i"),
    @NamedQuery(name = "IdmPuesto.findById", query = "SELECT i FROM IdmPuesto i WHERE i.id = :id"),
    @NamedQuery(name = "IdmPuesto.findByNombrePuesto", query = "SELECT i FROM IdmPuesto i WHERE i.nombrePuesto = :nombrePuesto"),
    @NamedQuery(name = "IdmPuesto.findByDescripcion", query = "SELECT i FROM IdmPuesto i WHERE i.descripcion = :descripcion"),
    @NamedQuery(name = "IdmPuesto.findByTipoPuesto", query = "SELECT i FROM IdmPuesto i WHERE i.tipoPuesto = :tipoPuesto"),
    @NamedQuery(name = "IdmPuesto.findByRequiereUsuario", query = "SELECT i FROM IdmPuesto i WHERE i.requiereUsuario = :requiereUsuario"),
    @NamedQuery(name = "IdmPuesto.findByEstado", query = "SELECT i FROM IdmPuesto i WHERE i.estado = :estado"),
    @NamedQuery(name = "IdmPuesto.findByFechaIng", query = "SELECT i FROM IdmPuesto i WHERE i.fechaIng = :fechaIng"),
    @NamedQuery(name = "IdmPuesto.findByUsuarioIng", query = "SELECT i FROM IdmPuesto i WHERE i.usuarioIng = :usuarioIng")})
public class IdmPuesto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Size(max = 100)
    @Column(name = "NOMBRE_PUESTO")
    private String nombrePuesto;
    @Size(max = 100)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 10)
    @Column(name = "TIPO_PUESTO")
    private String tipoPuesto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "REQUIERE_USUARIO")
    private String requiereUsuario;
    @Size(max = 1)
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
    /*  @RestResource(exported = false)
     @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPuesto", fetch = FetchType.EAGER, orphanRemoval = true)
     private List<IdmPlaza> idmPlazaList;
     @RestResource(exported = false)
     @OneToMany(mappedBy = "idPuesto", fetch = FetchType.EAGER, orphanRemoval = true)
     private List<IdmCaracteristicas> idmCaracteristicasList;*/

    public IdmPuesto() {
    }

    public IdmPuesto(Long id) {
        this.id = id;
    }

    public IdmPuesto(Long id, String requiereUsuario, Date fechaIng) {
        this.id = id;
        this.requiereUsuario = requiereUsuario;
        this.fechaIng = fechaIng;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombrePuesto() {
        return nombrePuesto;
    }

    public void setNombrePuesto(String nombrePuesto) {
        this.nombrePuesto = nombrePuesto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoPuesto() {
        return tipoPuesto;
    }

    public void setTipoPuesto(String tipoPuesto) {
        this.tipoPuesto = tipoPuesto;
    }

    public String getRequiereUsuario() {
        return requiereUsuario;
    }

    public void setRequiereUsuario(String requiereUsuario) {
        this.requiereUsuario = requiereUsuario;
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
    /*
     @JsonIgnore
     public List<IdmPlaza> getIdmPlazaList() {
     return idmPlazaList;
     }

     public void setIdmPlazaList(List<IdmPlaza> idmPlazaList) {
     this.idmPlazaList = idmPlazaList;
     }

     @JsonIgnore
     public List<IdmCaracteristicas> getIdmCaracteristicasList() {
     return idmCaracteristicasList;
     }

     public void setIdmCaracteristicasList(List<IdmCaracteristicas> idmCaracteristicasList) {
     this.idmCaracteristicasList = idmCaracteristicasList;
     }
     */

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IdmPuesto)) {
            return false;
        }
        IdmPuesto other = (IdmPuesto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.model.IdmPuesto[ id=" + id + " ]";
    }

}
