package com.project.managementtool.repositories;

import com.project.managementtool.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Id> {

    Project findByProjectIdentifier(String projectId);

    @Override
     Iterable<Project> findAll();

}

