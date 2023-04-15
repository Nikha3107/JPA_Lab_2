package com.example.jpa_lab_2.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Calendar;
import java.util.Date;

@Entity
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue
    Long id;
    @NotBlank(message = "First name is mandatory")
    String firstName;
    @NotBlank(message = "Last name is mandatory")
    String lastName;
    @NotBlank(message = "Address is mandatory")
    String address;

    @NotNull(message = "Create department")
    @ManyToOne
    @JoinColumn(name = "department_id")
    Department department;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    Date birthday;

    @Enumerated(EnumType.STRING)
    Position position;

}
