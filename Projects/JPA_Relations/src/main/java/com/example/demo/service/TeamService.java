package com.example.demo.service;

import com.example.demo.model.Team;
import com.example.demo.repository.ITeamRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TeamService implements ITeamService {
    @Autowired
    ITeamRepository teamRepository;

    @Override
    public Team save(Team newTeam) {
        return teamRepository.save(newTeam);
    }

    @Override
    public Team update(Team updatedTeam) {
        return null;
    }

    @Override
    public Team findById(Integer id) {
        return teamRepository.findById(id).get();
    }

    @Override
    public void remove(Team team) {
        teamRepository.delete(team);
    }
}