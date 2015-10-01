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
@Table(name = "activo_transac")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActivoTransac.findAll", query = "SELECT a FROM ActivoTransac a"),
    @NamedQuery(name = "ActivoTransac.findByIdactivoEvent", query = "SELECT a FROM ActivoTransac a WHERE a.idactivoEvent = :idactivoEvent"),
    @NamedQuery(name = "ActivoTransac.findByIdActivo", query = "SELECT a FROM ActivoTransac a WHERE a.idActivo = :idActivo"),
    @NamedQuery(name = "ActivoTransac.findByIdEmpleadoOrigen", query = "SELECT a FROM ActivoTransac a WHERE a.idEmpleadoOrigen = :idEmpleadoOrigen"),
    @NamedQuery(name = "ActivoTransac.findByIdEmpleadoDestino", query = "SELECT a FROM ActivoTransac a WHERE a.idEmpleadoDestino = :idEmpleadoDestino"),
    @NamedQuery(name = "ActivoTransac.findByIdTipOperacion", query = "SELECT a FROM ActivoTransac a WHERE a.idTipOperacion = :idTipOperacion"),
    @NamedQuery(name = "ActivoTransac.findByObservaciones", query = "SELECT a FROM ActivoTransac a WHERE a.observaciones = :observaciones"),
    @NamedQuery(name = "ActivoTransac.findByUsuario", query = "SELECT a FROM ActivoTransac a WHERE a.usuario = :usuario"),
    @NamedQuery(name = "ActivoTransac.findByFecha", query = "SELECT a FROM ActivoTransac a WHERE a.fecha = :fecha")})
public class ActivoTransac implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idactivo_event")
    private Integer idactivoEvent;
    @Basic(optional = false)
    @Column(name = "id_activo")
    private int idActivo;
    @Basic(optional = false)
    @Column(name = "id_empleado_origen")
    private int idEmpleadoOrigen;
    @Basic(optional = false)
    @Column(name = "id_empleado_destino")
    private int idEmpleadoDestino;
    @Basic(optional = false)
    @Column(name = "id_tip_operacion")
    private int idTipOperacion;
    @Column(name = "observaciones")
    private String observaciones;
    @Basic(optional = false)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "activo_tipo_operacion_idactivo_tipo_operacion", referencedColumnName = "idactivo_tipo_operacion")
    @ManyToOne(optional = false)
    private ActivoTipoOperacion activoTipoOperacionIdactivoTipoOperacion;

    public ActivoTransac() {
    }

    public ActivoTransac(Integer idactivoEvent) {
        this.idactivoEvent = idactivoEvent;
    }

    public ActivoTransac(Integer idactivoEvent, int idActivo, int idEmpleadoOrigen, int idEmpleadoDestino, int idTipOperacion, String usuario, Date fecha) {
        this.idactivoEvent = idactivoEvent;
        this.idActivo = idActivo;
        this.idEmpleadoOrigen = idEmpleadoOrigen;
        this.idEmpleadoDestino = idEmpleadoDestino;
        this.idTipOperacion = idTipOperacion;
        this.usuario = usuario;
        this.fecha = fecha;
    }

    public Integer getIdactivoEvent() {
        return idactivoEvent;
    }

    public void setIdactivoEvent(Integer idactivoEvent) {
        this.idactivoEvent = idactivoEvent;
    }

    public int getIdActivo() {
        return idActivo;
    }

    public void setIdActivo(int idActivo) {
        this.idActivo = idActivo;
    }

    public int getIdEmpleadoOrigen() {
        return idEmpleadoOrigen;
    }

    public void setIdEmpleadoOrigen(int idEmpleadoOrigen) {
        this.idEmpleadoOrigen = idEmpleadoOrigen;
    }

    public int getIdEmpleadoDestino() {
        return idEmpleadoDestino;
    }

    public void setIdEmpleadoDestino(int idEmpleadoDestino) {
        this.idEmpleadoDestino = idEmpleadoDestino;
    }

    public int getIdTipOperacion() {
        return idTipOperacion;
    }

    public void setIdTipOperacion(int idTipOperacion) {
        this.idTipOperacion = idTipOperacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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

    public ActivoTipoOperacion getActivoTipoOperacionIdactivoTipoOperacion() {
        return activoTipoOperacionIdactivoTipoOperacion;
    }

    public void setActivoTipoOperacionIdactivoTipoOperacion(ActivoTipoOperacion activoTipoOperacionIdactivoTipoOperacion) {
        this.activoTipoOperacionIdactivoTipoOperacion = activoTipoOperacionIdactivoTipoOperacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idactivoEvent != null ? idactivoEvent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActivoTransac)) {
            return false;
        }
        ActivoTransac other = (ActivoTransac) object;
        if ((this.idactivoEvent == null && other.idactivoEvent != null) || (this.idactivoEvent != null && !this.idactivoEvent.equals(other.idactivoEvent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.orm.activosorm.ActivoTransac[ idactivoEvent=" + idactivoEvent + " ]";
    }
    
}
