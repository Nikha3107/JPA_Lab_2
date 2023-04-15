package com.example.jpa_lab_2.presentation.controllers;

import com.example.jpa_lab_2.domain.entity.Organisation;
import com.example.jpa_lab_2.service.DepartmentService;
import com.example.jpa_lab_2.service.EmployeeService;
import com.example.jpa_lab_2.service.OrganisationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/organisations")
public class OrganisationController {

    private final OrganisationService organisationService;
    private final DepartmentService departmentService;
    private final EmployeeService employeeService;


    @Autowired
    public OrganisationController(OrganisationService organisationService, DepartmentService departmentService, EmployeeService employeeService) {
        this.organisationService = organisationService;
        this.departmentService = departmentService;
        this.employeeService = employeeService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("organisations", organisationService.findAll());
        return "organisations/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") long id, Model model) {
        model.addAttribute("organisation", organisationService.findOne(id));
        return "organisations/show";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") long id, Model model) {
        model.addAttribute("organisation", organisationService.findOne(id));
        return "organisations/edit";
    }

    @GetMapping("/new")
    public String newEmployee(Model model) {
        model.addAttribute("organisation",new Organisation());
        return "organisations/new";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("organisation") @Valid Organisation organisation, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "organisations/new";
        }

        organisationService.save(organisation);
        return "redirect:/organisations";
    }

    @PatchMapping("/{id}/edit")
    public String update(@ModelAttribute("organisation") @Valid Organisation organisation, BindingResult bindingResult, @PathVariable("id") long id) {

        if (bindingResult.hasErrors()) {
            return "organisations/edit";
        }

        organisationService.update(id,organisation);
        return "redirect:/organisations";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        employeeService.deleteAll(employeeService.findByDepartment(departmentService.findOne(id)));
        departmentService.deleteAll(departmentService.findByOrganisation(organisationService.findOne(id)));
        organisationService.delete(organisationService.findOne(id));
        return "redirect:/organisations";
    }



}
