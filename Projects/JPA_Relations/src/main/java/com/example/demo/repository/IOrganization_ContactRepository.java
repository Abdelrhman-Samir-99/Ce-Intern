package com.example.demo.repository;

import com.example.demo.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Organization_Contact;

import java.util.List;
import java.util.Optional;

@Repository
public interface IOrganization_ContactRepository extends JpaRepository<Organization_Contact, Integer> {
    Optional<Organization_Contact> findByOrganization(Organization organization);
    Optional<List<Organization_Contact>> findAllByOrganization(Organization organization);

    Optional<Organization_Contact> findByDescription(String description);

    void deleteByDescription(String description);
}
