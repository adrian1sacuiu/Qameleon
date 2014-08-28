package com.controllers;

import com.domain.Allocation;
import com.domain.Employee;
import com.domain.Project;
import com.services.AllocationService;
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
@RequestMapping(value = "/allocations")
public class AllocationController {

    private AllocationService allocationService;

    @Autowired
    public AllocationController(AllocationService allocationService){
        this.allocationService = allocationService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Allocation getAllocation(@PathVariable Long id){
        return allocationService.getAllocationById(id);
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Allocation> getAllAllocations(){
        return allocationService.getAllAllocations();
    }

    @RequestMapping(value = "/addAllocation", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody Allocation addAllocation(@RequestBody Allocation allocation, HttpServletResponse response){
        Allocation error = new Allocation();
        Map<Employee,Project> duplicate;
        if((duplicate = allocationService.checkDuplicate(allocation)) != null){
            error.setErrorMessage("Error: Employee already on project: "+duplicate);
            return error;
        }
        allocationService.addAllocation(allocation);
        response.setStatus(HttpServletResponse.SC_CREATED);
        response.setHeader("Location",allocation.getId().toString());
        System.out.println("Allocation created: "+allocation);
        return allocation;
    }
}

