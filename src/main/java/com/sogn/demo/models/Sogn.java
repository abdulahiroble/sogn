package com.sogn.demo.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
public class Sogn {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sognid;


    @Column(name = "sognkode")
    private int sognkode;

    @Column(name = "navn")
    private String navn;

    @Column(name = "smittetryk")
    private int smittetryk;



    @ManyToOne
    @JoinColumn(name = "kommuneid")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "kommuneid")
    private Kommune kommune;


    public Sogn() {
    }

    public Sogn(int sognid, int sognkode, String navn, int smittetryk) {
        this.sognid = sognid;
        this.sognkode = sognkode;
        this.navn = navn;
        this.smittetryk = smittetryk;
    }

    public int getSognid() {
        return sognid;
    }

    public void setSognid(int sognid) {
        this.sognid = sognid;
    }

    public int getSognkode() {
        return sognkode;
    }

    public void setSognkode(int sognkode) {
        this.sognkode = sognkode;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getSmittetryk() {
        return smittetryk;
    }

    public void setSmittetryk(int smittetryk) {
        this.smittetryk = smittetryk;
    }

    public Kommune getKommune() {
        return kommune;
    }

    public void setKommune(Kommune kommune) {
        this.kommune = kommune;
    }
}
