package com.example.demo.repository;

import com.example.demo.model.Organization;
import com.example.demo.model.Organization_Contact;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Organization_ContactRepositoryTest {
    @Autowired
    private IOrganization_ContactRepository orgContactRepository;
    @Autowired
    private IOrganizationRepository organizationRepository;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void addingNewContactTest() {
        // Arrange
        Organization_Contact orgContact = Organization_Contact.builder()
                .address("Cairo, Egypt")
                .description("IT company")
                .build();
        // Act
        orgContactRepository.save(orgContact);

        // Assert
        Assertions.assertThat(orgContactRepository.count()).isEqualTo(1);
    }

    @Test
    @Order(2)
    public void findByDescriptionTest() {
        // Arrange
        Optional<Organization_Contact> orgContact = orgContactRepository.findByDescription("IT company");
        // Assert
        Assertions.assertThat(orgContact.isPresent()).isEqualTo(true);
        Assertions.assertThat(orgContact.get().getDescription()).isEqualTo(orgContact.get().getDescription());
    }

    @Test
    @Order(3)
    public void findAllContactsTest() {
        // Assert & Arrange
        Assertions.assertThat(
                orgContactRepository.findAll().size()
        ).isGreaterThan(0);
    }

    @Test
    @Order(4)
    public void updateContactTest() {
        // Arrange
        Organization_Contact orgContact = orgContactRepository.findByDescription("IT company").get();
        orgContact.setAddress("Alexandria, Egypt");
        // Act
        orgContact = orgContactRepository.save(orgContact);
        // Assert
        Assertions.assertThat(orgContact.getAddress()).isEqualTo("Alexandria, Egypt");
        Assertions.assertThat(orgContactRepository.count()).isEqualTo(1);
    }

    @Test
    @Order(5)
    public void deleteContactTest() {
        // Act
        orgContactRepository.deleteByDescription("IT company");
        // Assert
        Assertions.assertThat(orgContactRepository.findByDescription("IT company").isPresent()).isEqualTo(false);
    }
}
