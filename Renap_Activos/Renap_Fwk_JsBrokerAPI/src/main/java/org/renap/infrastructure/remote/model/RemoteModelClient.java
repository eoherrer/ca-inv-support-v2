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
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.renap.infrastructure.remote.model.exceptions.DataRestClientError;

/**
 *
 * @author 2703759290608
 */
@Named
public class RemoteModelClient implements Serializable {

    private Object doRequest(String url, Class clazz, String method, String raw) throws DataRestClientError {
        try {
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target(url);
            Invocation.Builder iBuilder = target.request();
            if (raw != null) {
                return iBuilder.method(method, Entity.entity(raw, MediaType.APPLICATION_JSON), clazz);                
            }
            return iBuilder.method(method, clazz);
        } catch (Exception e) {
            throw new DataRestClientError(e);
        }
    }

    /**
     *
     * @param entity
     * @param id
     * @param page
     * @param size
     * @param sort
     * @return
     * @throws DataRestClientError
     */
    public String doGetEntityRequest(String entity, String id, String page, String size, String sort) throws DataRestClientError {
        String baseUrl = "http://localhost:8090/" + entity;
        baseUrl = id != null && id.length() > 0 ? baseUrl.concat("/").concat(id) : baseUrl;
        baseUrl = page != null && page.length() > 0 ? baseUrl.concat("?page=").concat(page) : baseUrl;
        baseUrl = size != null && size.length() > 0 && page != null && page.length() > 0 ? baseUrl.concat("&size=").concat(size) : baseUrl;
        return (String) doRequest(baseUrl, String.class, "GET", null);
    }

    /**
     *
     * @param entity
     * @param id
     * @param raw
     * @param method
     * @return
     * @throws DataRestClientError
     */
    public String doPersistEntityRequest(String entity, String id, String raw, String method) throws DataRestClientError {
        System.out.println("enviando.............." + raw);
        String baseUrl = "http://localhost:8090/" + entity;
        baseUrl = id != null && id.length() > 0 && !id.contains("undefined") ? baseUrl.concat("/").concat(id) : baseUrl;
        if (!method.equals("POST") && (id == null || id.isEmpty())) {
            throw new DataRestClientError(new Exception("el parametro ID es requerido para cualquier accion de modificacion de objetos"));
        }
        if (method.contains("GET")) {
            throw new DataRestClientError(new Exception("el metodo no esta permitodo para esta accion"));
        }
        return (String) doRequest(baseUrl, String.class, method, raw);
    }
}
