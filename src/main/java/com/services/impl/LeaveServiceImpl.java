package com.services.impl;

import com.dao.LeaveDao;
import com.domain.Leave;
import com.services.LeaveService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by adrian.sacuiu on 8/28/2014.
 */
@Service
@Transactional
public class LeaveServiceImpl implements LeaveService {

    private LeaveDao leaveDao;

    @Autowired
    public LeaveServiceImpl(LeaveDao leaveDao) {
        this.leaveDao = leaveDao;
    }

    @Override
    public Leave addLeave(Leave leave) {
        return leaveDao.createLeave(leave);
    }

    @Override
    public Leave updateLeave(Leave leave) {
        return leaveDao.updateLeave(leave);
    }

    @Override
    @Transactional(readOnly = true)
    public Leave getLeaveById(Long id) {
        return leaveDao.getLeave(id);
    }


    @Override
    public Leave deleteLeave(Long id) {
        return leaveDao.deleteLeave(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Leave> getAllLeaves() {
        return leaveDao.getAllLeaves();
    }
}
