package com.springapp.services.impl;

import com.springapp.dao.PatientDao;
import com.springapp.model.Patient;
import com.springapp.services.PatientManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Muthoni on 07/05/15.
 */
public class PatientManagerImpl implements PatientManager {

    @Autowired
    PatientDao patientDao;

    @Override
    public int insertRow(Patient patient) {
        return patientDao.insertRow(patient);
    }

    @Override
    public Patient getPatientById(int pId) {
        return patientDao.getPatientBypId(pId);
    }

    @Override
    public List<Patient> getList() {
        return patientDao.getList();
    }

    @Override
    public int updateRow(Patient patient) {
        return 0;
    }

    @Override
    public int deleteRow(int pId) {
        return 0;
    }
}
