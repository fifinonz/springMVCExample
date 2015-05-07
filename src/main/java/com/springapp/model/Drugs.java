package com.springapp.model;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Muthoni on 07/05/15.
 */


@Table(name="prescription")
public class Drugs {
    @Id
    @GeneratedValue
    private int DId;

    @Column(name = "drug_name")
    private String dname;

    private int PId;

    /* getters and setters */

    public int getDId() {
        return DId;
    }

    public void setDId(int DId) {
        this.DId = DId;


    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public int getPId() {
        return PId;
    }

    public void setPId(int PId) {
        this.PId = PId;
    }
}
}
