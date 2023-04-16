package com.example.jpa_lab_2.presentation.controllers;

import com.example.jpa_lab_2.domain.entity.Department;
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

import java.util.List;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

    private final EmployeeService employeeService;
    private final DepartmentService departmentService;
    private final OrganisationService organisationService;

    @Autowired
    public DepartmentController(EmployeeService employeeService, DepartmentService departmentService, OrganisationService organisationService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
        this.organisationService = organisationService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("departments",departmentService.findAll());
        return "departments/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") long id, Model model) {
        Department department = departmentService.findOne(id);
        model.addAttribute("department",department);
        model.addAttribute("departmentHead",department.getDepartmentHead());
        return "departments/show";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") long id, Model model) {
        model.addAttribute("department",departmentService.findOne(id));
        return "departments/edit";
    }

    @GetMapping("/new")
    public String newEmployee(Model model) {
        model.addAttribute("department",new Department());
        return "departments/new";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("department") @Valid Department department, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "departments/new";
        }

        departmentService.save(department);
        return "redirect:/departments";
    }

    @PatchMapping("/{id}/edit")
    public String update(@ModelAttribute("department") @Valid Department department, BindingResult bindingResult, @PathVariable("id") long id) {

        if (bindingResult.hasErrors()) {
            return "departments/edit";
        }

        departmentService.update(id,department);
        return "redirect:/departments";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        employeeService.deleteAll(employeeService.findByDepartment(departmentService.findOne(id)));
        departmentService.delete(departmentService.findOne(id));
        return "redirect:/departments";
    }

    @ModelAttribute("organisations")
    public List<Organisation> commonData() {
        return organisationService.findAll();
    }

}
