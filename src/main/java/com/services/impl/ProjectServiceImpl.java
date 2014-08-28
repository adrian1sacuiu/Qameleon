package com.services.impl;

import com.dao.ProjectDao;
import com.domain.Project;
import com.services.ProjectService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by adrian.sacuiu on 8/21/2014.
 */
@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    private ProjectDao projectDao;

    @Autowired
    public ProjectServiceImpl(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    @Override
    public Project addProject(Project project) {
        return projectDao.createProject(project);
    }

    @Override
    public Project updateProject(Project project) {
        return projectDao.updateProject(project);
    }

    @Override
    @Transactional(readOnly = true)
    public Project getProjectById(Long id) {
        Project project = projectDao.getProject(id);
        Hibernate.initialize(project.getTimeTracking());
        return project;
    }

    @Override
    public Project getProjectByName(String name) {
        List<Project> projects = getAllProjects();
        for(Project project:projects){
            if(project.getName().equals(name)){
                return project;
            }
        }
        return null;
    }

    @Override
    public List<Project> getProjectsFromDate(Date startDate) {
        List<Project> projects = getAllProjects();
        List<Project> requestedProjects = new ArrayList<Project>();
        Date endDate = new Date();
        endDate.setTime(endDate.getTime() + 28L * 1000 * 60 * 60 * 24);
        for (Project project : projects) {
            boolean test = (project.getStartDate()!= null || project.getEndDate() !=null) &&
                    (project.getStartDate().compareTo(endDate) == -1 || project.getStartDate().compareTo(endDate) == 0)
                    && (project.getEndDate().compareTo(startDate) == 0 || project.getEndDate().compareTo(startDate) == 1);
            if ( test) {
                requestedProjects.add(project);
            }
        }
        return requestedProjects;
    }

    @Override
    public Project deleteProject(Long id) {
        return projectDao.deleteProject(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Project> getAllProjects() {
        List<Project> projects = projectDao.getAllProjects();
        for (Project project : projects) {
            Hibernate.initialize(project.getTimeTracking());
        }
        return projects;
    }
}
