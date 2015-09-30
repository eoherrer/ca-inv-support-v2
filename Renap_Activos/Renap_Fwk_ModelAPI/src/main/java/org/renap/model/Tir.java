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
@Table(name = "tir")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tir.findAll", query = "SELECT t FROM Tir t"),
    @NamedQuery(name = "Tir.findByIdtir", query = "SELECT t FROM Tir t WHERE t.idtir = :idtir"),
    @NamedQuery(name = "Tir.findByUsoForma", query = "SELECT t FROM Tir t WHERE t.usoForma = :usoForma"),
    @NamedQuery(name = "Tir.findByNoForma", query = "SELECT t FROM Tir t WHERE t.noForma = :noForma"),
    @NamedQuery(name = "Tir.findByFechaReg", query = "SELECT t FROM Tir t WHERE t.fechaReg = :fechaReg"),
    @NamedQuery(name = "Tir.findByIdOpSol", query = "SELECT t FROM Tir t WHERE t.idOpSol = :idOpSol"),
    @NamedQuery(name = "Tir.findByIdEmpleado", query = "SELECT t FROM Tir t WHERE t.idEmpleado = :idEmpleado"),
    @NamedQuery(name = "Tir.findByIdCondicion", query = "SELECT t FROM Tir t WHERE t.idCondicion = :idCondicion"),
    @NamedQuery(name = "Tir.findByIdEstatus", query = "SELECT t FROM Tir t WHERE t.idEstatus = :idEstatus"),
    @NamedQuery(name = "Tir.findByObservaciones", query = "SELECT t FROM Tir t WHERE t.observaciones = :observaciones"),
    @NamedQuery(name = "Tir.findBySedeUnidad", query = "SELECT t FROM Tir t WHERE t.sedeUnidad = :sedeUnidad"),
    @NamedQuery(name = "Tir.findByIdDep", query = "SELECT t FROM Tir t WHERE t.idDep = :idDep"),
    @NamedQuery(name = "Tir.findByImpresoPor", query = "SELECT t FROM Tir t WHERE t.impresoPor = :impresoPor"),
    @NamedQuery(name = "Tir.findByIdEmpImprime", query = "SELECT t FROM Tir t WHERE t.idEmpImprime = :idEmpImprime"),
    @NamedQuery(name = "Tir.findByFechaImpresion", query = "SELECT t FROM Tir t WHERE t.fechaImpresion = :fechaImpresion"),
    @NamedQuery(name = "Tir.findByTomo", query = "SELECT t FROM Tir t WHERE t.tomo = :tomo"),
    @NamedQuery(name = "Tir.findByIdEmpArchiva", query = "SELECT t FROM Tir t WHERE t.idEmpArchiva = :idEmpArchiva"),
    @NamedQuery(name = "Tir.findByUsuario", query = "SELECT t FROM Tir t WHERE t.usuario = :usuario"),
    @NamedQuery(name = "Tir.findByFecha", query = "SELECT t FROM Tir t WHERE t.fecha = :fecha")})
public class Tir implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtir")
    private Integer idtir;
    @Column(name = "uso_forma")
    private String usoForma;
    @Column(name = "no_forma")
    private String noForma;
    @Column(name = "fecha_reg")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaReg;
    @Column(name = "id_op_sol")
    private Integer idOpSol;
    @Column(name = "id_empleado")
    private Integer idEmpleado;
    @Column(name = "id_condicion")
    private Integer idCondicion;
    @Column(name = "id_estatus")
    private Integer idEstatus;
    @Column(name = "observaciones")
    private String observaciones;
    @Column(name = "sede_unidad")
    private String sedeUnidad;
    @Column(name = "id_dep")
    private Integer idDep;
    @Column(name = "impreso_por")
    private String impresoPor;
    @Column(name = "id_emp_imprime")
    private Integer idEmpImprime;
    @Column(name = "fecha_impresion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaImpresion;
    @Column(name = "tomo")
    private String tomo;
    @Column(name = "id_emp_archiva")
    private Integer idEmpArchiva;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "empleado_idempleado", referencedColumnName = "idempleado")
    @ManyToOne(optional = false)
    private Empleado empleadoIdempleado;
    @JoinColumn(name = "tir_condicion_idtir_condicion", referencedColumnName = "idtir_condicion")
    @ManyToOne(optional = false)
    private TirCondicion tirCondicionIdtirCondicion;
    @JoinColumn(name = "tir_estatus_idtir_estatus", referencedColumnName = "idtir_estatus")
    @ManyToOne(optional = false)
    private TirEstatus tirEstatusIdtirEstatus;
    @JoinColumn(name = "tir_uso_idtir_uso", referencedColumnName = "idtir_uso")
    @ManyToOne(optional = false)
    private TirUso tirUsoIdtirUso;

    public Tir() {
    }

    public Tir(Integer idtir) {
        this.idtir = idtir;
    }

    public Integer getIdtir() {
        return idtir;
    }

    public void setIdtir(Integer idtir) {
        this.idtir = idtir;
    }

    public String getUsoForma() {
        return usoForma;
    }

    public void setUsoForma(String usoForma) {
        this.usoForma = usoForma;
    }

    public String getNoForma() {
        return noForma;
    }

    public void setNoForma(String noForma) {
        this.noForma = noForma;
    }

    public Date getFechaReg() {
        return fechaReg;
    }

    public void setFechaReg(Date fechaReg) {
        this.fechaReg = fechaReg;
    }

    public Integer getIdOpSol() {
        return idOpSol;
    }

    public void setIdOpSol(Integer idOpSol) {
        this.idOpSol = idOpSol;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Integer getIdCondicion() {
        return idCondicion;
    }

    public void setIdCondicion(Integer idCondicion) {
        this.idCondicion = idCondicion;
    }

    public Integer getIdEstatus() {
        return idEstatus;
    }

    public void setIdEstatus(Integer idEstatus) {
        this.idEstatus = idEstatus;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getSedeUnidad() {
        return sedeUnidad;
    }

    public void setSedeUnidad(String sedeUnidad) {
        this.sedeUnidad = sedeUnidad;
    }

    public Integer getIdDep() {
        return idDep;
    }

    public void setIdDep(Integer idDep) {
        this.idDep = idDep;
    }

    public String getImpresoPor() {
        return impresoPor;
    }

    public void setImpresoPor(String impresoPor) {
        this.impresoPor = impresoPor;
    }

    public Integer getIdEmpImprime() {
        return idEmpImprime;
    }

    public void setIdEmpImprime(Integer idEmpImprime) {
        this.idEmpImprime = idEmpImprime;
    }

    public Date getFechaImpresion() {
        return fechaImpresion;
    }

    public void setFechaImpresion(Date fechaImpresion) {
        this.fechaImpresion = fechaImpresion;
    }

    public String getTomo() {
        return tomo;
    }

    public void setTomo(String tomo) {
        this.tomo = tomo;
    }

    public Integer getIdEmpArchiva() {
        return idEmpArchiva;
    }

    public void setIdEmpArchiva(Integer idEmpArchiva) {
        this.idEmpArchiva = idEmpArchiva;
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

    public TirCondicion getTirCondicionIdtirCondicion() {
        return tirCondicionIdtirCondicion;
    }

    public void setTirCondicionIdtirCondicion(TirCondicion tirCondicionIdtirCondicion) {
        this.tirCondicionIdtirCondicion = tirCondicionIdtirCondicion;
    }

    public TirEstatus getTirEstatusIdtirEstatus() {
        return tirEstatusIdtirEstatus;
    }

    public void setTirEstatusIdtirEstatus(TirEstatus tirEstatusIdtirEstatus) {
        this.tirEstatusIdtirEstatus = tirEstatusIdtirEstatus;
    }

    public TirUso getTirUsoIdtirUso() {
        return tirUsoIdtirUso;
    }

    public void setTirUsoIdtirUso(TirUso tirUsoIdtirUso) {
        this.tirUsoIdtirUso = tirUsoIdtirUso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtir != null ? idtir.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tir)) {
            return false;
        }
        Tir other = (Tir) object;
        if ((this.idtir == null && other.idtir != null) || (this.idtir != null && !this.idtir.equals(other.idtir))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.orm.activosorm.Tir[ idtir=" + idtir + " ]";
    }
    
}
