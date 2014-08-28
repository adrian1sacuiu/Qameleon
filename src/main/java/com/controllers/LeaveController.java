package com.controllers;

import com.domain.Leave;
import com.services.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by adrian.sacuiu on 8/28/2014.
 */
@Controller
@RequestMapping(value = "/leaves")
public class LeaveController {

    private LeaveService leaveService;

    @Autowired
    public LeaveController(LeaveService leaveService){
        this.leaveService = leaveService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Leave getLeave(@PathVariable Long id){
        return leaveService.getLeaveById(id);
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<Leave> getAllLeaves(){
        return leaveService.getAllLeaves();
    }

    @RequestMapping(value = "/addLeave", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody Leave addLeave(@RequestBody Leave leave, HttpServletResponse response){
        leaveService.addLeave(leave);
        response.setStatus(HttpServletResponse.SC_CREATED);
        response.setHeader("Location",leave.getId().toString());
        System.out.println("Leave created: "+leave);
        return leave;
    }
}
