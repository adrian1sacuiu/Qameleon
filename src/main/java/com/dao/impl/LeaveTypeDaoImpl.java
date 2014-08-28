package com.dao.impl;

import com.dao.LeaveTypeDao;
import com.domain.LeaveType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by adrian.sacuiu on 8/21/2014.
 */
@Repository
public class LeaveTypeDaoImpl implements LeaveTypeDao {

    private SessionFactory sessionFactory;

    @Autowired
    public LeaveTypeDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public LeaveType createLeaveType(LeaveType leaveType) {
        currentSession().save(leaveType);
        return leaveType;
    }

    @Override
    public LeaveType updateLeaveType(LeaveType leaveType) {
        currentSession().update(leaveType);
        return leaveType;
    }

    @Override
    public LeaveType getLeaveType(Long id) {
        return (LeaveType) currentSession().get(LeaveType.class, id);
    }

    @Override
    public LeaveType deleteLeaveType(Long id) {
        LeaveType leaveType = getLeaveType(id);
        currentSession().delete(leaveType);
        return leaveType;
    }

    @Override
    public List<LeaveType> getAllLeaveTypes() {
        return currentSession().createCriteria(LeaveType.class).list();
    }
}
