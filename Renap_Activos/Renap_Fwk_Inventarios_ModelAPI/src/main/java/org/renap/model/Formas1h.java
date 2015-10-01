/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.renap.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "formas1h")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Formas1h.findAll", query = "SELECT f FROM Formas1h f"),
    @NamedQuery(name = "Formas1h.findByIdformas1H", query = "SELECT f FROM Formas1h f WHERE f.idformas1H = :idformas1H"),
    @NamedQuery(name = "Formas1h.findBySerie", query = "SELECT f FROM Formas1h f WHERE f.serie = :serie"),
    @NamedQuery(name = "Formas1h.findByNoForma", query = "SELECT f FROM Formas1h f WHERE f.noForma = :noForma"),
    @NamedQuery(name = "Formas1h.findByFecha", query = "SELECT f FROM Formas1h f WHERE f.fecha = :fecha"),
    @NamedQuery(name = "Formas1h.findBySerieFact", query = "SELECT f FROM Formas1h f WHERE f.serieFact = :serieFact"),
    @NamedQuery(name = "Formas1h.findByNoFact", query = "SELECT f FROM Formas1h f WHERE f.noFact = :noFact"),
    @NamedQuery(name = "Formas1h.findByTotal", query = "SELECT f FROM Formas1h f WHERE f.total = :total"),
    @NamedQuery(name = "Formas1h.findByFormas1Hcol", query = "SELECT f FROM Formas1h f WHERE f.formas1Hcol = :formas1Hcol")})
public class Formas1h implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idformas1H")
    private Integer idformas1H;
    @Column(name = "serie")
    private String serie;
    @Column(name = "no_forma")
    private String noForma;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "serie_fact")
    private String serieFact;
    @Column(name = "no_fact")
    private String noFact;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total")
    private BigDecimal total;
    @Column(name = "formas1Hcol")
    private String formas1Hcol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "formas1Hidformas1H")
    private Collection<ActivoFactura> activoFacturaCollection;

    public Formas1h() {
    }

    public Formas1h(Integer idformas1H) {
        this.idformas1H = idformas1H;
    }

    public Integer getIdformas1H() {
        return idformas1H;
    }

    public void setIdformas1H(Integer idformas1H) {
        this.idformas1H = idformas1H;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNoForma() {
        return noForma;
    }

    public void setNoForma(String noForma) {
        this.noForma = noForma;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getSerieFact() {
        return serieFact;
    }

    public void setSerieFact(String serieFact) {
        this.serieFact = serieFact;
    }

    public String getNoFact() {
        return noFact;
    }

    public void setNoFact(String noFact) {
        this.noFact = noFact;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getFormas1Hcol() {
        return formas1Hcol;
    }

    public void setFormas1Hcol(String formas1Hcol) {
        this.formas1Hcol = formas1Hcol;
    }

    @XmlTransient
    public Collection<ActivoFactura> getActivoFacturaCollection() {
        return activoFacturaCollection;
    }

    public void setActivoFacturaCollection(Collection<ActivoFactura> activoFacturaCollection) {
        this.activoFacturaCollection = activoFacturaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idformas1H != null ? idformas1H.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formas1h)) {
            return false;
        }
        Formas1h other = (Formas1h) object;
        if ((this.idformas1H == null && other.idformas1H != null) || (this.idformas1H != null && !this.idformas1H.equals(other.idformas1H))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.orm.activosorm.Formas1h[ idformas1H=" + idformas1H + " ]";
    }
    
}
