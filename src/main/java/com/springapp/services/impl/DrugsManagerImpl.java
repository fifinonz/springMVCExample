package com.springapp.services.impl;

import com.springapp.dao.DrugsDao;
import com.springapp.model.Drugs;
import com.springapp.services.DrugsManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Muthoni on 07/05/15.
 */
public abstract class DrugsManagerImpl implements DrugsManager{

    @Autowired
    DrugsDao drugDao;

    @Override
    public int insertRow(Drugs drug) {
        return drugDao.insertRow(drug);
    }

    @Override
    public Drugs getDrugsById(int dId) {
        return drugDao.getDrugsById(dId);
    }

    @Override
    public List<Drugs> getList() {
        return drugDao.getList();
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
