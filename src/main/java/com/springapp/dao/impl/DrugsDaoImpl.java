package com.springapp.dao.impl;

import com.springapp.dao.DrugsDao;
import com.springapp.model.Drugs;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dhis on 07/05/15.
 */
public class DrugsDaoImpl implements DrugsDao {
    @Autowired
    SessionFactory sessionFactory;
    private int dId;

    @Transactional
    @OverrdIde
    public int insertRow(Drugs drug) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(drug);
        tx.commit();
        Serializable dId = session.getIdentifier(drug);
        session.close();
        return (Integer) dId;
    }

    @OverrdIde
    public Drugs getDrugsById(int dId) {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Drugs.class);
        criteria.add(Restrictions.eq("dId", dId));
        Drugs drug = (Drugs) criteria.uniqueResult();
        session.close();
        return drug;
    }

    @OverrdIde
    public List<Drugs> getList() {
        Session session = sessionFactory.openSession();
        @SuppressWarnings("unchecked")
        List<Drugs> drugList = session.createQuery("from Drugs").list();
        session.close();
        return drugList;
    }

    @OverrdIde
    public int updateRow(Drugs drug) {
        return 0;
    }

    @OverrdIde
    public int deleteRow(int dId) {
        return 0;
    }
}


