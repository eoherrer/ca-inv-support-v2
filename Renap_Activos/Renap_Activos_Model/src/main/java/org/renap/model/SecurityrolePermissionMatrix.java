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
@Table(name = "securityrole_permission_matrix")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SecurityrolePermissionMatrix.findAll", query = "SELECT s FROM SecurityrolePermissionMatrix s"),
    @NamedQuery(name = "SecurityrolePermissionMatrix.findBySecurityrolePermissionMatrixId", query = "SELECT s FROM SecurityrolePermissionMatrix s WHERE s.securityrolePermissionMatrixId = :securityrolePermissionMatrixId"),
    @NamedQuery(name = "SecurityrolePermissionMatrix.findBySecurityroleId", query = "SELECT s FROM SecurityrolePermissionMatrix s WHERE s.securityroleId = :securityroleId"),
    @NamedQuery(name = "SecurityrolePermissionMatrix.findByPermissionId", query = "SELECT s FROM SecurityrolePermissionMatrix s WHERE s.permissionId = :permissionId"),
    @NamedQuery(name = "SecurityrolePermissionMatrix.findByCreatedby", query = "SELECT s FROM SecurityrolePermissionMatrix s WHERE s.createdby = :createdby"),
    @NamedQuery(name = "SecurityrolePermissionMatrix.findByCreateddate", query = "SELECT s FROM SecurityrolePermissionMatrix s WHERE s.createddate = :createddate")})
public class SecurityrolePermissionMatrix implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "securityrole_permission_matrix_id")
    private Integer securityrolePermissionMatrixId;
    @Column(name = "securityrole_id")
    private Integer securityroleId;
    @Column(name = "permission_id")
    private Integer permissionId;
    @Column(name = "createdby")
    private String createdby;
    @Column(name = "createddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createddate;

    public SecurityrolePermissionMatrix() {
    }

    public SecurityrolePermissionMatrix(Integer securityrolePermissionMatrixId) {
        this.securityrolePermissionMatrixId = securityrolePermissionMatrixId;
    }

    public Integer getSecurityrolePermissionMatrixId() {
        return securityrolePermissionMatrixId;
    }

    public void setSecurityrolePermissionMatrixId(Integer securityrolePermissionMatrixId) {
        this.securityrolePermissionMatrixId = securityrolePermissionMatrixId;
    }

    public Integer getSecurityroleId() {
        return securityroleId;
    }

    public void setSecurityroleId(Integer securityroleId) {
        this.securityroleId = securityroleId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (securityrolePermissionMatrixId != null ? securityrolePermissionMatrixId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SecurityrolePermissionMatrix)) {
            return false;
        }
        SecurityrolePermissionMatrix other = (SecurityrolePermissionMatrix) object;
        if ((this.securityrolePermissionMatrixId == null && other.securityrolePermissionMatrixId != null) || (this.securityrolePermissionMatrixId != null && !this.securityrolePermissionMatrixId.equals(other.securityrolePermissionMatrixId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.orm.activosorm.SecurityrolePermissionMatrix[ securityrolePermissionMatrixId=" + securityrolePermissionMatrixId + " ]";
    }
    
}
