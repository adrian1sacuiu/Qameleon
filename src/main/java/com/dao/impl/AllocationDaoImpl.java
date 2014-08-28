package com.dao.impl;

import com.dao.AllocationDao;
import com.domain.Allocation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by adrian.sacuiu on 8/21/2014.
 */
@Repository
public class AllocationDaoImpl implements AllocationDao {

    private SessionFactory sessionFactory;

    @Autowired
    public AllocationDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Allocation createAllocation(Allocation allocation) {
        currentSession().save(allocation);
        return allocation;
    }

    @Override
    public Allocation updateAllocation(Allocation allocation) {
        currentSession().update(allocation);
        return allocation;
    }

    @Override
    public Allocation getAllocation(Long id) {
        return (Allocation) currentSession().get(Allocation.class, id);
    }

    @Override
    public Allocation deleteAllocation(Long id) {
        Allocation allocation = getAllocation(id);
        currentSession().delete(allocation);
        return allocation;
    }

    @Override
    public List<Allocation> getAllAllocations() {
        return currentSession().createCriteria(Allocation.class).list();
    }
}
