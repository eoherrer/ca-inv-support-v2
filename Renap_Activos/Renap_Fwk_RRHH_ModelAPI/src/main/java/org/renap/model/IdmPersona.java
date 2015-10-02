/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.renap.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "IDM_PERSONA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IdmPersona.findAll", query = "SELECT i FROM IdmPersona i"),
    @NamedQuery(name = "IdmPersona.findById", query = "SELECT i FROM IdmPersona i WHERE i.id = :id"),
    @NamedQuery(name = "IdmPersona.findByCui", query = "SELECT i FROM IdmPersona i WHERE i.cui = :cui"),
    @NamedQuery(name = "IdmPersona.findByPrimerNombre", query = "SELECT i FROM IdmPersona i WHERE i.primerNombre = :primerNombre"),
    @NamedQuery(name = "IdmPersona.findBySegundoNombre", query = "SELECT i FROM IdmPersona i WHERE i.segundoNombre = :segundoNombre"),
    @NamedQuery(name = "IdmPersona.findByTercerNombre", query = "SELECT i FROM IdmPersona i WHERE i.tercerNombre = :tercerNombre"),
    @NamedQuery(name = "IdmPersona.findByPrimerApellido", query = "SELECT i FROM IdmPersona i WHERE i.primerApellido = :primerApellido"),
    @NamedQuery(name = "IdmPersona.findBySegundoApellido", query = "SELECT i FROM IdmPersona i WHERE i.segundoApellido = :segundoApellido"),
    @NamedQuery(name = "IdmPersona.findByApellidoCasada", query = "SELECT i FROM IdmPersona i WHERE i.apellidoCasada = :apellidoCasada"),
    @NamedQuery(name = "IdmPersona.findByDomicilio", query = "SELECT i FROM IdmPersona i WHERE i.domicilio = :domicilio"),
    @NamedQuery(name = "IdmPersona.findByTelefono", query = "SELECT i FROM IdmPersona i WHERE i.telefono = :telefono"),
    @NamedQuery(name = "IdmPersona.findByCelular", query = "SELECT i FROM IdmPersona i WHERE i.celular = :celular"),
    @NamedQuery(name = "IdmPersona.findByCorreoElectronico", query = "SELECT i FROM IdmPersona i WHERE i.correoElectronico = :correoElectronico"),
    @NamedQuery(name = "IdmPersona.findByNit", query = "SELECT i FROM IdmPersona i WHERE i.nit = :nit"),
    @NamedQuery(name = "IdmPersona.findByEstado", query = "SELECT i FROM IdmPersona i WHERE i.estado = :estado"),
    @NamedQuery(name = "IdmPersona.findByFechaIng", query = "SELECT i FROM IdmPersona i WHERE i.fechaIng = :fechaIng"),
    @NamedQuery(name = "IdmPersona.findByUsuarioIng", query = "SELECT i FROM IdmPersona i WHERE i.usuarioIng = :usuarioIng"),
    @NamedQuery(name = "IdmPersona.findByFechaAct", query = "SELECT i FROM IdmPersona i WHERE i.fechaAct = :fechaAct"),
    @NamedQuery(name = "IdmPersona.findByUsuarioAct", query = "SELECT i FROM IdmPersona i WHERE i.usuarioAct = :usuarioAct")})
public class IdmPersona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Size(max = 50)
    @Column(name = "CUI")
    private String cui;
    @Size(max = 50)
    @Column(name = "PRIMER_NOMBRE")
    private String primerNombre;
    @Size(max = 50)
    @Column(name = "SEGUNDO_NOMBRE")
    private String segundoNombre;
    @Size(max = 50)
    @Column(name = "TERCER_NOMBRE")
    private String tercerNombre;
    @Size(max = 50)
    @Column(name = "PRIMER_APELLIDO")
    private String primerApellido;
    @Size(max = 50)
    @Column(name = "SEGUNDO_APELLIDO")
    private String segundoApellido;
    @Size(max = 50)
    @Column(name = "APELLIDO_CASADA")
    private String apellidoCasada;
    @Size(max = 100)
    @Column(name = "DOMICILIO")
    private String domicilio;
    @Column(name = "TELEFONO")
    private Long telefono;
    @Column(name = "CELULAR")
    private Long celular;
    @Lob
    @Column(name = "FOTO")
    private String foto;
    @Size(max = 50)
    @Column(name = "CORREO_ELECTRONICO")
    private String correoElectronico;
    @Size(max = 20)
    @Column(name = "NIT")
    private String nit;
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
    @Column(name = "FECHA_ACT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAct;
    @Size(max = 20)
    @Column(name = "USUARIO_ACT")
    private String usuarioAct;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona", fetch = FetchType.EAGER)
    private List<IdmEmpleado> idmEmpleadoList;

    public IdmPersona() {
    }

    public IdmPersona(Long id) {
        this.id = id;
    }

    public IdmPersona(Long id, String estado, Date fechaIng) {
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

    public String getCui() {
        return cui;
    }

    public void setCui(String cui) {
        this.cui = cui;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getTercerNombre() {
        return tercerNombre;
    }

    public void setTercerNombre(String tercerNombre) {
        this.tercerNombre = tercerNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getApellidoCasada() {
        return apellidoCasada;
    }

    public void setApellidoCasada(String apellidoCasada) {
        this.apellidoCasada = apellidoCasada;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public Long getCelular() {
        return celular;
    }

    public void setCelular(Long celular) {
        this.celular = celular;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
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

    public Date getFechaAct() {
        return fechaAct;
    }

    public void setFechaAct(Date fechaAct) {
        this.fechaAct = fechaAct;
    }

    public String getUsuarioAct() {
        return usuarioAct;
    }

    public void setUsuarioAct(String usuarioAct) {
        this.usuarioAct = usuarioAct;
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
        if (!(object instanceof IdmPersona)) {
            return false;
        }
        IdmPersona other = (IdmPersona) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.model.IdmPersona[ id=" + id + " ]";
    }
    
}
