package com.project.managementtool.services;

import com.project.managementtool.domain.Project;
import com.project.managementtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdate(Project project){
        //logic
        return projectRepository.save(project);
    }
}
