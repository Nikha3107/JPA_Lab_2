package com.example.jpa_lab_2.presentation.controllers;

import com.example.jpa_lab_2.domain.entity.Department;
import com.example.jpa_lab_2.service.DepartmentService;
import com.example.jpa_lab_2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

    private final EmployeeService employeeService;
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(EmployeeService employeeService, DepartmentService departmentService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
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
    public String create(@ModelAttribute("department") Department department) {
        departmentService.save(department);
        return "redirect:/departments";
    }

    @PatchMapping("/{id}/edit")
    public String update(@ModelAttribute("employee") Department department, @PathVariable("id") long id) {
        departmentService.update(id,department);
        return "redirect:/departments";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        employeeService.deleteAll(employeeService.findByDepartment(departmentService.findOne(id)));
        departmentService.delete(departmentService.findOne(id));
        return "redirect:/departments";
    }

}
