/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.renap.web;

import com.google.gson.JsonObject;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.io.Writer;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
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
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import javax.ws.rs.core.UriInfo;
import org.apache.commons.io.IOUtils;
import org.renap.ejb.JsRoutinesExecutor;
import org.renap.infrastructure.exceptions.BaseException;
import org.renap.infrastructure.exceptions.JsRoutineFailException;
import org.renap.infrastructure.exceptions.JsRoutineNotExistsException;
import org.renap.infrastructure.exceptions.dto.ErrorDto;
import org.renap.infrastructure.remote.model.exceptions.InvalidParametersException;

/**
 *
 * @author edcracken
 */
@Named
@RequestScoped
@Path("/v1/jsbroker")
public class JsBrokerAPI implements Serializable {

    @Context
    ServletContext ctx;

    @Inject
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
    @Path("/media-operations/{name}")
    @Consumes({MediaType.MULTIPART_FORM_DATA})
    @Produces({MediaType.APPLICATION_JSON})
    public Response doMediaOperation(@PathParam("name") String name, InputStream rawBody) throws JsRoutineNotExistsException, JsRoutineFailException, BaseException {
        return processRutine(name, null, rawBody);
    }

    /**
     * find a server side routine for executio, in case fail generate http error
     * code
     *
     * @param name
     * @param ctxUri
     * @param rawBody
     * @return
     * @throws org.renap.infrastructure.exceptions.JsRoutineNotExistsException
     * @throws org.renap.infrastructure.exceptions.JsRoutineFailException
     */
    @POST
    @Path("/operations/{name}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response doPersistOperation(@PathParam("name") String name, @Context UriInfo ctxUri, InputStream rawBody) throws JsRoutineNotExistsException, JsRoutineFailException, BaseException {
        return processRutine(name, ctxUri.getQueryParameters(), rawBody);
    }

    /**
     * find a server side routine for executio, in case fail generate http error
     * code
     *
     * @param name
     * @param ctxUri
     * @return
     * @throws org.renap.infrastructure.exceptions.JsRoutineNotExistsException
     * @throws org.renap.infrastructure.exceptions.JsRoutineFailException
     */
    @GET
    @Path("/resources/{name}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response doResourceOperation(@PathParam("name") String name, @Context UriInfo ctxUri) throws JsRoutineNotExistsException, JsRoutineFailException, BaseException {
        return processRutine(name, ctxUri.getQueryParameters(), null);
    }

    private Response processRutine(@PathParam("name") String name, MultivaluedMap<String, String> values, InputStream rawBody) throws JsRoutineNotExistsException, JsRoutineFailException, BaseException {
        try {
            String routineFilePath = ctx.getRealPath("/WEB-INF/ss.js/" + name);
            if (routineFilePath == null || routineFilePath.isEmpty()) {
                throw new InvalidParametersException(new ErrorDto("997", "La rutina no existe en el directorio!"));
            }
            System.out.println("routine name...." + routineFilePath);

            StringWriter requestBody = new StringWriter();
            if (rawBody != null) {
                IOUtils.copy(rawBody, requestBody, "UTF-8");
            }

            JsonObject o = new JsonObject();
            if (values != null && !values.isEmpty()) {
                for (String k : values.keySet()) {
                    o.addProperty(k, values.getFirst(k));
                }
            }

            final String res = executor.exec(executor.validateRoutine(routineFilePath), requestBody.toString(), o.toString());
            if (res != null && res.isEmpty()) {
                return Response.ok().build();
            }
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
            throw new JsRoutineFailException(ex, new ErrorDto("990", "Error procesando rawbody de request"));
        }
    }

}
