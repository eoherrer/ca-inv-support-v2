/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.renap.web;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import javax.ws.rs.core.UriInfo;
import org.apache.commons.io.IOUtils;
import org.renap.ejb.JsRoutinesExecutor;
import org.renap.infrastructure.exceptions.JsRoutineFailException;
import org.renap.infrastructure.exceptions.JsRoutineNotExistsException;

/**
 *
 * @author edcracken
 */
@Stateless
@Path("/v1/jsbroker")
public class JsBrokerAPI {

    @Context
    ServletContext ctx;

    @EJB
    JsRoutinesExecutor executor;

    /**
     * find a server side routine for executio, in case fail generate http error
     * code
     *
     * @param name
     * @param rawBody
     * @return
     * @throws org.renap.infrastructure.exceptions.JsRoutineNotExistsException
     * @throws org.renap.infrastructure.exceptions.JsRoutineFailException
     */
    @POST
    @Path("/doRutine/{name}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response doRutine(@PathParam("name") String name, InputStream rawBody) throws JsRoutineNotExistsException, JsRoutineFailException {
        try {
            System.out.println("name...." + name);
            System.out.println("name...." + ctx.getRealPath("/WEB-INF/ss.js/"+name));
            FileReader fr = executor.validateRoutine(ctx.getRealPath("/WEB-INF/ss.js/"+name));
            StringWriter writer = new StringWriter();
            IOUtils.copy(rawBody, writer, "UTF-8");
            String in = writer.toString();
            final String res = executor.exec(fr, in);
            StreamingOutput stream = new StreamingOutput() {
                @Override
                public void write(OutputStream os) throws IOException,
                        WebApplicationException {
                    Writer writer = new BufferedWriter(new OutputStreamWriter(os));
                    writer.write(res);
                    writer.flush();
                }
            };
            return Response.ok(stream).build();
        } catch (IOException ex) {
            throw new JsRoutineFailException(ex);
            //return Response.serverError().status(Response.Status.BAD_REQUEST).entity(new BrokerError()).build();
        }
    }

    /**
     * only query functions, any persist method called will generate http error
     * code
     *
     * @param entity
     * @param namedQuery
     * @param ctx
     * @return
     */
    @GET
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("/entities/{entity}/named-query/{named_query}")
    public Response doNamedQuery(@PathParam("entity") String entity,
            @PathParam("named_query") String namedQuery, @Context UriInfo ctx) {
        return Response.ok().build();
    }

    @GET
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("/entities/{entity}/search")
    public Response doCustomQuery(@PathParam("entity") String entity, @Context UriInfo ctx) {
        return Response.ok().build();
    }

}
