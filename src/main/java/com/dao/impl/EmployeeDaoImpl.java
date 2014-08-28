package com.dao.impl;


import com.dao.EmployeeDao;
import com.domain.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by adrian.sacuiu on 8/19/2014.
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private SessionFactory sessionFactory;

    @Autowired
    public EmployeeDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        currentSession().save(employee);
        return employee;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        currentSession().update(employee);
        return employee;
    }

    @Override
    public Employee getEmployee(Long id) {
        return (Employee) currentSession().get(Employee.class, id);
    }

    @Override
    public Employee deleteEmployee(Long id) {
        Employee employee = getEmployee(id);
        currentSession().delete(employee);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return currentSession().createCriteria(Employee.class).list();
    }
}
