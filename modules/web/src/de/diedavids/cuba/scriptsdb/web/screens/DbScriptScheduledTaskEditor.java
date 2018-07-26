package de.diedavids.cuba.scriptsdb.web.screens;

import com.haulmont.cuba.core.entity.ScheduledTask;
import com.haulmont.cuba.core.entity.ScheduledTaskDefinedBy;
import com.haulmont.cuba.gui.app.core.scheduled.ScheduledTaskEditor;
import com.haulmont.cuba.gui.components.*;
import de.diedavids.cuba.scriptsdb.entity.DbScriptScheduledTask;

import javax.inject.Inject;
import java.util.Map;

public class DbScriptScheduledTaskEditor extends ScheduledTaskEditor {


    @Inject
    protected Label dbScriptLabel;

    @Inject
    protected LookupField dbScriptField;


    @Override
    public void init(Map<String, Object> params) {
        super.init(params);

        definedByField.addValueChangeListener(e -> {
            if (ScheduledTaskDefinedBy.SCRIPT == e.getValue()) {
                clear(beanNameField, methodNameField, classNameField);
                hideAll();
                show(scriptNameField, scriptNameLabel, dbScriptField, dbScriptLabel);
                scriptNameField.setRequired(false);
            }
        });
    }

    @Override
    protected boolean preCommit() {

        DbScriptScheduledTask item = (DbScriptScheduledTask) getItem();
        if (scriptSelected()) {

            if (item.getScriptName() == null && item.getDbScript() == null) {
                showNotification("Either a script name or a DB script has to be selected", NotificationType.TRAY);
                return false;
            }
            else if (item.getScriptName() != null && item.getDbScript() != null) {
                showNotification("Only a script name or a DB script can be selected, not both", NotificationType.TRAY);
                return false;
            }

        }
        return super.preCommit();

    }

    private boolean scriptSelected() {
        return getItem().getDefinedBy().equals(ScheduledTaskDefinedBy.SCRIPT);
    }
}