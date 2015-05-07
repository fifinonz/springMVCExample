package com.springapp.dao;

import com.springapp.model.Drugs;

import java.util.List;

/**
 * Created by dhis on 07/05/15.
 */
public interface DrugsDao {

    public int insertRow(Drugs drug);

    public Drugs getDrugsById(int dId);

    public List<Drugs> getList();

    public int updateRow(Drugs drug);

    public int deleteRow(int dId);
}
