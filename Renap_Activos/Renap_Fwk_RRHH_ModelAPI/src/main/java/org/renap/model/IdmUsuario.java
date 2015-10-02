/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.renap.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 2703759290608
 */
@Entity
@Table(name = "IDM_USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IdmUsuario.findAll", query = "SELECT i FROM IdmUsuario i"),
    @NamedQuery(name = "IdmUsuario.findById", query = "SELECT i FROM IdmUsuario i WHERE i.id = :id"),
    @NamedQuery(name = "IdmUsuario.findByUsername", query = "SELECT i FROM IdmUsuario i WHERE i.username = :username"),
    @NamedQuery(name = "IdmUsuario.findByPassword", query = "SELECT i FROM IdmUsuario i WHERE i.password = :password"),
    @NamedQuery(name = "IdmUsuario.findByIdEmpleado", query = "SELECT i FROM IdmUsuario i WHERE i.idEmpleado = :idEmpleado"),
    @NamedQuery(name = "IdmUsuario.findByEstado", query = "SELECT i FROM IdmUsuario i WHERE i.estado = :estado"),
    @NamedQuery(name = "IdmUsuario.findByFechaIng", query = "SELECT i FROM IdmUsuario i WHERE i.fechaIng = :fechaIng"),
    @NamedQuery(name = "IdmUsuario.findByUsuarioIng", query = "SELECT i FROM IdmUsuario i WHERE i.usuarioIng = :usuarioIng")})
public class IdmUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "ID_EMPLEADO")
    private BigInteger idEmpleado;
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

    public IdmUsuario() {
    }

    public IdmUsuario(Long id) {
        this.id = id;
    }

    public IdmUsuario(Long id, String username, String password, String estado, Date fechaIng) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.estado = estado;
        this.fechaIng = fechaIng;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigInteger getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(BigInteger idEmpleado) {
        this.idEmpleado = idEmpleado;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IdmUsuario)) {
            return false;
        }
        IdmUsuario other = (IdmUsuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.model.IdmUsuario[ id=" + id + " ]";
    }
    
}
