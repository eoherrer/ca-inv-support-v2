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
@Table(name = "operador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Operador.findAll", query = "SELECT o FROM Operador o"),
    @NamedQuery(name = "Operador.findByIdoperador", query = "SELECT o FROM Operador o WHERE o.idoperador = :idoperador"),
    @NamedQuery(name = "Operador.findByIdEmpleado", query = "SELECT o FROM Operador o WHERE o.idEmpleado = :idEmpleado"),
    @NamedQuery(name = "Operador.findByCui", query = "SELECT o FROM Operador o WHERE o.cui = :cui"),
    @NamedQuery(name = "Operador.findByTipo", query = "SELECT o FROM Operador o WHERE o.tipo = :tipo"),
    @NamedQuery(name = "Operador.findByUsuario", query = "SELECT o FROM Operador o WHERE o.usuario = :usuario"),
    @NamedQuery(name = "Operador.findByFecha", query = "SELECT o FROM Operador o WHERE o.fecha = :fecha")})
public class Operador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idoperador")
    private Integer idoperador;
    @Basic(optional = false)
    @Column(name = "id_empleado")
    private int idEmpleado;
    @Basic(optional = false)
    @Column(name = "cui")
    private String cui;
    @Basic(optional = false)
    @Column(name = "tipo")
    private Character tipo;
    @Basic(optional = false)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "empleado_idempleado", referencedColumnName = "idempleado")
    @ManyToOne(optional = false)
    private Empleado empleadoIdempleado;

    public Operador() {
    }

    public Operador(Integer idoperador) {
        this.idoperador = idoperador;
    }

    public Operador(Integer idoperador, int idEmpleado, String cui, Character tipo, String usuario, Date fecha) {
        this.idoperador = idoperador;
        this.idEmpleado = idEmpleado;
        this.cui = cui;
        this.tipo = tipo;
        this.usuario = usuario;
        this.fecha = fecha;
    }

    public Integer getIdoperador() {
        return idoperador;
    }

    public void setIdoperador(Integer idoperador) {
        this.idoperador = idoperador;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getCui() {
        return cui;
    }

    public void setCui(String cui) {
        this.cui = cui;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
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

    public Empleado getEmpleadoIdempleado() {
        return empleadoIdempleado;
    }

    public void setEmpleadoIdempleado(Empleado empleadoIdempleado) {
        this.empleadoIdempleado = empleadoIdempleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idoperador != null ? idoperador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operador)) {
            return false;
        }
        Operador other = (Operador) object;
        if ((this.idoperador == null && other.idoperador != null) || (this.idoperador != null && !this.idoperador.equals(other.idoperador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.orm.activosorm.Operador[ idoperador=" + idoperador + " ]";
    }
    
}
