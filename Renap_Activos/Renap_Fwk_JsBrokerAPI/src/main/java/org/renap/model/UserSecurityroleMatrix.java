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
@Table(name = "user_securityrole_matrix")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserSecurityroleMatrix.findAll", query = "SELECT u FROM UserSecurityroleMatrix u"),
    @NamedQuery(name = "UserSecurityroleMatrix.findByUserSecurityroleMatrixId", query = "SELECT u FROM UserSecurityroleMatrix u WHERE u.userSecurityroleMatrixId = :userSecurityroleMatrixId"),
    @NamedQuery(name = "UserSecurityroleMatrix.findByUserId", query = "SELECT u FROM UserSecurityroleMatrix u WHERE u.userId = :userId"),
    @NamedQuery(name = "UserSecurityroleMatrix.findBySecurityroleId", query = "SELECT u FROM UserSecurityroleMatrix u WHERE u.securityroleId = :securityroleId"),
    @NamedQuery(name = "UserSecurityroleMatrix.findByCreatedby", query = "SELECT u FROM UserSecurityroleMatrix u WHERE u.createdby = :createdby"),
    @NamedQuery(name = "UserSecurityroleMatrix.findByCreateddate", query = "SELECT u FROM UserSecurityroleMatrix u WHERE u.createddate = :createddate")})
public class UserSecurityroleMatrix implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_securityrole_matrix_id")
    private Integer userSecurityroleMatrixId;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "securityrole_id")
    private Integer securityroleId;
    @Column(name = "createdby")
    private Integer createdby;
    @Column(name = "createddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createddate;

    public UserSecurityroleMatrix() {
    }

    public UserSecurityroleMatrix(Integer userSecurityroleMatrixId) {
        this.userSecurityroleMatrixId = userSecurityroleMatrixId;
    }

    public Integer getUserSecurityroleMatrixId() {
        return userSecurityroleMatrixId;
    }

    public void setUserSecurityroleMatrixId(Integer userSecurityroleMatrixId) {
        this.userSecurityroleMatrixId = userSecurityroleMatrixId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSecurityroleId() {
        return securityroleId;
    }

    public void setSecurityroleId(Integer securityroleId) {
        this.securityroleId = securityroleId;
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
        hash += (userSecurityroleMatrixId != null ? userSecurityroleMatrixId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserSecurityroleMatrix)) {
            return false;
        }
        UserSecurityroleMatrix other = (UserSecurityroleMatrix) object;
        if ((this.userSecurityroleMatrixId == null && other.userSecurityroleMatrixId != null) || (this.userSecurityroleMatrixId != null && !this.userSecurityroleMatrixId.equals(other.userSecurityroleMatrixId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.orm.activosorm.UserSecurityroleMatrix[ userSecurityroleMatrixId=" + userSecurityroleMatrixId + " ]";
    }
    
}
