/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.renap.infrastructure.remote.model;

import java.io.Serializable;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.renap.infrastructure.remote.model.exceptions.DataRestClientError;

/**
 *
 * @author 2703759290608
 */
@Named
public class RemoteModelClient implements Serializable{

    private Object doRequest(String url, Class clazz) throws DataRestClientError {
        try {
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target(url);
            Invocation.Builder iBuilder = target.request();
            Response r = iBuilder.get();

            return r.readEntity(clazz);
        } catch (Exception e) {
            throw new DataRestClientError(e);
        }
    }

    public String doGetEntityRequest(String entity, String id, String page, String size, String sort) throws DataRestClientError {
        String baseUrl = "http://localhost:8090/" + entity;
        baseUrl = id != null && id.length() > 0 ? baseUrl.concat("/").concat(id) : baseUrl;
        baseUrl = page != null && page.length() > 0 ? baseUrl.concat("?page=").concat(page) : baseUrl;
        baseUrl = size != null && id.length() > 0 && page != null && page.length() > 0 ? baseUrl.concat("&size=").concat(size) : baseUrl;
        return (String) doRequest(baseUrl, String.class);

    }
}
