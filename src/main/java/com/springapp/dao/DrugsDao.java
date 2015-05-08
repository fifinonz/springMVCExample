package com.springapp.dao;

import com.springapp.model.Drugs;

import java.util.List;

/**
 * Created by Muthoni on 07/05/15.
 */
public interface DrugsDao {

    public int insertRow(Drugs drug);

    public Drugs getDrugsById(int dId);

    public Drugs getPatientById(int pId);

    public List<Drugs> getList();

    public int updateRow(Drugs drug);

    public int deleteRow(int dId);
}
