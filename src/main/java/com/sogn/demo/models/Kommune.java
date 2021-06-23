package com.sogn.demo.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Kommune {

    // Sætter vores primary og auto incrementer
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int kommuneid;

    @Column(name = "kommunenavn")
    private String kommunenavn;

    // Mange til en forhold hvor en kommune har tilknytning til mange sogne hvor
    // sogne får tildelt en foreing key som er kommuneid
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
}
