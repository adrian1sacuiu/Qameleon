package com.dao;

import com.domain.Employee;

import java.util.List;

/**
 * Created by adrian.sacuiu on 8/19/2014.
 */
public interface EmployeeDao {

    public Employee createEmployee(Employee employee);

    public Employee updateEmployee(Employee employee);

    public Employee getEmployee(Long id);

    public Employee deleteEmployee(Long id);

    public List<Employee> getAllEmployees();

}
