package com.example.demo.service;

import com.example.demo.model.Organization;
import com.example.demo.model.Organization_Contact;
import com.example.demo.repository.IOrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationService implements IOranizationService {
    @Autowired
    IOrganizationRepository orgRepository;

    @Override
    public Organization save(Organization newOrganization) {
        return orgRepository.save(newOrganization);
    }

    @Override
    public Organization update(Organization updatedOrganization) {
        return orgRepository.save(updatedOrganization);
    }

    @Override
    public Organization findById(Integer id) {
        return orgRepository.findById(id).get();
    }

    @Override
    public Organization findByOrgContact(Organization_Contact orgContact) {
        return orgRepository.findByOrgContact(orgContact);
    }

    @Override
    public void remove(Organization orgContact) {
        orgRepository.delete(orgContact);
    }
}
