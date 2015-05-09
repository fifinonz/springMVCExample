package com.springapp.services.impl;

import com.springapp.dao.PatientDao;
import com.springapp.model.Patient;


import java.util.List;

import com.springapp.services.PatientManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Muthoni on 07/05/15.
 */

@Service
public class PatientManagerImpl implements PatientManager
{

    private PatientDao patientDao;

    public void setPatientDao(PatientDao patientDao)
    {
        this.patientDao=patientDao;
    }

    @Override
    @Transactional
    public void addPatient(Patient patient) {
        this.patientDao.addPatient(patient);
    }

    @Override
    @Transactional
    public Patient getPatientById(int pId) {

        return this.patientDao.getPatientBypId(pId);
    }

    @Override
    @Transactional
    public List<Patient> getList()
    {
        return this.patientDao.getList();
    }

    @Override
    @Transactional
    public void updateRow(Patient patient) {
        this.patientDao.updateRow(patient);
    }

    @Override
    @Transactional
    public void deleteRow (int pId) {
        this.patientDao.deleteRow(pId);
    }
}
