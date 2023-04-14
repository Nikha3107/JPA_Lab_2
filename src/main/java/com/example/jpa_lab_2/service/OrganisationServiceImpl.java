package com.example.jpa_lab_2.service;

import com.example.jpa_lab_2.domain.entity.Employee;
import com.example.jpa_lab_2.domain.entity.Organisation;
import com.example.jpa_lab_2.domain.repository.OrganisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganisationServiceImpl implements OrganisationService {

    @Autowired
    OrganisationRepository organisationRepository;

    @Override
    public List<Organisation> findAll() {
        return null;
    }

    @Override
    public Organisation findOne(long id) {
        return null;
    }

    @Override
    public void save(Organisation organisation) {

    }

    @Override
    public void update(long id, Organisation organisation) {

    }

    @Override
    public void delete(Organisation organisation) {

    }
}
