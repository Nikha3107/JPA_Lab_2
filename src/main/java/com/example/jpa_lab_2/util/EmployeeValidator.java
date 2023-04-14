package com.example.jpa_lab_2.util;

import com.example.jpa_lab_2.domain.entity.Employee;
import com.example.jpa_lab_2.domain.repository.EmployeeRepository;
import com.example.jpa_lab_2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class EmployeeValidator implements Validator {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public boolean supports(Class<?> clazz) {
        return Employee.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Employee employee = (Employee) target;

    }
}
