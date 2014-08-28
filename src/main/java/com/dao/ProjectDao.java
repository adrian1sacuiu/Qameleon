package com.dao;

import com.domain.Project;

import java.util.List;

/**
 * Created by adrian.sacuiu on 8/19/2014.
 */
public interface ProjectDao {

    public Project createProject(Project project);

    public Project updateProject(Project project);

    public Project getProject(Long id);

    public Project deleteProject(Long id);

    public List<Project> getAllProjects();

}
