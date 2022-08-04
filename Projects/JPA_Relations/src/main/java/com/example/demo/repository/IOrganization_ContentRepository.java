package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Organization_Contact;

@Repository
public interface IOrganization_ContentRepository extends JpaRepository<Organization_Contact, Integer>{

}
