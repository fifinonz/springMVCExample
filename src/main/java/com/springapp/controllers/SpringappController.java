package com.springapp.controllers;

import com.springapp.model.Drugs;
import com.springapp.model.Patient;
import com.springapp.services.DrugsManager;
import com.springapp.services.PatientManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;

import java.util.List;

/**
 * Created by Muthoni on 06/05/15.
 */

@Controller
public class SpringappController {

    private PatientManager patientManager;

    @Autowired(required = true)
    public void setPatientManager(PatientManager pm) {
        this.patientManager = pm;
    }

    DrugsManager drugsManager;

    @Autowired(required = true)
    public void setDrugsManager(DrugsManager dm) {
        this.drugsManager = dm;
    }

    @RequestMapping(value = "/patient", method = RequestMethod.GET)
    public String listPatients(Model model) {
        model.addAttribute("patient", new Patient());
        model.addAttribute("listPatients", this.patientManager.getList());

        return "patient";
    }


    @RequestMapping(value = "/patient/add", method = RequestMethod.POST)
    public String addPatient(@ModelAttribute("patient") Patient patient) {

        if (patient.getpId() == 0) {
            //new patient
            this.patientManager.addPatient(patient);
        } else {
            //existing person, update
            this.patientManager.updateRow(patient);
        }
        return "redirect:/patient";

    }

    @RequestMapping("/remove/{pId}")
    public String removePatient(@PathVariable("pId") int id) {
        this.patientManager.deleteRow(id);
        return "redirect:/patients";
    }

    @RequestMapping("/edit/{pId}")
    public String editPerson(@PathVariable("pId") int id, Model model) {
        model.addAttribute("patient", this.patientManager.getPatientById(id));
        model.addAttribute("listPersons", this.patientManager.getList());
        return "patient";
    }


    @RequestMapping("/prescribe")
    public ModelAndView prescribe( @RequestParam(value = "pId", required = false) Integer pId,
                                   @RequestParam(value = "drug_name", required = false) String drug_name
    ) {

    ModelAndView model = new ModelAndView();

    Drugs drug = new Drugs();
    drug.setDrug_name(drug_name);
    drug.setpId(pId);
    drugsManager.insertRow(drug);

    model.addObject("drugList", drugsManager.getList());
    model.addObject("msg","Patient Allocated drug Successfully");
    model.setViewName("drugList");
    return model;
    }

}
