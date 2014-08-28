package com.dao;

import com.domain.TimeTracking;

import java.util.List;

/**
 * Created by adrian.sacuiu on 8/21/2014.
 */
public interface TimeTrackingDao {

    public TimeTracking createTimeTracking(TimeTracking TimeTracking);

    public TimeTracking updateTimeTracking(TimeTracking TimeTracking);

    public TimeTracking getTimeTracking(Long id);

    public TimeTracking deleteTimeTracking(Long id);

    public List<TimeTracking> getAllTimeTrackings();
}
