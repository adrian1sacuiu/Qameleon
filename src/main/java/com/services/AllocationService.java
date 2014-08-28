package com.services;

import com.domain.Allocation;
import com.domain.Employee;
import com.domain.Project;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by adrian.sacuiu on 8/28/2014.
 */
public interface AllocationService {

    public Allocation addAllocation(Allocation allocation);

    public Allocation updateAllocation(Allocation allocation);

    public Allocation getAllocationById(Long id);

    public Allocation deleteAllocation(Long id);

    public List<Allocation> getAllAllocations();

    public Map<Employee,Project> checkDuplicate(Allocation allocation);

}