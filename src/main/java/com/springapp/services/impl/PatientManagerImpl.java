package com.springapp.services.impl;

import com.springapp.dao.PatientDao;
import com.springapp.model.Patient;


import java.util.List;

import com.springapp.services.PatientManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Muthoni on 07/05/15.
 */

@Service
public class PatientManagerImpl implements PatientManager
{

    @Autowired
    private PatientDao patientDao;

    public void setPatientDao(PatientDao dao)
    {
        this.patientDao=dao;
    }


    @Override
    @Transactional
    public int addPatient(Patient patient)
    {
        this.patientDao.addPatient(patient);
        return patient.getpId();
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
