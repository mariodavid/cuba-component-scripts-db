/*
 * Copyright (c) 2008-2016 Haulmont.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package de.diedavids.cuba.scriptsdb.core;

import com.haulmont.cuba.core.entity.ScheduledTask;
import com.haulmont.cuba.core.global.*;
import de.diedavids.cuba.scriptsdb.entity.Script;
import groovy.lang.Binding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.*;

public class ScriptsDbRunnerBean extends com.haulmont.cuba.core.app.scheduling.RunnerBean {

    @Inject
    DataManager dataManager;

    private static final Logger log = LoggerFactory.getLogger(ScriptsDbRunnerBean.class);

    @Override
    protected Object executeTask(ScheduledTask task) {
        switch (task.getDefinedBy()) {
            case BEAN:
                return super.executeTask(task);
            case CLASS:
                return super.executeTask(task);
            case SCRIPT: {
                return runScript(task);
            }
            default:
                return super.executeTask(task);


        }
    }

    protected Object runScript(ScheduledTask task) {

        UUID dbScriptId = tryToGetScriptDbId(task);

        if (dbScriptId != null) {
            Script dbScript = loadDbScript(dbScriptId);
            return scripting.evaluateGroovy(dbScript.getContent(), new Binding());
        }
        else {
            return scripting.runGroovyScript(task.getScriptName(), Collections.<String, Object>emptyMap());
        }
    }

    private Script loadDbScript(UUID dbScriptId) {
        return dataManager.load(Script.class).id(dbScriptId).one();
    }


    private UUID tryToGetScriptDbId(ScheduledTask task) {
        try{
            return UUID.fromString(task.getScriptName());
        } catch (IllegalArgumentException exception){
            return null;
        }
    }
}
