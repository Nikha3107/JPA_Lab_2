package com.example.jpa_lab_2.domain.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Department {

    @Id
    @GeneratedValue
    Long id;

    String name;

    Integer numOfEmployees;

    String rooms;

    @OneToOne
    @JoinColumn(name = "department_head_id")
    Employee departmentHead;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
    List<Employee> employees;

}
