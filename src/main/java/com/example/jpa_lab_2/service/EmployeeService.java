package com.example.jpa_lab_2.service;

import com.example.jpa_lab_2.domain.entity.Employee;

public interface EmployeeService {

    void findAll();

    void findOne(long id);

    void save(Employee employee);

    void update(long id, Employee employee);

    void delete(Employee employee);

}
