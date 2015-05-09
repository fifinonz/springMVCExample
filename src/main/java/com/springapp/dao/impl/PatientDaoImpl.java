package com.springapp.dao.impl;

import com.springapp.dao.PatientDao;
import com.springapp.model.Patient;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Muthoni on 07/05/15.
 */

@Repository
public class PatientDaoImpl  implements PatientDao
{

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }

    public void setSessionFactory (SessionFactory sessionFactory)
    {
        this.sessionFactory=sessionFactory;
    }


    @Override
    public void addPatient(Patient patient) {
        Session session = this.getSessionFactory().getCurrentSession();
        session.persist(patient);

    }

    @Override
    public Patient getPatientBypId(int pId) {
        Session session = getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Patient.class);
        criteria.add(Restrictions.eq("pId", pId));
        Patient patient;
        patient = (Patient) criteria.uniqueResult();

        return patient;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Patient> getList() {
        Session session = sessionFactory.getCurrentSession();


        List<Patient> patientList = session.createQuery("from patient").list();

        return patientList;
    }

    @Override
    public void updateRow(Patient patient) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(patient);
    }

    @Override
    public void deleteRow(int pId) {
        Session session=this.sessionFactory.getCurrentSession();
        Patient patient = (Patient) session.load(Patient.class, new Integer(pId));
        if(null!=patient){
            session.delete(patient);
        }

           }


}
