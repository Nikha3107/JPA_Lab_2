package com.example.jpa_lab_2.service;

import com.example.jpa_lab_2.domain.entity.Employee;
import com.example.jpa_lab_2.domain.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {

        return null;
    }

    @Override
    public Optional<Employee> findOne(long id) {

        return null;
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
