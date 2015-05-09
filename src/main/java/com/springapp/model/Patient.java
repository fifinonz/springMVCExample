package com.springapp.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;


/**
 * Created by Muthoni on 07/05/15.
 */



    @Entity
    @Table(name="patient")
    public class Patient
{
        @Id
        @GeneratedValue
        @Column(name = "pId")
        private int pId;


        private String first_name;


        private String last_name;


        private Date dob;

/*Entity Mapping*/

    @OneToMany(cascade =CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "patient")
    private List<Drugs> drugs;

    /* getters and setters */

        public int getpId() {
            return pId;
        }

        public void setpId(int pId) {
            this.pId = pId;
        }

        public String getFirst_name() {
            return first_name;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public String getLast_name() {
            return last_name;
        }

        public void setLast_name(String last_name) {
            this.last_name = last_name;
        }

        public Date getDate() {
            return dob;
        }

        public void setDate(Date dob) {
            this.dob = dob;
        }

    public List<Drugs> getDrug() {
        return drugs;
    }
    public void setDrug(List<Drugs> drugs) {
        this.drugs = drugs;
    }



}



