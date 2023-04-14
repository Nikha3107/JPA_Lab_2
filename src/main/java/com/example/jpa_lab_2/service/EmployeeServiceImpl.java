package com.example.jpa_lab_2.service;

import com.example.jpa_lab_2.domain.entity.Department;
import com.example.jpa_lab_2.domain.entity.Employee;
import com.example.jpa_lab_2.domain.entity.Position;
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
        return employeeRepository.findAll();
    }

    @Override
    public Employee findOne(long id) {
        Optional<Employee> foundEmployee= employeeRepository.findById(id);
        return foundEmployee.orElse(null);
    }

    @Override
    public List<Employee> findByDepartment(Department department) {
        return employeeRepository.findEmployeesByDepartment(department);
    }

    @Override
    public void save(Employee employee) {
        Department department = employee.getDepartment();
        department.setNumOfEmployees(department.getNumOfEmployees()+1);
        if (employee.getPosition().equals(Position.HEAD)) {
            department.setDepartmentHead(employee);
        }
        employeeRepository.save(employee);
    }

    @Override
    public void update(long id, Employee updatedEmployee) {
        updatedEmployee.setId(id);
        if (updatedEmployee.getPosition().equals(Position.HEAD)) {
            updatedEmployee.getDepartment().setDepartmentHead(updatedEmployee);
        }
        employeeRepository.save(updatedEmployee);
    }

    @Override
    public void delete(Employee employee) {
        Department department = employee.getDepartment();
        department.setNumOfEmployees(department.getNumOfEmployees()-1);
        if (employee.getPosition().equals(Position.HEAD)) {
            department.setDepartmentHead(null);
        }
        employeeRepository.delete(employee);
    }

    @Override
    public void deleteAll(List<Employee> employees) {
        employees.forEach(employee -> {
            Department department = employee.getDepartment();
            department.setNumOfEmployees(department.getNumOfEmployees()-1);
            if (employee.getPosition().equals(Position.HEAD)) {
                department.setDepartmentHead(null);
            }
        });
        employeeRepository.deleteAll(employees);
    }

}
