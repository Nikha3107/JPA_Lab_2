package com.example.jpa_lab_2.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;

@Entity
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue
    Long id;

    String firstName;

    String lastName;

    String address;

    @ManyToOne
    @JoinColumn(name = "department_id")
    Department department;

    Calendar birthday;

    @Enumerated(EnumType.STRING)
    Position position;

}
