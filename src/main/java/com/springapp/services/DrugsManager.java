package com.springapp.services;

import com.springapp.model.Drugs;

import java.util.List;

/**
 * Created by Muthoni on 07/05/15.
 */
public interface DrugsManager
{

    public int insertRow(Drugs drug);

    public Drugs getDrugById(int dId);



    Drugs getDrugsById(int dId);

    public List<Drugs> getList();

    public int updateRow(Drugs drug);

    public int deleteRow(int dId);

}
