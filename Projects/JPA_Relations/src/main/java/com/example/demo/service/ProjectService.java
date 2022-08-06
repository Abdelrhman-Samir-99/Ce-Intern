package com.example.demo.service;

import com.example.demo.model.Project;
import com.example.demo.repository.IProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProjectService implements IProjectService {
    @Autowired
    IProjectRepository projectRepository;
    
    @Override
    public Project save(Project newProject) {
        return projectRepository.save(newProject);
    }

    @Override
    public Project update(Project updatedProject) {
        return null;
    }

    @Override
    public Project findById(Integer id) {
        return projectRepository.findById(id).get();
    }

    @Override
    public void remove(Project project) {
        projectRepository.delete(project);
    }
}
