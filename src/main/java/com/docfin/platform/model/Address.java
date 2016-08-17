package com.docfin.platform.model;

import com.docfin.platform.DbSettings;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by amit on 8/16/16.
 */
@Entity
@Table(name = "ADDRESS", schema = "DOCFIN_PLATFORM")
public class Address extends AbstractEntity{

    @NotNull
    @Column(name = "STREET", length = DbSettings.SHORT_TEXT)
    private String street;

    @NotNull
    @Column(name = "CITY", length = DbSettings.SHORT_TEXT)
    private String city;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private State state;

    @NotNull
    @Column(name = "ZIPCODE", length = DbSettings.SHORT_TEXT)
    private String zipCode;


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
