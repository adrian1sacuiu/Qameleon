package com.services;

import com.domain.Project;

import java.util.Date;
import java.util.List;

/**
 * Created by adrian.sacuiu on 8/21/2014.
 */
public interface ProjectService {

    public Project addProject(Project project);

    public Project updateProject(Project project);

    public Project getProjectById(Long id);

    public Project getProjectByName(String name);

    public List<Project> getProjectsFromDate(Date startDate);

    public Project deleteProject(Long id);

    public List<Project> getAllProjects();

}
