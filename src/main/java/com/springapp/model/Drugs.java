package com.springapp.model;


import javax.persistence.*;


/**
 * Created by Muthoni on 07/05/15.
 */

@Entity
@Table(name="drugs")
public class Drugs
{
    @Id
    @GeneratedValue
    @Column(name = "dId")
    private int dId;

    @Column(name = "drug_name")
    private String drug_name;

    @Column(name = "pId")
    private int pId;

    /* Entity Mapping*/
    @ManyToMany
    @JoinColumn(name = "pId", insertable = false, updatable = false)
    private Patient patient;

    /* getters and setters */

    public int getDId() {
        return dId;
    }

    public void setDId(int dId) {this.dId = dId;}


    public String getDrug_name() {
        return drug_name;
    }

    public void setDrug_name(String drug_name) {
        this.drug_name = drug_name;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }
}

