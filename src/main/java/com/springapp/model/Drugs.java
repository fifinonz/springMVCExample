package com.springapp.model;

/**
 * Created by dhis on 07/05/15.
 */

@Entity
@Table(name="drugs")
public class Drugs {
    @Id
    @GeneratedValue
    private int DId;

    @Column(name = "drug_name")
    private String dname;

    private int PId;

    private String phone;

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
