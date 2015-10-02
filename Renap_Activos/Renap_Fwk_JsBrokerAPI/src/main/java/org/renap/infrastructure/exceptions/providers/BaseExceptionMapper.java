/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.renap.infrastructure.exceptions.providers;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.renap.infrastructure.exceptions.AbstractExceptionMapper;
import org.renap.infrastructure.exceptions.BaseException;

/**
 *
 * @author 2703759290608
 */
@Provider
@Priority(Priorities.USER)
public class BaseExceptionMapper extends AbstractExceptionMapper implements ExceptionMapper<BaseException> {

    @Override
    public Response toResponse(BaseException exception) {
        return this.errorResponse(exception.getStatus(), exception.getError());
    }

}
