package com.example.jpa_lab_2.presentation.controllers;

import com.example.jpa_lab_2.domain.entity.Department;
import com.example.jpa_lab_2.domain.entity.Employee;
import com.example.jpa_lab_2.service.DepartmentService;
import com.example.jpa_lab_2.service.EmployeeService;
import com.example.jpa_lab_2.util.EmployeeValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final DepartmentService departmentService;
    private final EmployeeValidator employeeValidator;

    @Autowired
    public EmployeeController(EmployeeService employeeService, DepartmentService departmentService, EmployeeValidator employeeValidator) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
        this.employeeValidator = employeeValidator;
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
        return "employees/new";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("employee") @Valid Employee employee, BindingResult bindingResult) {

        employeeValidator.validate(employee,bindingResult);

        if (bindingResult.hasErrors()) {
            return "employees/new";
        }

        employeeService.save(employee);
        return "redirect:/employees";
    }

    @PatchMapping("/{id}/edit")
    public String update(@ModelAttribute("employee") @Valid Employee employee, BindingResult bindingResult, @PathVariable("id") long id) {

        employeeValidator.validate(employee,bindingResult);

        if (bindingResult.hasErrors()) {
            return "employees/edit";
        }

        employeeService.update(id,employee);
        return "redirect:/employees";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        employeeService.delete(employeeService.findOne(id));
        return "redirect:/employees";
    }

    @ModelAttribute("departments")
    public List<Department> commonData() {
        return departmentService.findAll();
    }



}
