package com.services;

import com.domain.Employee;
import com.domain.Project;
import com.domain.TimeTracking;

import java.util.List;
import java.util.Map;

/**
 * Created by adrian.sacuiu on 8/28/2014.
 */
public interface TimeTrackingService {

    public TimeTracking addTimeTracking(TimeTracking TimeTracking);

    public TimeTracking updateTimeTracking(TimeTracking TimeTracking);

    public TimeTracking getTimeTrackingById(Long id);

    public TimeTracking deleteTimeTracking(Long id);

    public List<TimeTracking> getAllTimeTrackings();

    public Map<Employee,Project> checkDuplicate(TimeTracking timeTracking);

}