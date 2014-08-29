package com.controllers;

import com.domain.Employee;
import com.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by adrian.sacuiu on 8/21/2014.
 */
@Controller
@RequestMapping(value = "/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public @ResponseBody Employee getEmployee(@PathVariable String username){
        return employeeService.getEmployeeByUsername(username);
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody Employee addEmployee(@RequestBody Employee employee, HttpServletResponse response){
        Employee error = new Employee();
        if(employeeService.getEmployeeByUsername(employee.getUsername()) != null){
            error.setErrorMessage("Error: Username already taken.");
            return error;
        }
        else if(employeeService.getEmployeeByEmail(employee.getEmail()) !=null){
            error.setErrorMessage("Error: Email already taken.");
            return error;
        }
        employeeService.addEmployee(employee);
        response.setStatus(HttpServletResponse.SC_CREATED);
        response.setHeader("Location",employee.getUsername());
        System.out.println("Employee created: "+employee);
        return employee;
    }

    @RequestMapping(value = "/editEmployee", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public @ResponseBody Employee editEmployee(@RequestBody Employee employee, HttpServletResponse response){
        Employee error = new Employee();
        if(employeeService.getEmployeeByUsername(employee.getUsername()) != null){
            error.setErrorMessage("Error: Username already taken.");
            return error;
        }
        else if(employeeService.getEmployeeByEmail(employee.getEmail()) !=null){
            error.setErrorMessage("Error: Email already taken.");
            return error;
        }
        employeeService.updateEmployee(employee);
        response.setStatus(HttpServletResponse.SC_OK);
        System.out.println("Employee updated: "+employee);
        return employee;
    }
    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.DELETE)
    public void deleteEmployee(Long id, HttpServletResponse response){
        employeeService.deleteEmployee(id);
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
