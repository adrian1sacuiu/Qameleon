package com.controllers;

import com.domain.CompetenceLevel;
import com.services.CompetenceLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by adrian.sacuiu on 8/28/2014.
 */
@Controller
@RequestMapping(value = "/competenceLevels")
public class CompetenceLevelController {

    private CompetenceLevelService competenceLevelService;

    @Autowired
    public CompetenceLevelController(CompetenceLevelService competenceLevelService){
        this.competenceLevelService = competenceLevelService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody CompetenceLevel getCompetenceLevel(@PathVariable Long id){
        return competenceLevelService.getCompetenceLevelById(id);
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<CompetenceLevel> getAllCompetenceLevels(){
        return competenceLevelService.getAllCompetenceLevels();
    }

    @RequestMapping(value = "/addCompetenceLevel", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody CompetenceLevel addCompetenceLevel(@RequestBody CompetenceLevel competenceLevel, HttpServletResponse response){
        competenceLevelService.addCompetenceLevel(competenceLevel);
        response.setStatus(HttpServletResponse.SC_CREATED);
        response.setHeader("Location",competenceLevel.getId().toString());
        System.out.println("CompetenceLevel created: "+competenceLevel);
        return competenceLevel;
    }
}
