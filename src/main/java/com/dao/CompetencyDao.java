package com.dao;

import com.domain.Competency;

import java.util.List;

/**
 * Created by adrian.sacuiu on 8/21/2014.
 */
public interface CompetencyDao {

    public Competency createCompetency(Competency competency);

    public Competency updateCompetency(Competency competency);

    public Competency getCompetency(Long id);

    public Competency deleteCompetency(Long id);

    public List<Competency> getAllCompetencies();
}
