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
@Table(name = "carrier_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CarrierMaster.findAll", query = "SELECT c FROM CarrierMaster c"),
    @NamedQuery(name = "CarrierMaster.findByCarrierId", query = "SELECT c FROM CarrierMaster c WHERE c.carrierId = :carrierId"),
    @NamedQuery(name = "CarrierMaster.findByCountryId", query = "SELECT c FROM CarrierMaster c WHERE c.countryId = :countryId"),
    @NamedQuery(name = "CarrierMaster.findByTimezoneId", query = "SELECT c FROM CarrierMaster c WHERE c.timezoneId = :timezoneId"),
    @NamedQuery(name = "CarrierMaster.findByCustomId", query = "SELECT c FROM CarrierMaster c WHERE c.customId = :customId"),
    @NamedQuery(name = "CarrierMaster.findByCurrencyId", query = "SELECT c FROM CarrierMaster c WHERE c.currencyId = :currencyId"),
    @NamedQuery(name = "CarrierMaster.findByCarrierName", query = "SELECT c FROM CarrierMaster c WHERE c.carrierName = :carrierName"),
    @NamedQuery(name = "CarrierMaster.findByStatus", query = "SELECT c FROM CarrierMaster c WHERE c.status = :status"),
    @NamedQuery(name = "CarrierMaster.findByPinLength", query = "SELECT c FROM CarrierMaster c WHERE c.pinLength = :pinLength"),
    @NamedQuery(name = "CarrierMaster.findByOptInKeyword", query = "SELECT c FROM CarrierMaster c WHERE c.optInKeyword = :optInKeyword"),
    @NamedQuery(name = "CarrierMaster.findByOptOutKeyword", query = "SELECT c FROM CarrierMaster c WHERE c.optOutKeyword = :optOutKeyword"),
    @NamedQuery(name = "CarrierMaster.findByOptinMessage", query = "SELECT c FROM CarrierMaster c WHERE c.optinMessage = :optinMessage"),
    @NamedQuery(name = "CarrierMaster.findByOptoutMessage", query = "SELECT c FROM CarrierMaster c WHERE c.optoutMessage = :optoutMessage"),
    @NamedQuery(name = "CarrierMaster.findByAccessToken", query = "SELECT c FROM CarrierMaster c WHERE c.accessToken = :accessToken"),
    @NamedQuery(name = "CarrierMaster.findByCountryCode", query = "SELECT c FROM CarrierMaster c WHERE c.countryCode = :countryCode")})
public class CarrierMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "carrier_id")
    private Integer carrierId;
    @Column(name = "country_id")
    private Integer countryId;
    @Column(name = "timezone_id")
    private Integer timezoneId;
    @Column(name = "custom_id")
    private Integer customId;
    @Column(name = "currency_id")
    private Integer currencyId;
    @Column(name = "carrier_name")
    private String carrierName;
    @Column(name = "status")
    private Boolean status;
    @Column(name = "pin_length")
    private Integer pinLength;
    @Column(name = "optInKeyword")
    private String optInKeyword;
    @Column(name = "optOutKeyword")
    private String optOutKeyword;
    @Column(name = "optin_message")
    private String optinMessage;
    @Column(name = "optout_message")
    private String optoutMessage;
    @Column(name = "AccessToken")
    private String accessToken;
    @Column(name = "country_code")
    private String countryCode;

    public CarrierMaster() {
    }

    public CarrierMaster(Integer carrierId) {
        this.carrierId = carrierId;
    }

    public Integer getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(Integer carrierId) {
        this.carrierId = carrierId;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public Integer getTimezoneId() {
        return timezoneId;
    }

    public void setTimezoneId(Integer timezoneId) {
        this.timezoneId = timezoneId;
    }

    public Integer getCustomId() {
        return customId;
    }

    public void setCustomId(Integer customId) {
        this.customId = customId;
    }

    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getPinLength() {
        return pinLength;
    }

    public void setPinLength(Integer pinLength) {
        this.pinLength = pinLength;
    }

    public String getOptInKeyword() {
        return optInKeyword;
    }

    public void setOptInKeyword(String optInKeyword) {
        this.optInKeyword = optInKeyword;
    }

    public String getOptOutKeyword() {
        return optOutKeyword;
    }

    public void setOptOutKeyword(String optOutKeyword) {
        this.optOutKeyword = optOutKeyword;
    }

    public String getOptinMessage() {
        return optinMessage;
    }

    public void setOptinMessage(String optinMessage) {
        this.optinMessage = optinMessage;
    }

    public String getOptoutMessage() {
        return optoutMessage;
    }

    public void setOptoutMessage(String optoutMessage) {
        this.optoutMessage = optoutMessage;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (carrierId != null ? carrierId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CarrierMaster)) {
            return false;
        }
        CarrierMaster other = (CarrierMaster) object;
        if ((this.carrierId == null && other.carrierId != null) || (this.carrierId != null && !this.carrierId.equals(other.carrierId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.renap.orm.activosorm.CarrierMaster[ carrierId=" + carrierId + " ]";
    }
    
}
