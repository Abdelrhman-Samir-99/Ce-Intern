package com.example.demo.repository;

import com.example.demo.model.Organization;
import com.example.demo.model.Organization_Contact;
import com.example.demo.model.Project;
import com.example.demo.model.Team;
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
public class OrganizationRepositoryTest {
    @Autowired
    private IOrganizationRepository organizationRepository;
    @Autowired
    private IOrganization_ContactRepository orgContactRepository;

    @Autowired
    private ITeamRepository teamRepository;

    @Autowired
    private IProjectRepository projectRepository;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void addingNewOrganizationTest() {
        // Arrange
        Organization organization = Organization.builder()
                .name("NOT Cege")
                .build();
        // Act
        organization = organizationRepository.save(organization);
        // Assert
        Assertions.assertThat(organizationRepository.count()).isEqualTo(1);
    }

    @Test
    @Order(2)
    public void findByIdTest() {
        // Arrange
        Optional<Organization> organization = organizationRepository.findById(1);
        // Assert
        Assertions.assertThat(organization.isPresent()).isEqualTo(true);
        Assertions.assertThat(organization.get().getId()).isEqualTo(1);
    }

    @Test
    @Order(3)
    public void findAllOrganizationsTest() {
        // Assert & Arrange
        Assertions.assertThat(
                organizationRepository.findAll().size()
        ).isGreaterThan(0);
    }

    @Test
    @Order(4)
    public void updateOrganizationTest() {
        // Arrange
        Organization organiztion = organizationRepository.findById(1).get();
        // Act
        organiztion.setName("This is cege");
        organiztion = organizationRepository.save(organiztion);
        // Assert
        Assertions.assertThat(organiztion.getName()).isEqualTo("This is cege");
        Assertions.assertThat(organizationRepository.count()).isEqualTo(1);
    }

    @Test
    @Order(5)
    public void deleteOrganizationTest() {
        // Act
        organizationRepository.deleteById(1);
        // Assert
        Assertions.assertThat(organizationRepository.count()).isEqualTo(0);
    }

    @Test
    @Order(6)
    public void Organization_ContactCascadingTest() {
        // Arrange
        Organization organization = organizationRepository.findById(1).get();
        Organization_Contact orgContact = Organization_Contact.builder()
                .address("Cairo, Egypt")
                .description("IT company")
                .organization(organization)
                .build();

        // Act
        organization.setOrgContact(orgContact);
        organization = organizationRepository.save(organization);

        /*
         This must be a joke: TODO: FLUSHING IS SO FREAKING IMPORTANT, EVEN IN DB
         flushing doesn't work if we use findById(), but it works when we call findAll()
        */
        organizationRepository.flush();

        // Assert
        // TODO: IMPORTANT -> This means that Cascade Persistent is working properly
        Assertions.assertThat(orgContactRepository.
                findById(1)
                .get()
                .getOrganization()).isEqualTo(organization);

        organizationRepository.delete(organization);

        // This means that Cascade.REMOVE is working properly, since it will delete all the children.
        Assertions.assertThat(orgContactRepository.count()).isEqualTo(0);
    }

    @Test
    @Order(7)
    public void teamCascadingTest() {
        // Arrange
        Organization organization = organizationRepository.findById(1).get();
        Team team = Team.builder()
                .name("CHS")
                .build();

        // Act
        organization.addTeam(team);
        organization = organizationRepository.saveAndFlush(organization);

        /*
            TODO: Ask to Mohamed Samir or Yara (if we defined the relation from one side, can we query the other
            the other side? (organization -> Projecs), can we ask the project in which organization it belongs?
        */
        // Assert
        Assertions.assertThat(organizationRepository.findById(1).get().getTeams().size()).isEqualTo(1);
        Assertions.assertThat(teamRepository.count()).isEqualTo(1);

        organizationRepository.delete(organization);
        Assertions.assertThat(teamRepository.count()).isEqualTo(0);
    }

    @Test
    @Order(8)
    public void projectCascadingTest() {
        // Arrange
        Organization organization = organizationRepository.findById(1).get();
        Project project = Project.builder()
                .name("CHS")
                .build();

        // Act
        organization.addProject(project);
        organization = organizationRepository.saveAndFlush(organization);


        // Assert
        Assertions.assertThat(organizationRepository.findById(1).get().getProjects().size()).isEqualTo(1);
        Assertions.assertThat(projectRepository.count()).isEqualTo(1);

        organizationRepository.delete(organization);
        Assertions.assertThat(projectRepository.count()).isEqualTo(0);
    }
}
