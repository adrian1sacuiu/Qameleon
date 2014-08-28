package com.services.impl;

import com.dao.EmployeeDao;
import com.domain.Employee;
import com.services.EmployeeService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by adrian.sacuiu on 8/21/2014.
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeDao.createEmployee(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeDao.updateEmployee(employee);
    }

    @Override
    @Transactional(readOnly = true)
    public Employee getEmployeeById(Long id) {
        Employee employee = employeeDao.getEmployee(id);
        Hibernate.initialize(employee.getCompetences());
        Hibernate.initialize(employee.getTimeTrackings());
        Hibernate.initialize(employee.getLeaves());
        return employee;
    }

    @Override
    public Employee getEmployeeByEmail(String email) {
        List<Employee> employees = getAllEmployees();
        for(Employee employee:employees){
            if(employee.getEmail().equals(email)){
                return employee;
            }
        }
        return null;
    }

    @Override
    public Employee getEmployeeByUsername(String username) {
        List<Employee> employees = getAllEmployees();
        for(Employee employee:employees){
            if(employee.getUsername().equals(username)){
                return employee;
            }
        }
        return null;
    }

    @Override
    public Employee deleteEmployee(Long id) {
        return employeeDao.deleteEmployee(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeDao.getAllEmployees();
        for (Employee employee : employees) {
            Hibernate.initialize(employee.getCompetences());
            Hibernate.initialize(employee.getTimeTrackings());
            Hibernate.initialize(employee.getLeaves());
        }
        return employees;
    }
}
