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
@Table(name = "control_formatos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ControlFormatos.findAll", query = "SELECT c FROM ControlFormatos c"),
    @NamedQuery(name = "ControlFormatos.findByIdcontrolFormatos", query = "SELECT c FROM ControlFormatos c WHERE c.idcontrolFormatos = :idcontrolFormatos"),
    @NamedQuery(name = "ControlFormatos.findByNumero", query = "SELECT c FROM ControlFormatos c WHERE c.numero = :numero"),
    @NamedQuery(name = "ControlFormatos.findByEstatus", query = "SELECT c FROM ControlFormatos c WHERE c.estatus = :estatus"),
    @NamedQuery(name = "ControlFormatos.findByIdTecnicoEmpleado", query = "SELECT c FROM ControlFormatos c WHERE c.idTecnicoEmpleado = :idTecnicoEmpleado"),
    @NamedQuery(name = "ControlFormatos.findByIdDepto", query = "SELECT c FROM ControlFormatos c WHERE c.idDepto = :idDepto"),
    @NamedQuery(name = "ControlFormatos.findByIdMunic", query = "SELECT c FROM ControlFormatos c WHERE c.idMunic = :idMunic"),
    @NamedQuery(name = "ControlFormatos.findByControlFormatoscol", query = "SELECT c FROM ControlFormatos c WHERE c.controlFormatoscol = :controlFormatoscol")})
public class ControlFormatos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcontrol_formatos")
    private Long idcontrolFormatos;
    @Column(name = "numero")
    private String numero;
    @Column(name = "estatus")
    private String estatus;
    @Column(name = "id_tecnico_empleado")
    private String idTecnicoEmpleado;
    @Column(name = "id_depto")
    private String idDepto;
    @Column(name = "id_munic")
    private String idMunic;
    @Column(name = "control_formatoscol")
    private String controlFormatoscol;

    public ControlFormatos() {
    }

    public ControlFormatos(Long idcontrolFormatos) {
        this.idcontrolFormatos = idcontrolFormatos;
    }

    public Long getIdcontrolFormatos() {
        return idcontrolFormatos;
    }

    public void setIdcontrolFormatos(Long idcontrolFormatos) {
        this.idcontrolFormatos = idcontrolFormatos;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getIdTecnicoEmpleado() {
        return idTecnicoEmpleado;
    }

    public void setIdTecnicoEmpleado(String idTecnicoEmpleado) {
        this.idTecnicoEmpleado = idTecnicoEmpleado;
    }

    public String getIdDepto() {
        return idDepto;
    }

    public void setIdDepto(String idDepto) {
        this.idDepto = idDepto;
    }

    public String getIdMunic() {
        return idMunic;
    }

    public void setIdMunic(String idMunic) {
        this.idMunic = idMunic;
    }

    public String getControlFormatoscol() {
        return controlFormatoscol;
    }

    public void setControlFormatoscol(String controlFormatoscol) {
        this.controlFormatoscol = controlFormatoscol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcontrolFormatos != null ? idcontrolFormatos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ControlFormatos)) {
            return false;
        }
        ControlFormatos other = (ControlFormatos) object;
        if ((this.idcontrolFormatos == null && other.idcontrolFormatos != null) || (this.idcontrolFormatos != null && !this.idcontrolFormatos.equals(other.idcontrolFormatos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.orm.activosorm.ControlFormatos[ idcontrolFormatos=" + idcontrolFormatos + " ]";
    }
    
}
