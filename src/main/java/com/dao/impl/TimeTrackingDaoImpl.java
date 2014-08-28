package com.dao.impl;

import com.dao.TimeTrackingDao;
import com.domain.TimeTracking;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by adrian.sacuiu on 8/21/2014.
 */
@Repository
public class TimeTrackingDaoImpl implements TimeTrackingDao {

    private SessionFactory sessionFactory;

    @Autowired
    public TimeTrackingDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public TimeTracking createTimeTracking(TimeTracking timeTracking) {
        currentSession().save(timeTracking);
        return timeTracking;
    }

    @Override
    public TimeTracking updateTimeTracking(TimeTracking timeTracking) {
        currentSession().update(timeTracking);
        return timeTracking;
    }

    @Override
    public TimeTracking getTimeTracking(Long id) {
        return (TimeTracking) currentSession().get(TimeTracking.class, id);
    }

    @Override
    public TimeTracking deleteTimeTracking(Long id) {
        TimeTracking timeTracking = getTimeTracking(id);
        currentSession().delete(timeTracking);
        return timeTracking;
    }

    @Override
    public List<TimeTracking> getAllTimeTrackings() {
        return currentSession().createCriteria(TimeTracking.class).list();
    }
}
