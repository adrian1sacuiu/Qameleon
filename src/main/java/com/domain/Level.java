package com.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by adrian.sacuiu on 8/20/2014.
 */
@Entity
@Table(name = "level")
public class Level implements Serializable {

    private static final long serialVersionUID = 7L;

    private Long id;
    private String name;
    private List<CompetenceLevel> competenceLevels;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idLevel")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "level")
    public List<CompetenceLevel> getCompetenceLevels() {
        return competenceLevels;
    }

    public void setCompetenceLevels(List<CompetenceLevel> competenceLevels) {
        this.competenceLevels = competenceLevels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Level level = (Level) o;

        if (!id.equals(level.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Level{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", competenceLevels=" + competenceLevels +
                '}';
    }
}
