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
@Table(name = "empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e"),
    @NamedQuery(name = "Empleado.findByIdempleado", query = "SELECT e FROM Empleado e WHERE e.idempleado = :idempleado"),
    @NamedQuery(name = "Empleado.findByCui", query = "SELECT e FROM Empleado e WHERE e.cui = :cui"),
    @NamedQuery(name = "Empleado.findByNombres", query = "SELECT e FROM Empleado e WHERE e.nombres = :nombres"),
    @NamedQuery(name = "Empleado.findByApellidos", query = "SELECT e FROM Empleado e WHERE e.apellidos = :apellidos"),
    @NamedQuery(name = "Empleado.findByNit", query = "SELECT e FROM Empleado e WHERE e.nit = :nit"),
    @NamedQuery(name = "Empleado.findByGafete", query = "SELECT e FROM Empleado e WHERE e.gafete = :gafete"),
    @NamedQuery(name = "Empleado.findByIdPuesto", query = "SELECT e FROM Empleado e WHERE e.idPuesto = :idPuesto"),
    @NamedQuery(name = "Empleado.findByFechaIngreso", query = "SELECT e FROM Empleado e WHERE e.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "Empleado.findByFechaBaja", query = "SELECT e FROM Empleado e WHERE e.fechaBaja = :fechaBaja"),
    @NamedQuery(name = "Empleado.findByEstado", query = "SELECT e FROM Empleado e WHERE e.estado = :estado"),
    @NamedQuery(name = "Empleado.findByUsuario", query = "SELECT e FROM Empleado e WHERE e.usuario = :usuario"),
    @NamedQuery(name = "Empleado.findByFecha", query = "SELECT e FROM Empleado e WHERE e.fecha = :fecha")})
public class Empleado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idempleado")
    private Integer idempleado;
    @Column(name = "cui")
    private String cui;
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "nit")
    private String nit;
    @Column(name = "gafete")
    private String gafete;
    @Column(name = "id_puesto")
    private Integer idPuesto;
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Column(name = "fecha_baja")
    @Temporal(TemporalType.DATE)
    private Date fechaBaja;
    @Column(name = "estado")
    private Character estado;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleadoIdempleado")
    private Collection<ActivoSolicitud> activoSolicitudCollection;
    @JoinColumn(name = "dependencia_iddependencia", referencedColumnName = "iddependencia")
    @ManyToOne(optional = false)
    private Dependencia dependenciaIddependencia;
    @JoinColumn(name = "empleado_puesto_idpuesto", referencedColumnName = "idpuesto")
    @ManyToOne(optional = false)
    private EmpleadoPuesto empleadoPuestoIdpuesto;
    @JoinColumn(name = "empleado_reglon_idempleado_reglon", referencedColumnName = "idempleado_reglon")
    @ManyToOne(optional = false)
    private EmpleadoReglon empleadoReglonIdempleadoReglon;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleadoIdempleado")
    private Collection<Tir> tirCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleadoIdempleado")
    private Collection<BodegaTransac> bodegaTransacCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleadoIdempleado")
    private Collection<EmpleadoActivoTransac> empleadoActivoTransacCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleadoIdempleado")
    private Collection<Operador> operadorCollection;

    public Empleado() {
    }

    public Empleado(Integer idempleado) {
        this.idempleado = idempleado;
    }

    public Integer getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(Integer idempleado) {
        this.idempleado = idempleado;
    }

    public String getCui() {
        return cui;
    }

    public void setCui(String cui) {
        this.cui = cui;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getGafete() {
        return gafete;
    }

    public void setGafete(String gafete) {
        this.gafete = gafete;
    }

    public Integer getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(Integer idPuesto) {
        this.idPuesto = idPuesto;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
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

    @XmlTransient
    public Collection<ActivoSolicitud> getActivoSolicitudCollection() {
        return activoSolicitudCollection;
    }

    public void setActivoSolicitudCollection(Collection<ActivoSolicitud> activoSolicitudCollection) {
        this.activoSolicitudCollection = activoSolicitudCollection;
    }

    public Dependencia getDependenciaIddependencia() {
        return dependenciaIddependencia;
    }

    public void setDependenciaIddependencia(Dependencia dependenciaIddependencia) {
        this.dependenciaIddependencia = dependenciaIddependencia;
    }

    public EmpleadoPuesto getEmpleadoPuestoIdpuesto() {
        return empleadoPuestoIdpuesto;
    }

    public void setEmpleadoPuestoIdpuesto(EmpleadoPuesto empleadoPuestoIdpuesto) {
        this.empleadoPuestoIdpuesto = empleadoPuestoIdpuesto;
    }

    public EmpleadoReglon getEmpleadoReglonIdempleadoReglon() {
        return empleadoReglonIdempleadoReglon;
    }

    public void setEmpleadoReglonIdempleadoReglon(EmpleadoReglon empleadoReglonIdempleadoReglon) {
        this.empleadoReglonIdempleadoReglon = empleadoReglonIdempleadoReglon;
    }

    @XmlTransient
    public Collection<Tir> getTirCollection() {
        return tirCollection;
    }

    public void setTirCollection(Collection<Tir> tirCollection) {
        this.tirCollection = tirCollection;
    }

    @XmlTransient
    public Collection<BodegaTransac> getBodegaTransacCollection() {
        return bodegaTransacCollection;
    }

    public void setBodegaTransacCollection(Collection<BodegaTransac> bodegaTransacCollection) {
        this.bodegaTransacCollection = bodegaTransacCollection;
    }

    @XmlTransient
    public Collection<EmpleadoActivoTransac> getEmpleadoActivoTransacCollection() {
        return empleadoActivoTransacCollection;
    }

    public void setEmpleadoActivoTransacCollection(Collection<EmpleadoActivoTransac> empleadoActivoTransacCollection) {
        this.empleadoActivoTransacCollection = empleadoActivoTransacCollection;
    }

    @XmlTransient
    public Collection<Operador> getOperadorCollection() {
        return operadorCollection;
    }

    public void setOperadorCollection(Collection<Operador> operadorCollection) {
        this.operadorCollection = operadorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idempleado != null ? idempleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.idempleado == null && other.idempleado != null) || (this.idempleado != null && !this.idempleado.equals(other.idempleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.orm.activosorm.Empleado[ idempleado=" + idempleado + " ]";
    }
    
}
