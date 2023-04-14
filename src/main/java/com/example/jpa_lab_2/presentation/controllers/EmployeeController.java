package com.example.jpa_lab_2.presentation.controllers;

import com.example.jpa_lab_2.domain.entity.Employee;
import com.example.jpa_lab_2.service.DepartmentService;
import com.example.jpa_lab_2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final DepartmentService departmentService;

    @Autowired
    public EmployeeController(EmployeeService employeeService, DepartmentService departmentService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("employees",employeeService.findAll());
        return "employees/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") long id, Model model) {
        model.addAttribute("employee",employeeService.findOne(id));
        model.addAttribute("departmentId",employeeService.findOne(id).getDepartment().getId());
        return "employees/show";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") long id, Model model) {
        model.addAttribute("employee",employeeService.findOne(id));
        model.addAttribute("departments",departmentService.findAll());
        return "employees/edit";
    }

    @GetMapping("/new")
    public String newEmployee(Model model) {
        model.addAttribute("employee",new Employee());
        model.addAttribute("departments",departmentService.findAll());
        return "employees/new";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @PatchMapping("/{id}/edit")
    public String update(@ModelAttribute("employee") Employee employee,@PathVariable("id") long id) {
        employeeService.update(id,employee);
        return "redirect:/employees";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        employeeService.delete(employeeService.findOne(id));
        return "redirect:/employees";
    }



}
