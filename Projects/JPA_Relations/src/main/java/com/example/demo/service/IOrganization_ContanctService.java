package com.example.demo.service;

import com.example.demo.model.Organization_Contact;

public interface IOrganization_ContanctService {
    public Organization_Contact save(Organization_Contact orgContact);
    public Organization_Contact update(Organization_Contact orgContact);
    public Organization_Contact findById(Integer id);
    public void remove(Organization_Contact orgContact);
}
