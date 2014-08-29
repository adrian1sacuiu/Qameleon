package com.controllers;

import com.domain.Employee;
import com.google.api.client.json.GenericJson;
import com.misc.GoogleAuthHelper;
import com.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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
                HttpSession session = request.getSession(true);
                session.setAttribute("employee", employee);
                System.out.println(session == null);
                System.out.println(session.getAttribute("employee"));
                mv.setView(new RedirectView("/index.jsp"));
                return mv;
            }
        }
        catch (IOException e){
            e.printStackTrace();
            return mv;
        }
    }

    @RequestMapping(value = "/login")
    public String redirectLogin(){
        return "/resources/views/login.jsp";
    }

}
