/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.renap.ejb;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.io.StringWriter;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import org.apache.commons.io.IOUtils;
import org.renap.infrastructure.JsRoutine;
import org.renap.infrastructure.exceptions.BaseException;
import org.renap.infrastructure.exceptions.JsRoutineFailException;
import org.renap.infrastructure.exceptions.JsRoutineNotExistsException;
import org.renap.infrastructure.exceptions.dto.ErrorDto;
import org.renap.infrastructure.integrations.RemoteModel;
import org.renap.infrastructure.integrations.SwitchClient;

/**
 *
 * @author edcracken
 */
@Named
@RequestScoped
public class JsRoutinesExecutor implements Serializable {

    @Inject
    RemoteModel remoteDao;
    @Inject
    SwitchClient switchClient;

    public FileReader validateRoutine(String realPath) throws JsRoutineNotExistsException {
        try {
            return new FileReader(realPath);
        } catch (FileNotFoundException ex) {
            throw new JsRoutineNotExistsException(ex, new ErrorDto("999", "Rutina con path " + realPath + " no ha sido encontrada!"));
        }
    }

    public String exec(FileReader routineFile, String in, String queryParamsObj) throws JsRoutineFailException, BaseException {
        try {
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("nashorn");
            Invocable inv = (Invocable) engine;
            Compilable compilable = (Compilable) engine;

            CompiledScript compiled = compilable.compile(routineFile);
            compiled.eval();
            JsRoutine jsR = inv.getInterface(JsRoutine.class);
            return jsR.exec(remoteDao, switchClient, in, queryParamsObj);
        } catch (ScriptException ex) {
            throw new JsRoutineFailException(ex, new ErrorDto("999", "Error interno en rutina: " + ex.getFileName() + "-" + ex.getColumnNumber() + ":" + ex.getLineNumber() + " - " + ex.getMessage()));
        }

    }

    public String exec(InputStream fileContent, String in, String queryParamsObj) throws JsRoutineFailException, BaseException {
        try {
            StringWriter writer = new StringWriter();
            IOUtils.copy(fileContent, writer, "UTF-8");
            String script = writer.toString();
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("nashorn");
            Invocable inv = (Invocable) engine.eval(script);
            JsRoutine jsR = inv.getInterface(JsRoutine.class);
            return jsR.exec(remoteDao, switchClient, in, queryParamsObj);
        } catch (ScriptException ex) {
            throw new JsRoutineFailException(ex, new ErrorDto("999", "Error interno en rutina: " + ex.getFileName() + "-" + ex.getColumnNumber() + ":" + ex.getLineNumber() + " - " + ex.getMessage()));
        } catch (IOException ex) {
            throw new JsRoutineFailException(ex, new ErrorDto("999", "Error al leer contenido masivo de rutina! "));
        }

    }

}
