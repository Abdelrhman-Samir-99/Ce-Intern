package com.example.demo.service;

import com.example.demo.model.Team;

public interface ITeamService {
    public Team save(Team newTeam);
    public Team update(Team updatedTeam);
    public Team findById(Integer id);
    public void remove(Team team);
}
