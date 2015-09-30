/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.renap.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 1808236120101
 */
@Entity
@Table(name = "activo_informatica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActivoInformatica.findAll", query = "SELECT a FROM ActivoInformatica a"),
    @NamedQuery(name = "ActivoInformatica.findById", query = "SELECT a FROM ActivoInformatica a WHERE a.id = :id"),
    @NamedQuery(name = "ActivoInformatica.findByCui", query = "SELECT a FROM ActivoInformatica a WHERE a.cui = :cui"),
    @NamedQuery(name = "ActivoInformatica.findByDepartamento", query = "SELECT a FROM ActivoInformatica a WHERE a.departamento = :departamento"),
    @NamedQuery(name = "ActivoInformatica.findByPerfilUsuario", query = "SELECT a FROM ActivoInformatica a WHERE a.perfilUsuario = :perfilUsuario"),
    @NamedQuery(name = "ActivoInformatica.findByPuesto", query = "SELECT a FROM ActivoInformatica a WHERE a.puesto = :puesto"),
    @NamedQuery(name = "ActivoInformatica.findByNombreUsuario", query = "SELECT a FROM ActivoInformatica a WHERE a.nombreUsuario = :nombreUsuario"),
    @NamedQuery(name = "ActivoInformatica.findByOficina", query = "SELECT a FROM ActivoInformatica a WHERE a.oficina = :oficina"),
    @NamedQuery(name = "ActivoInformatica.findByNombreEquipo", query = "SELECT a FROM ActivoInformatica a WHERE a.nombreEquipo = :nombreEquipo"),
    @NamedQuery(name = "ActivoInformatica.findByIp", query = "SELECT a FROM ActivoInformatica a WHERE a.ip = :ip"),
    @NamedQuery(name = "ActivoInformatica.findByTipoEquipo", query = "SELECT a FROM ActivoInformatica a WHERE a.tipoEquipo = :tipoEquipo")})
public class ActivoInformatica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "cui")
    private String cui;
    @Column(name = "departamento")
    private String departamento;
    @Column(name = "perfil_usuario")
    private String perfilUsuario;
    @Column(name = "puesto")
    private String puesto;
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    @Column(name = "oficina")
    private String oficina;
    @Column(name = "nombre_equipo")
    private String nombreEquipo;
    @Column(name = "ip")
    private String ip;
    @Column(name = "tipo_equipo")
    private String tipoEquipo;

    public ActivoInformatica() {
    }

    public ActivoInformatica(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCui() {
        return cui;
    }

    public void setCui(String cui) {
        this.cui = cui;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getPerfilUsuario() {
        return perfilUsuario;
    }

    public void setPerfilUsuario(String perfilUsuario) {
        this.perfilUsuario = perfilUsuario;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getOficina() {
        return oficina;
    }

    public void setOficina(String oficina) {
        this.oficina = oficina;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getTipoEquipo() {
        return tipoEquipo;
    }

    public void setTipoEquipo(String tipoEquipo) {
        this.tipoEquipo = tipoEquipo;
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
        if (!(object instanceof ActivoInformatica)) {
            return false;
        }
        ActivoInformatica other = (ActivoInformatica) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.orm.activosorm.ActivoInformatica[ id=" + id + " ]";
    }
    
}
