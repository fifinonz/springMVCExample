package com.springapp.services.impl;

import com.springapp.dao.DrugsDao;
import com.springapp.model.Drugs;
import com.springapp.services.DrugsManager;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Muthoni on 07/05/15.
 */
public  class DrugsManagerImpl implements DrugsManager
{

    private DrugsDao drugDao;

    public void setDrugsDao(DrugsDao drugDao)
    {
        this.drugDao=drugDao;
    }

    @Override
    @Transactional
    public void addDrug(Drugs drug) {
        this.drugDao.addDrug(drug);
    }

    @Override
    @Transactional
    public Drugs getDrugById(int dId) {

        return this.drugDao.getDrugBydId(dId);
    }


    @Override
    @Transactional
    public List<Drugs> getList()
    {
        return this.drugDao.getList();
    }

    @Override
    @Transactional
    public void updateRow(Drugs drug) {
        this.drugDao.updateRow(drug);
    }

    @Override
    @Transactional
    public void deleteRow (int pId) {
        this.drugDao.deleteRow(pId);
    }
}
