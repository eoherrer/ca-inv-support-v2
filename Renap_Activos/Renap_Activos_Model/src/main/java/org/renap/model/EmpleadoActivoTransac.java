/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.renap.model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 1808236120101
 */
@Entity
@Table(name = "empleado_activo_transac")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmpleadoActivoTransac.findAll", query = "SELECT e FROM EmpleadoActivoTransac e"),
    @NamedQuery(name = "EmpleadoActivoTransac.findByIdempleadoTransac", query = "SELECT e FROM EmpleadoActivoTransac e WHERE e.idempleadoTransac = :idempleadoTransac"),
    @NamedQuery(name = "EmpleadoActivoTransac.findByCuiEmpleado", query = "SELECT e FROM EmpleadoActivoTransac e WHERE e.cuiEmpleado = :cuiEmpleado"),
    @NamedQuery(name = "EmpleadoActivoTransac.findByTipoMovimiento", query = "SELECT e FROM EmpleadoActivoTransac e WHERE e.tipoMovimiento = :tipoMovimiento"),
    @NamedQuery(name = "EmpleadoActivoTransac.findByIdactivo", query = "SELECT e FROM EmpleadoActivoTransac e WHERE e.idactivo = :idactivo"),
    @NamedQuery(name = "EmpleadoActivoTransac.findByEmpleadoTransaccol", query = "SELECT e FROM EmpleadoActivoTransac e WHERE e.empleadoTransaccol = :empleadoTransaccol")})
public class EmpleadoActivoTransac implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idempleado_transac")
    private Long idempleadoTransac;
    @Column(name = "cui_empleado")
    private String cuiEmpleado;
    @Column(name = "tipo_movimiento")
    private String tipoMovimiento;
    @Column(name = "idactivo")
    private BigInteger idactivo;
    @Column(name = "empleado_transaccol")
    private String empleadoTransaccol;
    @JoinColumn(name = "empleado_idempleado", referencedColumnName = "idempleado")
    @ManyToOne(optional = false)
    private Empleado empleadoIdempleado;

    public EmpleadoActivoTransac() {
    }

    public EmpleadoActivoTransac(Long idempleadoTransac) {
        this.idempleadoTransac = idempleadoTransac;
    }

    public Long getIdempleadoTransac() {
        return idempleadoTransac;
    }

    public void setIdempleadoTransac(Long idempleadoTransac) {
        this.idempleadoTransac = idempleadoTransac;
    }

    public String getCuiEmpleado() {
        return cuiEmpleado;
    }

    public void setCuiEmpleado(String cuiEmpleado) {
        this.cuiEmpleado = cuiEmpleado;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public BigInteger getIdactivo() {
        return idactivo;
    }

    public void setIdactivo(BigInteger idactivo) {
        this.idactivo = idactivo;
    }

    public String getEmpleadoTransaccol() {
        return empleadoTransaccol;
    }

    public void setEmpleadoTransaccol(String empleadoTransaccol) {
        this.empleadoTransaccol = empleadoTransaccol;
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
        hash += (idempleadoTransac != null ? idempleadoTransac.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpleadoActivoTransac)) {
            return false;
        }
        EmpleadoActivoTransac other = (EmpleadoActivoTransac) object;
        if ((this.idempleadoTransac == null && other.idempleadoTransac != null) || (this.idempleadoTransac != null && !this.idempleadoTransac.equals(other.idempleadoTransac))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.orm.activosorm.EmpleadoActivoTransac[ idempleadoTransac=" + idempleadoTransac + " ]";
    }
    
}
