package com.example.jpa_lab_2.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Organisation {

    @Id
    @GeneratedValue
    Long id;

    @NotBlank(message = "Name is mandatory")
    String name;

    @NotBlank(message = "Address is mandatory")
    String address;

    @OneToOne
    @JoinColumn(name = "branch_head_id")
    Employee branchHead;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "organisation")
    List<Department> departments;

}
