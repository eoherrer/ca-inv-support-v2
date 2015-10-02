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
 * @author edcracken
 */
public class JsRoutineNotExistsException extends BaseException {

    public JsRoutineNotExistsException(ErrorDto error) {
        super(Response.Status.METHOD_NOT_ALLOWED, error);
    }

    public JsRoutineNotExistsException(Throwable ex, ErrorDto error) {
        super(Response.Status.METHOD_NOT_ALLOWED, error);
    }
}
