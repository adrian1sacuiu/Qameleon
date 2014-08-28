package com.dao;

import com.domain.Allocation;

import java.util.List;

/**
 * Created by adrian.sacuiu on 8/21/2014.
 */
public interface AllocationDao {

    public Allocation createAllocation(Allocation allocation);

    public Allocation updateAllocation(Allocation allocation);

    public Allocation getAllocation(Long id);

    public Allocation deleteAllocation(Long id);

    public List<Allocation> getAllAllocations();
}
