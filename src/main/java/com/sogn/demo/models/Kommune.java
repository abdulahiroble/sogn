package com.sogn.demo.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Kommune {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int kommuneid;

    @Column(name = "kommunenavn")
    private String kommunenavn;

    // @Column(name = "totalsmitte")
    // private int totalsmitte;

    @OneToMany
    @JoinColumn(name = "kommuneid")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "sognid")
    private Set<Sogn> sogn = new HashSet<>();

    public Kommune() {
    }

    public Kommune(String kommunenavn) {
        this.kommunenavn = kommunenavn;
    }

    public int getKommuneid() {
        return kommuneid;
    }

    public void setKommuneid(int kommuneid) {
        this.kommuneid = kommuneid;
    }

    public String getKommunenavn() {
        return kommunenavn;
    }

    public void setKommunenavn(String kommunenavn) {
        this.kommunenavn = kommunenavn;
    }

    public Set<Sogn> getSogn() {
        return sogn;
    }

    public void setSogn(Set<Sogn> sogn) {
        this.sogn = sogn;
    }

    // public int getTotalsmitte() {
    // return totalsmitte;
    // }

    // public void setTotalsmitte(int totalsmitte) {
    // this.totalsmitte = totalsmitte;
    // }
}
