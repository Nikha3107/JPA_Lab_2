package com.example.jpa_lab_2.service;

import com.example.jpa_lab_2.domain.entity.Department;
import com.example.jpa_lab_2.domain.entity.Employee;
import com.example.jpa_lab_2.domain.entity.Organisation;

import java.util.List;

public interface OrganisationService {

    List<Organisation> findAll();

    Organisation findOne(long id);

    void save(Organisation organisation);

    void update(long id, Organisation organisation);

    void delete(Organisation organisation);

}
