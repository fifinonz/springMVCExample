package com.springapp.dao.impl;

import com.springapp.dao.PatientDao;
import com.springapp.model.Patient;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dhis on 07/05/15.
 */
public class PatientDaoImpl  implements PatientDao {
    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    @Override
    public int insertRow(Patient patient) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(patient);
        tx.commit();
        Serializable pId = session.getIdentifier(patient);
        session.close();
        return (Integer) pId;
    }

    @Override
    public Patient getPatientBypId(int pId) {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Patient.class);
        criteria.add(Restrictions.eq("pId", pId));
        Patient patient;
        patient = (Patient) criteria.uniqueResult();
        session.close();
        return patient;
    }

    @Override
    public List<Patient> getList() {
        Session session = sessionFactory.openSession();
        @SuppressWarnings("unchecked")
        List<Patient> patientList = session.createQuery("from Patient").list();
        session.close();
        return patientList;
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
