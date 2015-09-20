/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.renap.web;

import java.io.InputStream;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.renap.ejb.JsRoutinesExecutor;
import org.renap.ejb.JssBrokerResourceManager;

/**
 *
 * @author edcracken
 */
@Stateless
@Path("/v1/jssbroker")
public class JssBrokerAPI {

    @Context
    ServletContext ctx;

    @EJB
    JssBrokerResourceManager rsManager;

    @EJB
    JsRoutinesExecutor executor;

    /**
     * find a server side routine for executio, in case fail generate http error
     * code
     *
     * @param name
     * @param rawBody
     * @return
     */
    @POST
    @Path("/doRutine/{name}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response doRutine(@PathParam("name") String name, InputStream rawBody) {
        return Response.ok().build();
    }

    /**
     * only query functions, any persist method called will generate http error
     * code
     *
     * @param name
     * @param entity
     * @param query
     * @return
     */
    @GET
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("/entities/query/{entity}/{query}")
    public Response doCrudOps(@PathParam("action") String name, @PathParam("entity") String entity,
            @PathParam("query") String query) {
        return Response.ok().build();
    }

    @GET
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("/switch/query/{entity}/{query}")
    public Response doCrudOps(@PathParam("action") String name, @PathParam("entity") String entity,
            @PathParam("query") String query, InputStream rawBody) {
        return Response.ok().build();
    }

}
