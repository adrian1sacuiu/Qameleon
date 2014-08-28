package com.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by adrian.sacuiu on 8/19/2014.
 */
@Entity
@Table(name = "competenceLevel")
public class CompetenceLevel implements Serializable {

    private static final long serialVersionUID = 2L;

    private Long id;
    private Employee employee;
    private Competency competency;
    private Level level;
    private int hourlyRate;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idCompetenceLevel")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "idEmployee")
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @ManyToOne
    @JoinColumn(name = "idCompetency")
    public Competency getCompetency() {
        return competency;
    }

    public void setCompetency(Competency competency) {
        this.competency = competency;
    }

    @ManyToOne
    @JoinColumn(name = "idLevel")
    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    @Column(name = "hourlyRate")
    public int getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompetenceLevel that = (CompetenceLevel) o;

        if (!id.equals(that.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "CompetenceLevel{" +
                "id=" + id +
                ", employee=" + employee +
                ", competency=" + competency +
                ", level=" + level +
                ", hourlyRate=" + hourlyRate +
                '}';
    }
}
