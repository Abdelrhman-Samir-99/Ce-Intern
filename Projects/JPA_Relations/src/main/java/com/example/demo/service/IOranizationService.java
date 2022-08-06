package com.example.demo.service;

import com.example.demo.model.Organization;
import com.example.demo.model.Organization_Contact;

import java.util.List;

public interface IOranizationService {
    public Organization save(Organization newOrganization);
    public Organization update(Organization updatedOrgContact);
    public Organization findById(Integer id);
    public Organization findByOrgContact(Organization_Contact orgContact);
    public void remove(Organization organization);
}