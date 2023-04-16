package com.example.jpa_lab_2.service;

import com.example.jpa_lab_2.domain.entity.Employee;
import com.example.jpa_lab_2.domain.entity.Organisation;
import com.example.jpa_lab_2.domain.repository.OrganisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@Service
public class OrganisationServiceImpl implements OrganisationService {

    @Autowired
    OrganisationRepository organisationRepository;

    @Override
    public List<Organisation> findAll() {
        return organisationRepository.findAll();
    }

    @Override
    public Organisation findOne(long id) {
        Optional<Organisation> foundOrganisation = organisationRepository.findById(id);
        return foundOrganisation.orElse(null);
    }

    @Transactional
    @Override
    public void save(Organisation organisation) {
        organisationRepository.save(organisation);
    }

    @Transactional
    @Override
    public void update(long id, Organisation organisation) {
        organisation.setId(id);
        save(organisation);
    }

    @Transactional
    @Override
    public void delete(Organisation organisation) {
        organisationRepository.delete(organisation);
    }
}
