/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.renap.infrastructure.exceptions;

import javax.ws.rs.core.Response;
import org.renap.infrastructure.exceptions.dto.ErrorDto;

/**
 *
 * @author 2703759290608
 */
public class BaseException extends Throwable {

    private final Response.Status status;
    private final ErrorDto error;

    public BaseException(Response.Status status, ErrorDto error) {
        super(error.getMessage());
        this.error = error;
        this.status = status;
    }

    public ErrorDto getError() {
        return error;
    }

    public Response.Status getStatus() {
        return status;
    }

}
