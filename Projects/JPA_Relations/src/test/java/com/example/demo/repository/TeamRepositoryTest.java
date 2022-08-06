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
public class TeamRepositoryTest {
    @Autowired
    private ITeamRepository teamRepository;

    @Autowired
    private IProjectRepository projectRepository;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void addingNewTeamTest() {
        // Arrange
        Team team = Team.builder()
                .name("CHS")
                .build();
        // Act
        team = teamRepository.save(team);
        // Assert
        Assertions.assertThat(teamRepository.count()).isEqualTo(1);
    }

    @Test
    @Order(2)
    public void findByNameTest() {
        // Arrange
        Optional<Team> team = teamRepository.findByName("CHS");
        // Assert
        Assertions.assertThat(team.isPresent()).isEqualTo(true);
        Assertions.assertThat(team.get().getName()).isEqualTo(team.get().getName());
    }

    @Test
    @Order(3)
    public void findAllProjectsTest() {
        // Arrange & Assert
        Assertions.assertThat(
                teamRepository.findAll().size()
        ).isGreaterThan(0);
    }

    @Test
    @Order(4)
    public void updateTeamTest() {
        // Arrange
        Team team = teamRepository.findByName("CHS").get();
        team.setName("CHS2");

        // Assert
        Assertions.assertThat(team.getName()).isEqualTo("CHS2");
        team = teamRepository.save(team);
        Assertions.assertThat(teamRepository.count()).isEqualTo(1);
    }

    @Test
    @Order(5)
    public void deleteTeamTest() {
        // Act
        teamRepository.deleteByName("CHS");
        // Assert
        Assertions.assertThat(teamRepository.count()).isEqualTo(0);
    }

    @Test
    @Order(6)
    public void teamCascadeTest() {
        // Arrange
        Team team = teamRepository.findByName("CHS").get();
        Project project = Project.builder()
                .name("Health System")
                .build();

        // Act
        team.addProject(project);
        teamRepository.saveAndFlush(team);
        project = projectRepository.findByName(project.getName()).get();

        // Assert
        Assertions.assertThat(projectRepository.count()).isEqualTo(1);
        Assertions.assertThat(teamRepository.findById(team.getId())
                        .get().getProjects().contains(project)
                )
                .isEqualTo(true);
        // add assertion to find teams by using project.

        teamRepository.delete(team);
        Assertions.assertThat(projectRepository.count()).isEqualTo(0);
    }
}
