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
@Table(name = "securityrole_menupermission_matrix")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SecurityroleMenupermissionMatrix.findAll", query = "SELECT s FROM SecurityroleMenupermissionMatrix s"),
    @NamedQuery(name = "SecurityroleMenupermissionMatrix.findBySecurityroleMenupermissionId", query = "SELECT s FROM SecurityroleMenupermissionMatrix s WHERE s.securityroleMenupermissionId = :securityroleMenupermissionId"),
    @NamedQuery(name = "SecurityroleMenupermissionMatrix.findBySecurityroleId", query = "SELECT s FROM SecurityroleMenupermissionMatrix s WHERE s.securityroleId = :securityroleId"),
    @NamedQuery(name = "SecurityroleMenupermissionMatrix.findBySecurityrolePermissionMatrixId", query = "SELECT s FROM SecurityroleMenupermissionMatrix s WHERE s.securityrolePermissionMatrixId = :securityrolePermissionMatrixId"),
    @NamedQuery(name = "SecurityroleMenupermissionMatrix.findByCreatedby", query = "SELECT s FROM SecurityroleMenupermissionMatrix s WHERE s.createdby = :createdby"),
    @NamedQuery(name = "SecurityroleMenupermissionMatrix.findByCreateddate", query = "SELECT s FROM SecurityroleMenupermissionMatrix s WHERE s.createddate = :createddate")})
public class SecurityroleMenupermissionMatrix implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "securityrole_menupermission_id")
    private Integer securityroleMenupermissionId;
    @Column(name = "securityrole_id")
    private Integer securityroleId;
    @Column(name = "securityrole_permission_matrix_id")
    private Integer securityrolePermissionMatrixId;
    @Column(name = "createdby")
    private Integer createdby;
    @Column(name = "createddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createddate;

    public SecurityroleMenupermissionMatrix() {
    }

    public SecurityroleMenupermissionMatrix(Integer securityroleMenupermissionId) {
        this.securityroleMenupermissionId = securityroleMenupermissionId;
    }

    public Integer getSecurityroleMenupermissionId() {
        return securityroleMenupermissionId;
    }

    public void setSecurityroleMenupermissionId(Integer securityroleMenupermissionId) {
        this.securityroleMenupermissionId = securityroleMenupermissionId;
    }

    public Integer getSecurityroleId() {
        return securityroleId;
    }

    public void setSecurityroleId(Integer securityroleId) {
        this.securityroleId = securityroleId;
    }

    public Integer getSecurityrolePermissionMatrixId() {
        return securityrolePermissionMatrixId;
    }

    public void setSecurityrolePermissionMatrixId(Integer securityrolePermissionMatrixId) {
        this.securityrolePermissionMatrixId = securityrolePermissionMatrixId;
    }

    public Integer getCreatedby() {
        return createdby;
    }

    public void setCreatedby(Integer createdby) {
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
        hash += (securityroleMenupermissionId != null ? securityroleMenupermissionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SecurityroleMenupermissionMatrix)) {
            return false;
        }
        SecurityroleMenupermissionMatrix other = (SecurityroleMenupermissionMatrix) object;
        if ((this.securityroleMenupermissionId == null && other.securityroleMenupermissionId != null) || (this.securityroleMenupermissionId != null && !this.securityroleMenupermissionId.equals(other.securityroleMenupermissionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.orm.activosorm.SecurityroleMenupermissionMatrix[ securityroleMenupermissionId=" + securityroleMenupermissionId + " ]";
    }
    
}
