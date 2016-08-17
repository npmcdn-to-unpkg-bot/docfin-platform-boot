package com.docfin.platform.model;

import com.docfin.platform.DbSettings;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by amit on 8/16/16.
 */
@Entity
@Table(name = "STATE", schema = "DOCFIN_PLATFORM")
public class State extends AbstractEntity {

    @NotNull
    @Column(name = "NAME", length = DbSettings.SHORT_TEXT)
    private String name;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private Country country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
