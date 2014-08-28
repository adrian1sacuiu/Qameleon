package com.controllers;

import com.domain.Employee;
import com.google.api.client.json.GenericJson;
import com.misc.GoogleAuthHelper;
import com.services.EmployeeService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by adrian.sacuiu on 8/25/2014.
 */
@Controller
public class LoginController {

    private EmployeeService employeeService;
    private GoogleAuthHelper googleAuthHelper;

    @Autowired
    public LoginController(EmployeeService employeeService, GoogleAuthHelper googleAuthHelper) {
        this.employeeService = employeeService;
        this.googleAuthHelper = googleAuthHelper;
    }

    @RequestMapping(value = "/employees/authenticate")
    public ModelAndView login(Model model, HttpServletRequest request){
        ModelAndView mv = new ModelAndView("redirect:/#/login");
        try {
            GenericJson userInfo = googleAuthHelper.getUserInfoJson(request.getParameter("code"));
            Employee employee = employeeService.getEmployeeByEmail((String)userInfo.get("email"));
            if(employee == null){
                return mv;
            }
            else{
                request.getSession().setAttribute("employee",employee);
                mv.setView(new RedirectView("/index.jsp"));
                return mv;
            }
        }
        catch (IOException e){
            e.printStackTrace();
            return mv;
        }
    }


}
