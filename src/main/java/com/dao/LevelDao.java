package com.dao;

import com.domain.Level;

import java.util.List;

/**
 * Created by adrian.sacuiu on 8/21/2014.
 */
public interface LevelDao {

    public Level createLevel(Level Level);

    public Level updateLevel(Level Level);

    public Level getLevel(Long id);

    public Level deleteLevel(Long id);

    public List<Level> getAllLevels();
}
