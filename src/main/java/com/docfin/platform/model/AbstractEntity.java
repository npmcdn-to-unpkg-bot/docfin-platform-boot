package com.docfin.platform.model;


import com.docfin.platform.DbSettings;
import org.springframework.data.annotation.*;
import org.springframework.data.annotation.Version;

import javax.persistence.*;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by amit on 8/16/16.
 */
@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @CreatedDate
    @Column(name = "CREATED_ON", updatable = false)
    protected Date createdOn;

    @NotNull
    @CreatedBy
    @Column(name = "CREATED_BY", updatable = false, length = DbSettings.MEDIUM_TEXT)
    protected String createdBy;

    @NotNull
    @Version
    @LastModifiedDate
    @Column(name = "LAST_MODIFIED_ON")
    protected Date lastModifiedOn;

    @NotNull
    @LastModifiedBy
    @Column(name = "LAST_MODIFIED_BY", length = DbSettings.MEDIUM_TEXT)
    protected String lastModifiedBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getLastModifiedOn() {
        return lastModifiedOn;
    }

    public void setLastModifiedOn(Date lastModifiedOn) {
        this.lastModifiedOn = lastModifiedOn;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }
}
