package com.controllers;

import com.domain.Employee;
import com.domain.Project;
import com.domain.TimeTracking;
import com.services.TimeTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by adrian.sacuiu on 8/28/2014.
 */
@Controller
@RequestMapping(value = "/timeTrackings")
public class TimeTrackingController {

    private TimeTrackingService timeTrackingService;

    @Autowired
    public TimeTrackingController(TimeTrackingService timeTrackingService){
        this.timeTrackingService = timeTrackingService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    TimeTracking getTimeTracking(@PathVariable Long id){
        return timeTrackingService.getTimeTrackingById(id);
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<TimeTracking> getAllTimeTrackings(){
        return timeTrackingService.getAllTimeTrackings();
    }

    @RequestMapping(value = "/addTimeTracking", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody TimeTracking addTimeTracking(@RequestBody TimeTracking timeTracking, HttpServletResponse response){
        TimeTracking error = new TimeTracking();
        Map<Employee,Project> duplicate;
        if((duplicate = timeTrackingService.checkDuplicate(timeTracking)) != null){
            error.setErrorMessage("Error: Employee already on project: "+duplicate);
            return error;
        }
        timeTrackingService.addTimeTracking(timeTracking);
        response.setStatus(HttpServletResponse.SC_CREATED);
        response.setHeader("Location",timeTracking.getId().toString());
        System.out.println("TimeTracking created: "+timeTracking);
        return timeTracking;
    }
}
