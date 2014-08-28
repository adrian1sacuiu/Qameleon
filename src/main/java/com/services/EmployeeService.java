package com.services;

import com.domain.Employee;

import java.util.List;

/**
 * Created by adrian.sacuiu on 8/21/2014.
 */
public interface EmployeeService {

    public Employee addEmployee(Employee employee);

    public Employee updateEmployee(Employee employee);

    public Employee getEmployeeById(Long id);

    public Employee getEmployeeByEmail(String email);

    public Employee getEmployeeByUsername(String username);

    public Employee deleteEmployee(Long id);

    public List<Employee> getAllEmployees();



}
