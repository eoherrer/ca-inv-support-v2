/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.renap.infrastructure.remote.model.exceptions;

import javax.ws.rs.core.Response;
import org.renap.infrastructure.exceptions.BaseException;
import org.renap.infrastructure.exceptions.dto.ErrorDto;

/**
 *
 * @author 2703759290608
 */
public class DataRestClientException extends BaseException {

    public DataRestClientException(Exception e, ErrorDto error) {
        super(Response.Status.GATEWAY_TIMEOUT, error);
    }

}
