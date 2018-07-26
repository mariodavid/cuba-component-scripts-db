package de.diedavids.cuba.scriptsdb.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.cuba.core.entity.ScheduledTask;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Extends;
import com.haulmont.cuba.core.global.PersistenceHelper;

@Entity(name = "ddcsd$DbScriptScheduledTask")
@Extends(ScheduledTask.class)
public class DbScriptScheduledTask extends ScheduledTask {
    private static final long serialVersionUID = 7453258943150610806L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DB_SCRIPT_ID")
    protected Script dbScript;

    public void setDbScript(Script dbScript) {
        this.dbScript = dbScript;
    }

    public Script getDbScript() {
        return dbScript;
    }



    @Override
    @MetaProperty(related = "dbScript")
    public String name() {
        String name = super.name();

        if (name == null && PersistenceHelper.isLoaded(this, "dbScript") && dbScript != null) {
            return dbScript.getName();
        }
        else {
            return name;
        }

    }
}