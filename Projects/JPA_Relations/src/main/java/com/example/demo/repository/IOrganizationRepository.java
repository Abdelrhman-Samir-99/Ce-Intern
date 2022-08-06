package com.example.demo.repository;

import com.example.demo.model.Organization_Contact;
import com.example.demo.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Organization;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface IOrganizationRepository extends JpaRepository<Organization, Integer> {
    public Organization findByOrgContact(Organization_Contact organization_contact);

    public Organization findByName(String name);
}
