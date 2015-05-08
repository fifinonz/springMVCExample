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

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by Muthoni on 06/05/15.
 */

@Controller
public class springapp {

    @Autowired
    PatientManager patientManager;
    DrugsManager drugsManager;

    @RequestMapping("/welcome")
    public String hello(Model model){

        model.addAttribute("message","HELLO WORLD");
        return "hello";
    }

    @RequestMapping("/index")
    public ModelAndView hello1(){

        ModelAndView model = new ModelAndView();
        model.addObject("msg","WELCOME TO SPRING MVC");
        model.setViewName("hello");

        return model;
    }

    @RequestMapping("/create")
    public ModelAndView create(@RequestParam(value = "first_name", required = false) String first_name,
                               @RequestParam(value = "last_name", required = false) String last_name,
                               @RequestParam(value = "dob", required = false) Date dob,
                               @RequestParam(value = "timeEntry", required = false) Timestamp timeEntry,
                               @RequestParam(value = "drug_name", required = false) String drug_name,
                               @RequestParam(value = "pId", required = false) Integer pId
    ){
        ModelAndView model = new ModelAndView();

        Patient patient = new Patient();
        patient.setFirst_name(first_name);
        patient.setLast_name(last_name);
        patient.setDate(dob);
        patient.setTimeEntry(timeEntry);
        patientManager.insertRow(patient);

        Drugs drug = new Drugs();
        drug.setDrug_name(drug_name);
        drug.setpId(pId);
        drugsManager.insertRow(drug);



    model.setViewName("hello");
    return model;
}

    @RequestMapping("/list")
    public void list(){

        List<Patient> patientList =  patientManager.getList();
        List<Drugs> drugsList =  drugsManager.getList();

        for (int i = 0; i < patientList.size(); i++) {
            Patient patient = patientList.get(i);

            if(drugsList.contains(patient.getpId())) {
                System.out.println(patient.getFirst_name() + " " + patient.getLast_name() + " " + drugsManager.getDrugById(i));
                System.out.println("\n\n**********************************\n\n");
            }
        }


    }

}
