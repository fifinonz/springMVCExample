package com.springapp.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;


/**
 * Created by Muthoni on 07/05/15.
 */



    @Entity
    @Table(name="patient")
    public class Patient
{
        @Id
        @GeneratedValue
        private int pId;

        @Column(name = "first_name")
        private String first_name;

        private String last_name;

        private Date dob;



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





}



