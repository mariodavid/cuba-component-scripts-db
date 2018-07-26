package de.diedavids.cuba.scriptsdb.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@NamePattern("%s|name")
@Table(name = "DDCSD_SCRIPT")
@Entity(name = "ddcsd$Script")
public class Script extends StandardEntity {
    private static final long serialVersionUID = -2315636378353001773L;

    @NotNull
    @Column(name = "NAME", nullable = false)
    protected String name;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID")
    protected ScriptCategory category;

    @NotNull
    @Column(name = "CODE", nullable = false)
    protected String code;

    @Lob
    @Column(name = "DESCRIPTION")
    protected String description;

    @NotNull
    @Lob
    @Column(name = "CONTENT", nullable = false)
    protected String content;

    public void setCategory(ScriptCategory category) {
        this.category = category;
    }

    public ScriptCategory getCategory() {
        return category;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }


}