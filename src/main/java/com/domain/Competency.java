package com.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by adrian.sacuiu on 8/20/2014.
 */
@Entity
@Table(name = "competency")
public class Competency implements Serializable {

    private static final long serialVersionUID = 3L;

    private Long id;
    private String name;
    private List<CompetenceLevel> competenceLevels;
    private List<Allocation> allocations;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idCompetency")
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

    @OneToMany(mappedBy = "competency")
    public List<CompetenceLevel> getCompetenceLevels() {
        return competenceLevels;
    }

    public void setCompetenceLevels(List<CompetenceLevel> competenceLevels) {
        this.competenceLevels = competenceLevels;
    }

    @OneToMany(mappedBy = "competency")
    public List<Allocation> getAllocations() {
        return allocations;
    }

    public void setAllocations(List<Allocation> allocations) {
        this.allocations = allocations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Competency that = (Competency) o;

        if (!id.equals(that.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Competency{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", competenceLevels=" + competenceLevels +
                ", allocations=" + allocations +
                '}';
    }
}
