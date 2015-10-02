/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.renap.infrastructure.exceptions.dto;

import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 2703759290608
 */
@XmlRootElement
public class ErrorDto {

    private String code;
    private String message;

    public ErrorDto() {
    }

    public ErrorDto(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
