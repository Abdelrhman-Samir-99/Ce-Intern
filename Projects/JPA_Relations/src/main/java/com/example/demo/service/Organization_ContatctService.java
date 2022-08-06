package com.example.demo.service;

import com.example.demo.model.Organization_Contact;
import com.example.demo.repository.IOrganization_ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Organization_ContatctService implements IOrganization_ContanctService {
    @Autowired
    IOrganization_ContactRepository orgContactRepository;

    @Override
    public Organization_Contact save(Organization_Contact orgContact) {
        return orgContactRepository.save(orgContact);
    }

    @Override
    public Organization_Contact update(Organization_Contact orgContact) {
        return null;
    }

    @Override
    public Organization_Contact findById(Integer id) {
        return orgContactRepository.findById(id).get();
    }

    @Override
    public void remove(Organization_Contact orgContact) {
        orgContactRepository.delete(orgContact);
    }
}
