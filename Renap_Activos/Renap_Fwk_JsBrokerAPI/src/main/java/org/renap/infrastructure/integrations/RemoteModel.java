/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.renap.infrastructure.integrations;

import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import org.renap.infrastructure.remote.model.RemoteModelClient;
import org.renap.infrastructure.remote.model.exceptions.DataRestClientException;
import org.renap.infrastructure.remote.model.exceptions.InvalidMethodException;
import org.renap.infrastructure.remote.model.exceptions.InvalidParametersException;

/**
 *
 * @author edcracken
 */
@Named
@ApplicationScoped
public class RemoteModel implements Serializable {

    RemoteModelClient client = new RemoteModelClient();

    public String doGetEntityRequest(String entity, String id, String page, String size, String sort) throws DataRestClientException {
        return client.doGetEntityRequest(entity, id, page, size, sort);
    }

    public String doPersistEntityRequest(String entity, String id, String raw, String method) throws DataRestClientException, InvalidParametersException, InvalidMethodException {
        return client.doPersistEntityRequest(entity, id, raw, method);
    }
}
