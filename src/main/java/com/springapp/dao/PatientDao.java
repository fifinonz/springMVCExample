package com.springapp.dao;

import com.springapp.model.Patient;

import java.util.List;

/**
 * Created by dhis on 07/05/15.
 */
public interface PatientDao {

    public int insertRow(Patient patient);

    public Patient getPatientBypId(int pId);

    public List<Patient> getList();

    public int updateRow(Patient patient);

    public int deleteRow(int pId);
}
