package com.example.jpa_lab_2.service;

import com.example.jpa_lab_2.domain.entity.Department;
import com.example.jpa_lab_2.domain.entity.Employee;
import com.example.jpa_lab_2.domain.entity.Position;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findOne(long id);

    List<Employee> findByDepartment(Department department);

    List<Employee> findByPositionAndDepartment(Position position, Department department);

    void save(Employee employee);

    void update(long id, Employee employee);

    void delete(Employee employee);

    void deleteAll(List<Employee> employees);

}
