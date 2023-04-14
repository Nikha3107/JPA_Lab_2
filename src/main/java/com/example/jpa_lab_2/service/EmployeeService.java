package com.example.jpa_lab_2.service;

import com.example.jpa_lab_2.domain.entity.Department;
import com.example.jpa_lab_2.domain.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findOne(long id);

    List<Employee> findByDepartment(Department department);

    void save(Employee employee);

    void update(long id, Employee employee);

    void delete(Employee employee);

    void deleteAll(List<Employee> employees);

}
