package com.example.wpa_alpha.PersistenceModels;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Torony {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "darab")
    private int darab;
    @Basic
    @Column(name = "teljesitmeny")
    private int teljesitmeny;
    @Basic
    @Column(name = "kezdev")
    private int kezdev;
    @Basic
    @Column(name = "helyszinid")
    private int helyszinid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDarab() {
        return darab;
    }

    public void setDarab(int darab) {
        this.darab = darab;
    }

    public int getTeljesitmeny() {
        return teljesitmeny;
    }

    public void setTeljesitmeny(int teljesitmeny) {
        this.teljesitmeny = teljesitmeny;
    }

    public int getKezdev() {
        return kezdev;
    }

    public void setKezdev(int kezdev) {
        this.kezdev = kezdev;
    }

    public int getHelyszinid() {
        return helyszinid;
    }

    public void setHelyszinid(int helyszinid) {
        this.helyszinid = helyszinid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Torony torony = (Torony) o;
        return id == torony.id && darab == torony.darab && teljesitmeny == torony.teljesitmeny && kezdev == torony.kezdev && helyszinid == torony.helyszinid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, darab, teljesitmeny, kezdev, helyszinid);
    }
}
