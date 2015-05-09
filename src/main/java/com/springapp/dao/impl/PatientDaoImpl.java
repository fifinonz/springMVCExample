package com.springapp.dao.impl;

import com.springapp.dao.PatientDao;
import com.springapp.model.Patient;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Muthoni on 07/05/15.
 */

@Repository
public class PatientDaoImpl  implements PatientDao
{

    @Autowired
    private SessionFactory sessionFactory;

   /* public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
        sf.openSession();
    }

*/
    @Override
    public int addPatient(Patient patient) {
        Session session = this.sessionFactory.openSession();
        session.persist(patient);
        Serializable id = session.getIdentifier(patient);
        return (Integer) id;

    }

    @Override
    public Patient getPatientBypId(int pId) {
        Session session = this.sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Patient.class);
        criteria.add(Restrictions.eq("pId", pId));
        Patient patient;
        patient = (Patient) criteria.uniqueResult();

        return patient;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Patient> getList() {
        Session session = this.sessionFactory.openSession();


        List<Patient> patientList = session.createQuery("from patient").list();

        return patientList;
    }

    @Override
    public void updateRow(Patient patient) {
        Session session = this.sessionFactory.openSession();
        session.update(patient);
    }

    @Override
    public void deleteRow(int pId) {
        Session session=this.sessionFactory.openSession();
        Patient patient = (Patient) session.load(Patient.class, new Integer(pId));
        if(null!=patient){
            session.delete(patient);
        }

           }


}
