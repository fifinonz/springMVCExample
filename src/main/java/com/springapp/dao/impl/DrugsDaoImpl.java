package com.springapp.dao.impl;

import com.springapp.dao.DrugsDao;
import com.springapp.model.Drugs;
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
public class DrugsDaoImpl implements DrugsDao
{
    @Autowired
    private SessionFactory sessionFactory;

   /* public SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }

    public void setSessionFactory (SessionFactory sessionFactory)
    {
        this.sessionFactory=sessionFactory;
        sessionFactory.openSession();
    }

*/
    @Override
    public int addDrug(Drugs drug) {
        Session session = this.sessionFactory.openSession();
        session.persist(drug);
        Serializable id = session.getIdentifier(drug);
        return (Integer) id;

    }

    @Override
    public Drugs getDrugBydId(int dId) {
        Session session = this.sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Drugs.class);
        criteria.add(Restrictions.eq("dId", dId));
        Drugs drug;
        drug = (Drugs)criteria.uniqueResult();

        return drug;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Drugs> getList() {
        Session session = sessionFactory.getCurrentSession();


        List<Drugs> drugsList = session.createQuery("from drugs").list();

        return drugsList;
    }

    @Override
    public void updateRow(Drugs drug) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(drug);
    }

    @Override
    public void deleteRow(int dId) {
        Session session=this.sessionFactory.getCurrentSession();
        Drugs drug = (Drugs) session.load(Drugs.class, new Integer(dId));
        if(null!=drug){
            session.delete(drug);
        }

    }


}
