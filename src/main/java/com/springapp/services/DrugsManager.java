package com.springapp.services;

import com.springapp.model.Drugs;

import java.util.List;

/**
 * Created by Muthoni on 07/05/15.
 */
public interface DrugsManager
{

    public void addDrug(Drugs drug);

    public Drugs getDrugById(int dId);

   /* public Drugs getPatientById(int pId);*/

    public List<Drugs> getList();

    public void updateRow(Drugs drug);

    public void deleteRow(int dId);

}
