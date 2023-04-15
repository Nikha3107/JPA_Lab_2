package com.example.jpa_lab_2.service;

import com.example.jpa_lab_2.domain.entity.Department;
import com.example.jpa_lab_2.domain.entity.Employee;
import com.example.jpa_lab_2.domain.entity.Organisation;
import com.example.jpa_lab_2.domain.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public List<Department> findAll() {

        return departmentRepository.findAll();
    }

    @Override
    public Department findOne(long id) {
        Optional<Department> foundDepartment= departmentRepository.findById(id);
        return foundDepartment.orElse(null);
    }

    @Override
    public List<Department> findByOrganisation(Organisation organisation) {
        return departmentRepository.findDepartmentByOrganisation(organisation);
    }

    @Override
    public void save(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public void update(long id, Department updatedDepartment) {
        updatedDepartment.setId(id);
        departmentRepository.save(updatedDepartment);
    }

    @Override
    public void delete(Department department) {
        departmentRepository.delete(department);
    }

    @Override
    public void deleteAll(List<Department> departments) {
        departmentRepository.deleteAll(departments);
    }
}
