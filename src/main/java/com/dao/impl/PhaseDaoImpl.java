package com.dao.impl;

import com.dao.PhaseDao;
import com.domain.Phase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by adrian.sacuiu on 8/21/2014.
 */
@Repository
public class PhaseDaoImpl implements PhaseDao {

    private SessionFactory sessionFactory;

    @Autowired
    public PhaseDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Phase createPhase(Phase phase) {
        currentSession().save(phase);
        return phase;
    }

    @Override
    public Phase updatePhase(Phase phase) {
        currentSession().update(phase);
        return phase;
    }

    @Override
    public Phase getPhase(Long id) {
        return (Phase) currentSession().get(Phase.class, id);
    }

    @Override
    public Phase deletePhase(Long id) {
        Phase phase = getPhase(id);
        currentSession().delete(phase);
        return phase;
    }

    @Override
    public List<Phase> getAllPhases() {
        return currentSession().createCriteria(Phase.class).list();
    }
}
