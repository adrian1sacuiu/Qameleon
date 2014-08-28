package com.dao;

import com.domain.CompetenceLevel;

import java.util.List;

/**
 * Created by adrian.sacuiu on 8/21/2014.
 */
public interface CompetenceLevelDao {

    public CompetenceLevel createCompetenceLevel(CompetenceLevel competenceLevel);

    public CompetenceLevel updateCompetenceLevel(CompetenceLevel competenceLevel);

    public CompetenceLevel getCompetenceLevel(Long id);

    public CompetenceLevel deleteCompetenceLevel(Long id);

    public List<CompetenceLevel> getAllCompetenceLevels();
}