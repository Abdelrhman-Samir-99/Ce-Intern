package com.example.demo.repository;

import com.example.demo.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProjectRepository extends JpaRepository<Project, Integer> {
    // TODO: read the documentation, and know how to query many to many tables.
    // public List<Project> findProjectsByTeam(Team team);
    public Optional<Project> findByName(String name);

    public void deleteByName(String name);
}
