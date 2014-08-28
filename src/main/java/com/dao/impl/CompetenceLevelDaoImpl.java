package com.dao.impl;

import com.dao.CompetenceLevelDao;
import com.domain.CompetenceLevel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by adrian.sacuiu on 8/21/2014.
 */
@Repository
public class CompetenceLevelDaoImpl implements CompetenceLevelDao {

    private SessionFactory sessionFactory;

    @Autowired
    public CompetenceLevelDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public CompetenceLevel createCompetenceLevel(CompetenceLevel competenceLevel) {
        currentSession().save(competenceLevel);
        return competenceLevel;
    }

    @Override
    public CompetenceLevel updateCompetenceLevel(CompetenceLevel competenceLevel) {
        currentSession().update(competenceLevel);
        return competenceLevel;
    }

    @Override
    public CompetenceLevel getCompetenceLevel(Long id) {
        return (CompetenceLevel) currentSession().get(CompetenceLevel.class, id);
    }

    @Override
    public CompetenceLevel deleteCompetenceLevel(Long id) {
        CompetenceLevel competenceLevel = getCompetenceLevel(id);
        currentSession().delete(competenceLevel);
        return competenceLevel;
    }

    @Override
    public List<CompetenceLevel> getAllCompetenceLevels() {
        return currentSession().createCriteria(CompetenceLevel.class).list();
    }
}
