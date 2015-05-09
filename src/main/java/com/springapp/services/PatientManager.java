package com.springapp.services;

import com.springapp.model.Patient;

import java.util.List;

/**
 * Created by Muthoni on 07/05/15.
 */
public interface PatientManager
{

    public int addPatient(Patient patient);

    public Patient getPatientById(int pId);

    public List<Patient> getList();

    public void updateRow(Patient patient);

    public void deleteRow(int pId);
}
