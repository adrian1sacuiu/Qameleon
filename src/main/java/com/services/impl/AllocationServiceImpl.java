package com.services.impl;

import com.dao.AllocationDao;
import com.domain.Allocation;
import com.domain.Employee;
import com.domain.Project;
import com.services.AllocationService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by adrian.sacuiu on 8/28/2014.
 */

@Service
@Transactional
public class AllocationServiceImpl implements AllocationService{
    
    private AllocationDao allocationDao;

    @Autowired
    public AllocationServiceImpl(AllocationDao allocationDao) {
        this.allocationDao = allocationDao;
    }

    @Override
    public Allocation addAllocation(Allocation allocation) {
        return allocationDao.createAllocation(allocation);
    }

    @Override
    public Allocation updateAllocation(Allocation allocation) {
        return allocationDao.updateAllocation(allocation);
    }

    @Override
    @Transactional(readOnly = true)
    public Allocation getAllocationById(Long id) {
        Allocation allocation = allocationDao.getAllocation(id);
        Hibernate.initialize(allocation.getEmployees());
        return allocation;
    }

    @Override
    public Allocation deleteAllocation(Long id) {
        return allocationDao.deleteAllocation(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Allocation> getAllAllocations() {
        List<Allocation> allocations = allocationDao.getAllAllocations();
        for (Allocation allocation : allocations) {
            Hibernate.initialize(allocation.getEmployees());
        }
        return allocations;
    }

    @Override
    public Map<Employee,Project> checkDuplicate(Allocation targetAllocation) {
        List<Allocation> allocations = getAllAllocations();
        for(Allocation allocation:allocations){
            if(targetAllocation.getProject().equals(allocation.getProject())){
                List<Employee> employees = allocation.getEmployees();
                List<Employee> targetEmployees = targetAllocation.getEmployees();
                for(Employee employee:targetEmployees){
                    if(employees.contains(employee)){
                        Map<Employee,Project> result = new HashMap<Employee,Project>();
                        result.put(employee, allocation.getProject());
                        return result;
                    }
                }
            }
        }
        return null;
    }
}
