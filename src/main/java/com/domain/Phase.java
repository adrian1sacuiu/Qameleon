package com.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by adrian.sacuiu on 8/19/2014.
 */
@Entity
@Table(name = "phase")
public class Phase implements Serializable {

    private static final long serialVersionUID = 8L;

    private Long id;
    private String name;
    private List<TimeTracking> timeTrackings;
    private List<Project> projects;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idPhase")
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

    @OneToMany(mappedBy = "phase")
    public List<TimeTracking> getTimeTrackings() {
        return timeTrackings;
    }

    public void setTimeTrackings(List<TimeTracking> timeTrackings) {
        this.timeTrackings = timeTrackings;
    }

    @OneToMany(mappedBy = "phase")
    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Phase phase = (Phase) o;

        if (!id.equals(phase.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Phase{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", timeTrackings=" + timeTrackings +
                ", projects=" + projects +
                '}';
    }
}
