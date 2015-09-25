/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.renap.infrastructure.integrations;

import java.io.Serializable;
import java.util.Map;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author edcracken
 */
@Named
@ApplicationScoped
public class RemoteDao implements Serializable {

    public Object doCustomQuery(String entity, Map<String, String> params) {
        System.out.println("got it! custom query!");
        return null;
    }

    public Object doNamedQuery(String entity, Map<String, String> params) {
        System.out.println("got it! named query!");
        return null;
    }

    public Object doPersist(String entity, Object action, String jsonRequest) {
        System.out.println("got it! named query!");
        return null;
    }
}
