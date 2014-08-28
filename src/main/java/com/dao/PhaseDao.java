package com.dao;

import com.domain.Phase;

import java.util.List;

/**
 * Created by adrian.sacuiu on 8/21/2014.
 */
public interface PhaseDao {

    public Phase createPhase(Phase Phase);

    public Phase updatePhase(Phase Phase);

    public Phase getPhase(Long id);

    public Phase deletePhase(Long id);

    public List<Phase> getAllPhases();
}
