package com.dao.impl;

import com.dao.CompetencyDao;
import com.domain.Competency;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by adrian.sacuiu on 8/21/2014.
 */
@Repository
public class CompetencyDaoImpl implements CompetencyDao {

    private SessionFactory sessionFactory;

    @Autowired
    public CompetencyDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Competency createCompetency(Competency competency) {
        currentSession().save(competency);
        return competency;
    }

    @Override
    public Competency updateCompetency(Competency competency) {
        currentSession().update(competency);
        return competency;
    }

    @Override
    public Competency getCompetency(Long id) {
        return (Competency) currentSession().get(Competency.class, id);
    }

    @Override
    public Competency deleteCompetency(Long id) {
        Competency competency = getCompetency(id);
        currentSession().delete(competency);
        return competency;
    }

    @Override
    public List<Competency> getAllCompetencies() {
        return currentSession().createCriteria(Competency.class).list();
    }
}
