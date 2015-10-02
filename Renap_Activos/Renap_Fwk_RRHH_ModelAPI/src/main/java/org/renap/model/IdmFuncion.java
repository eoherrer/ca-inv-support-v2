/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.renap.model;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "IDM_FUNCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IdmFuncion.findAll", query = "SELECT i FROM IdmFuncion i"),
    @NamedQuery(name = "IdmFuncion.findById", query = "SELECT i FROM IdmFuncion i WHERE i.id = :id"),
    @NamedQuery(name = "IdmFuncion.findByNombre", query = "SELECT i FROM IdmFuncion i WHERE i.nombre = :nombre"),
    @NamedQuery(name = "IdmFuncion.findByTipo", query = "SELECT i FROM IdmFuncion i WHERE i.tipo = :tipo"),
    @NamedQuery(name = "IdmFuncion.findByScript", query = "SELECT i FROM IdmFuncion i WHERE i.script = :script"),
    @NamedQuery(name = "IdmFuncion.findByImagen", query = "SELECT i FROM IdmFuncion i WHERE i.imagen = :imagen"),
    @NamedQuery(name = "IdmFuncion.findByEstado", query = "SELECT i FROM IdmFuncion i WHERE i.estado = :estado"),
    @NamedQuery(name = "IdmFuncion.findByFechaIng", query = "SELECT i FROM IdmFuncion i WHERE i.fechaIng = :fechaIng"),
    @NamedQuery(name = "IdmFuncion.findByUsuarioIng", query = "SELECT i FROM IdmFuncion i WHERE i.usuarioIng = :usuarioIng")})
public class IdmFuncion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Size(max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "TIPO")
    private BigInteger tipo;
    @Size(max = 100)
    @Column(name = "SCRIPT")
    private String script;
    @Size(max = 200)
    @Column(name = "IMAGEN")
    private String imagen;
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
    @OneToMany(mappedBy = "idFuncionPadre", fetch = FetchType.EAGER)
    private List<IdmFuncion> idmFuncionList;
    @JoinColumn(name = "ID_FUNCION_PADRE", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private IdmFuncion idFuncionPadre;

    public IdmFuncion() {
    }

    public IdmFuncion(Long id) {
        this.id = id;
    }

    public IdmFuncion(Long id, String estado, Date fechaIng) {
        this.id = id;
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

    public BigInteger getTipo() {
        return tipo;
    }

    public void setTipo(BigInteger tipo) {
        this.tipo = tipo;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
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

    @XmlTransient
    public List<IdmFuncion> getIdmFuncionList() {
        return idmFuncionList;
    }

    public void setIdmFuncionList(List<IdmFuncion> idmFuncionList) {
        this.idmFuncionList = idmFuncionList;
    }

    public IdmFuncion getIdFuncionPadre() {
        return idFuncionPadre;
    }

    public void setIdFuncionPadre(IdmFuncion idFuncionPadre) {
        this.idFuncionPadre = idFuncionPadre;
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
        if (!(object instanceof IdmFuncion)) {
            return false;
        }
        IdmFuncion other = (IdmFuncion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.model.IdmFuncion[ id=" + id + " ]";
    }
    
}
