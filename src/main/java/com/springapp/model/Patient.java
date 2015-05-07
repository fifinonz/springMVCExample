package com.springapp.model;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by dhis on 07/05/15.
 */



    @Entity
    @Table(name="employee")
    public class Patient {
        @Id
        @GeneratedValue
        private int PId;

        @Column(name = "first_name")
        private String first_name;

        private String last_name;

        private Date dob;

        private Timestamp timeEntry;

        public int getPId() {
            return PId;
        }

        public void setPId(int PId) {
            this.PId = PId;
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

        public Timestamp getTimeEntry() {
            return timeEntry;
        }

        public void setTimeEntry(Timestamp timeEntry) {
            this.timeEntry = timeEntry;
        }


}



