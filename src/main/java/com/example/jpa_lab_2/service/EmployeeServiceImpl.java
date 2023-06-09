package com.example.jpa_lab_2.service;

import com.example.jpa_lab_2.domain.entity.Department;
import com.example.jpa_lab_2.domain.entity.Employee;
import com.example.jpa_lab_2.domain.entity.Position;
import com.example.jpa_lab_2.domain.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
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
    public List<Employee> findByPositionAndDepartment(Position position, Department department) {
        return employeeRepository.findEmployeesByPositionAndDepartment(position,department);
    }

    @Transactional
    @Override
    public void save(Employee employee) {
        Department department = employee.getDepartment();
        department.setNumOfEmployees(department.getNumOfEmployees()+1);
        if (employee.getPosition().equals(Position.DEPARTMENT_HEAD)) {
            department.setDepartmentHead(employee);
        }
        if (employee.getPosition().equals(Position.BRANCH_HEAD)) {
            department.getOrganisation().setBranchHead(employee);
        }
        employeeRepository.save(employee);
    }

    @Transactional
    @Override
    public void update(long id, Employee updatedEmployee) {
        updatedEmployee.setId(id);
        Department department = updatedEmployee.getDepartment();
        if (updatedEmployee.getPosition().equals(Position.DEPARTMENT_HEAD)) {
            updatedEmployee.getDepartment().setDepartmentHead(updatedEmployee);
        }
        if (updatedEmployee.getPosition().equals(Position.BRANCH_HEAD)) {
            department.getOrganisation().setBranchHead(updatedEmployee);
        }
        employeeRepository.save(updatedEmployee);
    }

    @Transactional
    @Override
    public void delete(Employee employee) {
        Department department = employee.getDepartment();
        department.setNumOfEmployees(department.getNumOfEmployees()-1);
        if (employee.getPosition().equals(Position.DEPARTMENT_HEAD)) {
            department.setDepartmentHead(null);
        }
        if (employee.getPosition().equals(Position.BRANCH_HEAD)) {
            department.getOrganisation().setBranchHead(null);
        }
        employeeRepository.delete(employee);
    }

    @Transactional
    @Override
    public void deleteAll(List<Employee> employees) {
        employees.forEach(employee -> {
            Department department = employee.getDepartment();
            department.setNumOfEmployees(department.getNumOfEmployees()-1);
            if (employee.getPosition().equals(Position.DEPARTMENT_HEAD)) {
                department.setDepartmentHead(null);
            }
            if (employee.getPosition().equals(Position.BRANCH_HEAD)) {
                department.getOrganisation().setBranchHead(null);
            }
        });
        employeeRepository.deleteAll(employees);
    }

}
