package com.services;

import com.domain.Leave;

import java.util.Date;
import java.util.List;

/**
 * Created by adrian.sacuiu on 8/28/2014.
 */
public interface LeaveService {

    public Leave addLeave(Leave leave);

    public Leave updateLeave(Leave leave);

    public Leave getLeaveById(Long id);

    public Leave deleteLeave(Long id);

    public List<Leave> getAllLeaves();
}
