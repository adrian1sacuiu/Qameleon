package com.services.impl;

import com.dao.CompetenceLevelDao;
import com.domain.CompetenceLevel;
import com.services.CompetenceLevelService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by adrian.sacuiu on 8/28/2014.
 */
@Service
@Transactional
public class CompetenceLevelServiceImpl implements CompetenceLevelService {

    private CompetenceLevelDao competenceLevelDao;

    @Autowired
    public CompetenceLevelServiceImpl(CompetenceLevelDao competenceLevelDao) {
        this.competenceLevelDao = competenceLevelDao;
    }

    @Override
    public CompetenceLevel addCompetenceLevel(CompetenceLevel competenceLevel) {
        return competenceLevelDao.createCompetenceLevel(competenceLevel);
    }

    @Override
    public CompetenceLevel updateCompetenceLevel(CompetenceLevel competenceLevel) {
        return competenceLevelDao.updateCompetenceLevel(competenceLevel);
    }

    @Override
    @Transactional(readOnly = true)
    public CompetenceLevel getCompetenceLevelById(Long id) {
        return competenceLevelDao.getCompetenceLevel(id);
    }

    @Override
    public CompetenceLevel deleteCompetenceLevel(Long id) {
        return competenceLevelDao.deleteCompetenceLevel(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CompetenceLevel> getAllCompetenceLevels() {
        return competenceLevelDao.getAllCompetenceLevels();
    }
}
