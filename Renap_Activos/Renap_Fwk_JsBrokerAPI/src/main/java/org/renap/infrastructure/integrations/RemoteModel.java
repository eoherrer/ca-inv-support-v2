/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.renap.infrastructure.integrations;

import java.io.Serializable;
import javax.ejb.Stateless;
import org.renap.infrastructure.remote.model.RemoteModelClient;
import org.renap.infrastructure.remote.model.exceptions.DataRestClientError;

/**
 *
 * @author edcracken
 */
@Stateless
public class RemoteModel implements Serializable {

    RemoteModelClient client = new RemoteModelClient();

    public String doGetEntityRequest(String entity, String id, String page, String size, String sort) throws DataRestClientError {
        return client.doGetEntityRequest(entity, id, page, size, sort);
    }

    public String doPersistEntityRequest(String entity, String id, String raw, String method) throws DataRestClientError {
        return client.doPersistEntityRequest(entity, id, raw, method);
    }
}
