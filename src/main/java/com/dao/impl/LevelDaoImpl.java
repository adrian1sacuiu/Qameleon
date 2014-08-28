package com.dao.impl;

import com.dao.LevelDao;
import com.domain.Level;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by adrian.sacuiu on 8/21/2014.
 */
@Repository
public class LevelDaoImpl implements LevelDao {

    private SessionFactory sessionFactory;

    @Autowired
    public LevelDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Level createLevel(Level level) {
        currentSession().save(level);
        return level;
    }

    @Override
    public Level updateLevel(Level level) {
        currentSession().update(level);
        return level;
    }

    @Override
    public Level getLevel(Long id) {
        return (Level) currentSession().get(Level.class, id);
    }

    @Override
    public Level deleteLevel(Long id) {
        Level level = getLevel(id);
        currentSession().delete(level);
        return level;
    }

    @Override
    public List<Level> getAllLevels() {
        return currentSession().createCriteria(Level.class).list();
    }
}
