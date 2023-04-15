package com.example.jpa_lab_2.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotBlank(message = "Name is mandatory")
    String name;

    Integer numOfEmployees = 0;

    String rooms;

    @OneToOne
    @JoinColumn(name = "department_head_id")
    Employee departmentHead;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
    List<Employee> employees;

    @NotNull(message = "Create organisation")
    @ManyToOne
    @JoinColumn(name = "organisation_id")
    Organisation organisation;

}
