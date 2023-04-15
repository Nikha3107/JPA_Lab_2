package com.example.jpa_lab_2.domain.repository;

import com.example.jpa_lab_2.domain.entity.Department;
import com.example.jpa_lab_2.domain.entity.Employee;
import com.example.jpa_lab_2.domain.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee,Long> {
    List<Employee> findEmployeesByDepartment(Department department);

    List<Employee> findEmployeesByPositionAndDepartment(Position position, Department department);
}
