package com.example.jpa_lab_2.domain.entity;

import jakarta.persistence.*;

@Entity
public class Organisation {

    @Id
    @GeneratedValue
    Long id;

    String name;

    String address;

    @OneToOne
    @JoinColumn(name = "branch_head_id")
    Employee branchHead;

}
