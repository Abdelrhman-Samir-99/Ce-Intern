package com.example.demo.repository;

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
public class ProjectRepositoryTest {
    @Autowired
    private IProjectRepository projectRepository;

    @Autowired
    private ITeamRepository teamRepository;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void addNewProjectTest() {
        // Arrange
        Project project = Project.builder()
                .name("Health System")
                .build();
        // Act
        project = projectRepository.save(project);
        // Assert
        Assertions.assertThat(projectRepository.count()).isEqualTo(1);
    }

    @Test
    @Order(2)
    public void findByNameTest() {
        // Arrange
        Optional<Project> project = projectRepository.findByName("Health System");
        // Assert
        Assertions.assertThat(project.isPresent()).isEqualTo(true);
    }

    @Test
    @Order(3)
    public void findAllProjectsTest() {
        // Arrange & Assert
        Assertions.assertThat(
                projectRepository.findAll().size()
        ).isGreaterThan(0);
    }

    @Test
    @Order(4)
    public void updateProjectTest() {
        // Arrange
        Project project = projectRepository.findByName("Health System").get();
        project.setName("Health System 2");

        // Act
        project = projectRepository.save(project);

        // Assert
        Assertions.assertThat(project.getName()).isEqualTo("Health System 2");
        Assertions.assertThat(projectRepository.count()).isEqualTo(1);
    }

    @Test
    @Order(5)
    public void deleteProjectTest() {
        // Act
        projectRepository.deleteByName("Health System");
        // Assert
        Assertions.assertThat(projectRepository.count()).isEqualTo(0);
    }

    @Test
    @Order(6)
    public void projectCascadeTest() {
        // Arrange
        Project project = projectRepository.findByName("Health System").get();
        Team team = Team.builder()
                .name("CHS")
                .build();

        // Act
        project.addTeam(team);
        project = projectRepository.saveAndFlush(project);
        team = teamRepository.findByName(team.getName()).get();

        // Assert
        Assertions.assertThat(teamRepository.count()).isEqualTo(1);
        Assertions.assertThat(projectRepository.findById(project.getId())
                .get().getTeams().contains(team)
                )
                .isEqualTo(true);

        // add assertion to find teams by using project.

        projectRepository.delete(project);
        Assertions.assertThat(teamRepository.count()).isEqualTo(0);
    }
}
