package com.example.jpa_lab_2.service;

import com.example.jpa_lab_2.domain.entity.Employee;
import com.example.jpa_lab_2.domain.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void findAll() {

    }

    @Override
    public void findOne(long id) {

    }

    @Override
    public void save(Employee employee) {

    }

    @Override
    public void update(long id, Employee employee) {

    }

    @Override
    public void delete(Employee employee) {

    }
}