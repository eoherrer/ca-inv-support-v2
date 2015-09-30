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
@Table(name = "user_event")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserEvent.findAll", query = "SELECT u FROM UserEvent u"),
    @NamedQuery(name = "UserEvent.findByIduserEvent", query = "SELECT u FROM UserEvent u WHERE u.iduserEvent = :iduserEvent"),
    @NamedQuery(name = "UserEvent.findByUser", query = "SELECT u FROM UserEvent u WHERE u.user = :user"),
    @NamedQuery(name = "UserEvent.findByEventDate", query = "SELECT u FROM UserEvent u WHERE u.eventDate = :eventDate"),
    @NamedQuery(name = "UserEvent.findByEvent", query = "SELECT u FROM UserEvent u WHERE u.event = :event")})
public class UserEvent implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iduser_event")
    private Long iduserEvent;
    @Column(name = "user")
    private String user;
    @Column(name = "event_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date eventDate;
    @Column(name = "event")
    private String event;

    public UserEvent() {
    }

    public UserEvent(Long iduserEvent) {
        this.iduserEvent = iduserEvent;
    }

    public Long getIduserEvent() {
        return iduserEvent;
    }

    public void setIduserEvent(Long iduserEvent) {
        this.iduserEvent = iduserEvent;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iduserEvent != null ? iduserEvent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserEvent)) {
            return false;
        }
        UserEvent other = (UserEvent) object;
        if ((this.iduserEvent == null && other.iduserEvent != null) || (this.iduserEvent != null && !this.iduserEvent.equals(other.iduserEvent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.orm.activosorm.UserEvent[ iduserEvent=" + iduserEvent + " ]";
    }
    
}
