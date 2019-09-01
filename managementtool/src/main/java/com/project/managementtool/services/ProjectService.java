package com.project.managementtool.services;

import com.project.managementtool.domain.Project;
import com.project.managementtool.exceptions.ProjectIdException;
import com.project.managementtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdate(Project project) {

        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        } catch (Exception e) {
            throw new ProjectIdException("Project ID '" + project.getProjectIdentifier().toUpperCase() + "'Already exist");
        }
    }

    public Project findProjectByIdentifier(String projectId) {
        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
        if (project == null) {
            throw new ProjectIdException("Project ID '" + projectId + "' doesnot exist");
        }
        return project;
    }

    public Iterable<Project> findAllPojects() {

        return projectRepository.findAll();
    }

    public void deleteProjectByIdentifier(String projectId) {

        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
        if (project == null) {
            throw new ProjectIdException("Project with project id '" + projectId + "' doesnot exist");
        }
        projectRepository.delete(project);
    }

}


