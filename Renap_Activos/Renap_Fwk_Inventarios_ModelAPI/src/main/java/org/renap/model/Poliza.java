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
@Table(name = "poliza")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Poliza.findAll", query = "SELECT p FROM Poliza p"),
    @NamedQuery(name = "Poliza.findByIdpoliza", query = "SELECT p FROM Poliza p WHERE p.idpoliza = :idpoliza"),
    @NamedQuery(name = "Poliza.findByNumero", query = "SELECT p FROM Poliza p WHERE p.numero = :numero"),
    @NamedQuery(name = "Poliza.findByCertificado", query = "SELECT p FROM Poliza p WHERE p.certificado = :certificado"),
    @NamedQuery(name = "Poliza.findByNombre", query = "SELECT p FROM Poliza p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Poliza.findByAseguradora", query = "SELECT p FROM Poliza p WHERE p.aseguradora = :aseguradora"),
    @NamedQuery(name = "Poliza.findByUsuario", query = "SELECT p FROM Poliza p WHERE p.usuario = :usuario"),
    @NamedQuery(name = "Poliza.findByFecha", query = "SELECT p FROM Poliza p WHERE p.fecha = :fecha")})
public class Poliza implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpoliza")
    private Integer idpoliza;
    @Column(name = "numero")
    private String numero;
    @Column(name = "certificado")
    private String certificado;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "aseguradora")
    private String aseguradora;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    public Poliza() {
    }

    public Poliza(Integer idpoliza) {
        this.idpoliza = idpoliza;
    }

    public Integer getIdpoliza() {
        return idpoliza;
    }

    public void setIdpoliza(Integer idpoliza) {
        this.idpoliza = idpoliza;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCertificado() {
        return certificado;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAseguradora() {
        return aseguradora;
    }

    public void setAseguradora(String aseguradora) {
        this.aseguradora = aseguradora;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpoliza != null ? idpoliza.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Poliza)) {
            return false;
        }
        Poliza other = (Poliza) object;
        if ((this.idpoliza == null && other.idpoliza != null) || (this.idpoliza != null && !this.idpoliza.equals(other.idpoliza))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.orm.activosorm.Poliza[ idpoliza=" + idpoliza + " ]";
    }
    
}
