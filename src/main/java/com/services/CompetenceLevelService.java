package com.services;

import com.domain.CompetenceLevel;

import java.util.List;

/**
 * Created by adrian.sacuiu on 8/28/2014.
 */
public interface CompetenceLevelService {
    public CompetenceLevel addCompetenceLevel(CompetenceLevel competenceLevel);

    public CompetenceLevel updateCompetenceLevel(CompetenceLevel competenceLevel);

    public CompetenceLevel getCompetenceLevelById(Long id);

    public CompetenceLevel deleteCompetenceLevel(Long id);

    public List<CompetenceLevel> getAllCompetenceLevels();
}
