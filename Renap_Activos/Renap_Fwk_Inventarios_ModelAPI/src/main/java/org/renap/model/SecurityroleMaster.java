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
@Table(name = "securityrole_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SecurityroleMaster.findAll", query = "SELECT s FROM SecurityroleMaster s"),
    @NamedQuery(name = "SecurityroleMaster.findBySecurityroleId", query = "SELECT s FROM SecurityroleMaster s WHERE s.securityroleId = :securityroleId"),
    @NamedQuery(name = "SecurityroleMaster.findByName", query = "SELECT s FROM SecurityroleMaster s WHERE s.name = :name"),
    @NamedQuery(name = "SecurityroleMaster.findByDescription", query = "SELECT s FROM SecurityroleMaster s WHERE s.description = :description"),
    @NamedQuery(name = "SecurityroleMaster.findByEnablepublicrole", query = "SELECT s FROM SecurityroleMaster s WHERE s.enablepublicrole = :enablepublicrole"),
    @NamedQuery(name = "SecurityroleMaster.findByCreatedby", query = "SELECT s FROM SecurityroleMaster s WHERE s.createdby = :createdby"),
    @NamedQuery(name = "SecurityroleMaster.findByCreateddate", query = "SELECT s FROM SecurityroleMaster s WHERE s.createddate = :createddate"),
    @NamedQuery(name = "SecurityroleMaster.findByStatus", query = "SELECT s FROM SecurityroleMaster s WHERE s.status = :status")})
public class SecurityroleMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "securityrole_id")
    private Integer securityroleId;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "enablepublicrole")
    private String enablepublicrole;
    @Column(name = "createdby")
    private String createdby;
    @Column(name = "createddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createddate;
    @Column(name = "status")
    private Boolean status;

    public SecurityroleMaster() {
    }

    public SecurityroleMaster(Integer securityroleId) {
        this.securityroleId = securityroleId;
    }

    public Integer getSecurityroleId() {
        return securityroleId;
    }

    public void setSecurityroleId(Integer securityroleId) {
        this.securityroleId = securityroleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEnablepublicrole() {
        return enablepublicrole;
    }

    public void setEnablepublicrole(String enablepublicrole) {
        this.enablepublicrole = enablepublicrole;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public Date getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (securityroleId != null ? securityroleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SecurityroleMaster)) {
            return false;
        }
        SecurityroleMaster other = (SecurityroleMaster) object;
        if ((this.securityroleId == null && other.securityroleId != null) || (this.securityroleId != null && !this.securityroleId.equals(other.securityroleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.orm.activosorm.SecurityroleMaster[ securityroleId=" + securityroleId + " ]";
    }
    
}
