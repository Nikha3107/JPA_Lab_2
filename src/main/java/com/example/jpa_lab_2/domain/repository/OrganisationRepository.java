package com.example.jpa_lab_2.domain.repository;

import com.example.jpa_lab_2.domain.entity.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganisationRepository  extends JpaRepository<Organisation,Long> {
}
