package com.services.impl;

import com.dao.TimeTrackingDao;
import com.domain.Employee;
import com.domain.Project;
import com.domain.TimeTracking;
import com.services.TimeTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by adrian.sacuiu on 8/28/2014.
 */
@Service
@Transactional
public class TimeTrackingServiceImpl implements TimeTrackingService {

    private TimeTrackingDao timeTrackingDao;

    @Autowired
    public TimeTrackingServiceImpl(TimeTrackingDao timeTrackingDao) {
        this.timeTrackingDao = timeTrackingDao;
    }

    @Override
    public TimeTracking addTimeTracking(TimeTracking timeTracking) {
        return timeTrackingDao.createTimeTracking(timeTracking);
    }

    @Override
    public TimeTracking updateTimeTracking(TimeTracking timeTracking) {
        return timeTrackingDao.updateTimeTracking(timeTracking);
    }

    @Override
    @Transactional(readOnly = true)
    public TimeTracking getTimeTrackingById(Long id) {
        return timeTrackingDao.getTimeTracking(id);
    }


    @Override
    public TimeTracking deleteTimeTracking(Long id) {
        return timeTrackingDao.deleteTimeTracking(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TimeTracking> getAllTimeTrackings() {
        return timeTrackingDao.getAllTimeTrackings();
    }

    @Override
    public Map<Employee,Project> checkDuplicate(TimeTracking targetTimeTracking) {
        List<TimeTracking> timeTrackings = getAllTimeTrackings();
        for(TimeTracking timeTracking:timeTrackings){
            if(targetTimeTracking.getProject().equals(timeTracking.getProject())
                    && (targetTimeTracking.getEmployee().equals(timeTracking.getEmployee()))){
                Map<Employee,Project> result = new HashMap<Employee,Project>();
                result.put(timeTracking.getEmployee(), timeTracking.getProject());
                return result;
            }
        }
        return null;
    }
}