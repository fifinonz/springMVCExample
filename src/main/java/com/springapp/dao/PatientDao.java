package com.springapp.dao;

import com.springapp.model.Patient;

import java.util.List;

/**
 * Created by Muthoni on 07/05/15.
 */
public interface PatientDao

{

    public int addPatient(Patient patient);

    public Patient getPatientBypId(int pId);

    public List<Patient> getList();

    public void updateRow(Patient patient);

    public void deleteRow(int pId);
}
