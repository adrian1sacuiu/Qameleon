package com.controllers;

import com.domain.Project;
import com.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by adrian.sacuiu on 8/27/2014.
 */
@Controller
@RequestMapping(value = "/projects")
public class ProjectController {
    
    private ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public @ResponseBody Project getProject(@PathVariable String name){
        return projectService.getProjectByName(name);
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Project> getAllProjects(){
        return projectService.getAllProjects();
    }

    @RequestMapping(value = "/addProject", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody Project addProject(@RequestBody Project project, HttpServletResponse response){
        Project error = new Project();
        if(projectService.getProjectByName(project.getName()) != null){
            error.setErrorMessage("Error: Project name already taken.");
            return error;
        }
        projectService.addProject(project);
        response.setStatus(HttpServletResponse.SC_CREATED);
        response.setHeader("Location",project.getName());
        System.out.println("Project created: "+project);
        return project;
    }

    @RequestMapping(value = "/editProject", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public @ResponseBody Project editProject(@RequestBody Project project, HttpServletResponse response){
        Project error = new Project();
        if(projectService.getProjectByName(project.getName()) != null){
            error.setErrorMessage("Error: Project name already taken.");
            return error;
        }
        projectService.updateProject(project);
        response.setStatus(HttpServletResponse.SC_OK);
        System.out.println("Project updated: "+project);
        return project;
    }
    @RequestMapping(value = "/deleteProject", method = RequestMethod.DELETE)
    public void deleteProject(Long id, HttpServletResponse response){
        projectService.deleteProject(id);
        response.setStatus(HttpServletResponse.SC_OK);
    }
}

