package com.springapp.services;

import com.springapp.model.Patient;

import java.util.List;

/**
 * Created by Muthoni on 07/05/15.
 */
public interface PatientManager
{

    public int insertRow(Patient patient);

    public Patient getPatientById(int pId);

    public List<Patient> getList();

    public int updateRow(Patient patient);

    public int deleteRow(int pId);
}
