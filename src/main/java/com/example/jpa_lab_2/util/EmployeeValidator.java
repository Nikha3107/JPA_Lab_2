package com.example.jpa_lab_2.util;

import com.example.jpa_lab_2.domain.entity.Employee;
import com.example.jpa_lab_2.domain.entity.Position;
import com.example.jpa_lab_2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

@Component
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

        if (employee.getPosition().equals(Position.DEPARTMENT_HEAD)) {
            List<Employee> departmentList = employeeService.findByPositionAndDepartment(Position.DEPARTMENT_HEAD,employee.getDepartment());
            if (!departmentList.isEmpty()) {
                if (!departmentList.get(0).getId().equals(employee.getId())) {
                    errors.rejectValue("position","","Head of department: "+employee.getDepartment().getName()+" already exist");
                }
            }
        }
        if (employee.getPosition().equals(Position.BRANCH_HEAD)) {
            List<Employee> departmentList = employeeService.findByPositionAndDepartment(Position.BRANCH_HEAD,employee.getDepartment());
            if (!departmentList.isEmpty()) {
                if (!departmentList.get(0).getId().equals(employee.getId())) {
                    errors.rejectValue("position","","Head of organisation: "+employee.getDepartment().getOrganisation().getName()+" already exist");
                }
            }
        }
    }
}
