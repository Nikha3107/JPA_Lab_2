package com.example.jpa_lab_2.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Department {

    @Id
    @GeneratedValue
    Long id;

    String name;

    Integer numOfEmployees = 0;

    String rooms;

    @OneToOne
    @JoinColumn(name = "department_head_id")
    Employee departmentHead;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
    List<Employee> employees;

}
