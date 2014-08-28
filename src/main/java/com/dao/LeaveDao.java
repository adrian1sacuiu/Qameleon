package com.dao;

import com.domain.Leave;

import java.util.List;

/**
 * Created by adrian.sacuiu on 8/21/2014.
 */
public interface LeaveDao {

    public Leave createLeave(Leave leave);

    public Leave updateLeave(Leave leave);

    public Leave getLeave(Long id);

    public Leave deleteLeave(Long id);

    public List<Leave> getAllLeaves();
}
