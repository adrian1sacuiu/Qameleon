package com.dao.impl;


import com.dao.ProjectDao;
import com.domain.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by adrian.sacuiu on 8/19/2014.
 */
@Repository
public class ProjectDaoImpl implements ProjectDao {

    private SessionFactory sessionFactory;

    @Autowired
    public ProjectDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Project createProject(Project project) {
        currentSession().save(project);
        return project;
    }

    @Override
    public Project updateProject(Project project) {
        currentSession().update(project);
        return project;
    }

    @Override
    public Project getProject(Long id) {
        return (Project) currentSession().get(Project.class, id);
    }

    @Override
    public Project deleteProject(Long id) {
        Project project = getProject(id);
        currentSession().delete(project);
        return project;
    }

    @Override
    public List<Project> getAllProjects() {
        return currentSession().createCriteria(Project.class).list();
    }

}
