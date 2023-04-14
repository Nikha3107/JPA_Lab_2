package com.example.jpa_lab_2.service;

import com.example.jpa_lab_2.domain.entity.Department;
import com.example.jpa_lab_2.domain.entity.Employee;

import java.util.List;

public interface DepartmentService {

    List<Department> findAll();

    Department findOne(long id);

    void save(Department department);

    void update(long id, Department updatedDepartment);

    void delete(Department department);

}
