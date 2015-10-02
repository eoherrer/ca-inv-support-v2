/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.renap.infrastructure.exceptions;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author 2703759290608
 */
public abstract class AbstractExceptionMapper {

    /**
     *
     * @param status
     * @param response
     * @return
     */
    protected Response errorResponse(Response.Status status, Object response) {
        return customizeResponse(status, response);
    }

    /**
     *
     * @param status
     * @param response
     * @param t
     * @return
     */
    protected Response errorResponse(Response.Status status, Object response, Throwable t) {
        return customizeResponse(status, response);
    }

    /**
     *
     * @param status
     * @param response
     * @return
     */
    private Response customizeResponse(Response.Status status, Object response) {
        return Response.status(status).type(MediaType.APPLICATION_JSON).entity(response).build();
    }
}
