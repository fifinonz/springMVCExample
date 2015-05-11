package com.springapp.controllers;

import com.springapp.model.Drugs;
import com.springapp.model.Patient;
import com.springapp.services.DrugsManager;
import com.springapp.services.PatientManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

/**
 * Created by Muthoni on 06/05/15.
 */

@Controller
public class SpringappController {

    @Autowired
    PatientManager patientManager;

    @Autowired
    DrugsManager drugsManager;

    @RequestMapping("/index")
    public String patient_details(Model model){

        model.addAttribute("message","Patient Details");
        return "details";
    }

    @RequestMapping("/drugs")
    public String prescribed(Model model){

        model.addAttribute("message", "Drug Prescriptions");
        return "drugList";

    }

    @RequestMapping("/create")
    public ModelAndView create(@RequestParam(value = "first_name", required = false) String first_name,
                               @RequestParam(value = "last_name", required = false) String last_name,
                               @RequestParam(value = "dob", required = false) java.sql.Date dob
                               ) {
        ModelAndView model = new ModelAndView();

        Patient patient = new Patient();
        patient.setFirst_name(first_name);
        patient.setLast_name(last_name);
        patient.setDate(dob);
        patientManager.insertRow(patient);
        model.addObject("listPatient", patientManager.getlist());
        model.addObject("msg","Patient Added Successfully");

        model.setViewName("details");
        return model;
    }

    @RequestMapping(value="/drug", method=RequestMethod.GET)
    public ModelAndView drug( @RequestParam(value = "pId", required = false) Integer pId,
                                    @RequestParam(value = "drug_name", required = false) String drug_name
    ) {
        ModelAndView model = new ModelAndView("drug");

        Drugs drug = new Drugs();
        drug.setDrug_name(drug_name);
        drug.setpId(pId);
        drugsManager.insertRow(drug);
        model.addObject("listDrugs", drugsManager.getList());
        model.addObject("msg","Patient Prescribed Drug Successfully");
        model.setViewName("drugList");
        return model;
    }


    @RequestMapping("/list")
    public ModelAndView list()

    {
        ModelAndView model = new ModelAndView();
        List<Drugs> drugsList = drugsManager.getList();
        model.addObject("drugsList", drugsList);

        model.setViewName("display");
        return model;


      /*  List<Patient> patientList =  patientManager.getList();
        List<Drugs> drugsList =  drugsManager.getList();

        for (int i = 0; i < patientList.size(); i++) {
            Patient patient = patientList.get(i);

            if(drugsList.contains(drugsManager.getPatientById(i))) {
                System.out.println(patient.getFirst_name() + " " + patient.getLast_name() + " " + drugsManager.getDrugById(i));
                System.out.println("\n\n**********************************\n\n");
            }
        }*/


    }

}
