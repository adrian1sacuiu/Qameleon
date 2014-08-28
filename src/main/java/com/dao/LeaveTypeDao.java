package com.dao;

import com.domain.LeaveType;

import java.util.List;

/**
 * Created by adrian.sacuiu on 8/21/2014.
 */
public interface LeaveTypeDao {

    public LeaveType createLeaveType(LeaveType LeaveType);

    public LeaveType updateLeaveType(LeaveType LeaveType);

    public LeaveType getLeaveType(Long id);

    public LeaveType deleteLeaveType(Long id);

    public List<LeaveType> getAllLeaveTypes();
}
