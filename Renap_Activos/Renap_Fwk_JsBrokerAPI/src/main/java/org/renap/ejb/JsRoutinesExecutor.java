/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.renap.ejb;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleBindings;
import org.apache.commons.io.IOUtils;
import org.renap.infrastructure.JsRoutine;
import org.renap.infrastructure.exceptions.JsRoutineFailException;
import org.renap.infrastructure.exceptions.JsRoutineNotExistsException;
import org.renap.infrastructure.integrations.RemoteDao;
import org.renap.infrastructure.integrations.SwitchClient;

/**
 *
 * @author edcracken
 */
@Stateless
public class JsRoutinesExecutor {

    @Inject
    RemoteDao remoteDao;
    @Inject
    SwitchClient switchClient;

    public FileReader validateRoutine(String realPath) throws JsRoutineNotExistsException {
        try {
            if (!new File(realPath).exists()) {
                throw new JsRoutineNotExistsException();
            }
            return new FileReader(realPath);
        } catch (FileNotFoundException ex) {
            throw new JsRoutineNotExistsException();
        }
    }

    public String exec(FileReader routineFile, String in) throws JsRoutineFailException {
        try {
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("nashorn");
            Invocable inv = (Invocable) engine;
            Compilable compilable = (Compilable) engine;
            
            CompiledScript compiled = compilable.compile(routineFile);
            compiled.eval();
            JsRoutine jsR = inv.getInterface(JsRoutine.class);
            return jsR.exec(remoteDao, switchClient, in);
        } catch (ScriptException ex) {
            throw new JsRoutineFailException(ex);
        }

    }

    public String exec(InputStream fileContent, String in) throws JsRoutineFailException {
        try {
            StringWriter writer = new StringWriter();
            IOUtils.copy(fileContent, writer, "UTF-8");
            String script = writer.toString();
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("nashorn");
            Invocable inv = (Invocable) engine.eval(script);
            JsRoutine jsR = inv.getInterface(JsRoutine.class);
            return jsR.exec(remoteDao, switchClient, in);
        } catch (ScriptException | IOException ex) {
            throw new JsRoutineFailException(ex);
        }

    }

}
