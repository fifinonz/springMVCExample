package com.springapp.dao.impl;

import com.springapp.dao.DrugsDao;
import com.springapp.model.Drugs;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Muthoni on 07/05/15.
 */
public class DrugsDaoImpl implements DrugsDao
{

    @Autowired
    SessionFactory sessionFactory;
    private int dId;

    @Transactional
    @Override
    public int insertRow(Drugs drug) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(drug);
        tx.commit();
        Serializable dId = session.getIdentifier(drug);
        session.close();
        return (Integer) dId;
    }

    @Override
    public Drugs getDrugById(int dId) {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Drugs.class);
        criteria.add(Restrictions.eq("dId", dId));
        Drugs drug = (Drugs) criteria.uniqueResult();
        session.close();
        return drug;
    }

    @Override
    public List<Drugs> getList() {
        Session session = sessionFactory.openSession();
        @SuppressWarnings("unchecked")
        List<Drugs> drugList = session.createQuery("from drugs").list();
        session.close();
        return drugList;
    }

    @Override
    public int updateRow(Drugs drug) {
        return 0;
    }

    @Override
    public int deleteRow(int dId) {
        return 0;
    }
}


