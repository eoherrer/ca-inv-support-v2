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
public class JsRoutineFailException extends BaseException {

    public JsRoutineFailException(Response.Status status, ErrorDto error) {
        super(status, error);
    }

    public JsRoutineFailException(Exception e, ErrorDto error) {
        super(Response.Status.BAD_REQUEST, error);        
    }

}
