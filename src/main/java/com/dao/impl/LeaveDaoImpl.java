package com.dao.impl;

import com.dao.LeaveDao;
import com.domain.Leave;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by adrian.sacuiu on 8/21/2014.
 */
@Repository
public class LeaveDaoImpl implements LeaveDao {

    private SessionFactory sessionFactory;

    @Autowired
    public LeaveDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Leave createLeave(Leave leave) {
        currentSession().save(leave);
        return leave;
    }

    @Override
    public Leave updateLeave(Leave leave) {
        currentSession().update(leave);
        return leave;
    }

    @Override
    public Leave getLeave(Long id) {
        return (Leave) currentSession().get(Leave.class, id);
    }

    @Override
    public Leave deleteLeave(Long id) {
        Leave leave = getLeave(id);
        currentSession().delete(leave);
        return leave;
    }

    @Override
    public List<Leave> getAllLeaves() {
        return currentSession().createCriteria(Leave.class).list();
    }
}
