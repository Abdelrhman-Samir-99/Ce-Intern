package com.example.demo.service;

import com.example.demo.model.Project;

public interface IProjectService {
    public Project save(Project newContact);
    public Project update(Project updatedProject);
    public Project findById(Integer id);
    public void remove(Project project);
}
