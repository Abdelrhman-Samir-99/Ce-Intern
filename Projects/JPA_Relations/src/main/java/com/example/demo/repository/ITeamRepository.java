package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Team;

import java.util.Optional;

@Repository
public interface ITeamRepository extends JpaRepository<Team, Integer> {
    Optional<Team> findByName(String name);

    void deleteByName(String name);
}
