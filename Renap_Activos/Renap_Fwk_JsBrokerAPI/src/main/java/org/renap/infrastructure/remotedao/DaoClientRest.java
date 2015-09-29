/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.renap.infrastructure.remotedao;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 *
 * @author 2703759290608
 */
public class DaoClientRest {

    public static void main(String[] args) {
        try {
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target("http://localhost:8090/poliza");
            Invocation.Builder iBuilder = target.request();
            Response r = iBuilder.get();

            String s = r.readEntity(String.class);
            System.out.println(s);
        } catch (Exception e) {

            e.printStackTrace();

        }

    }
}
