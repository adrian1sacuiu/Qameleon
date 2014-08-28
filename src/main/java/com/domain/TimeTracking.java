package com.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by adrian.sacuiu on 8/19/2014.
 */
@Entity
@Table(name = "timetracking")
public class TimeTracking implements Serializable {

    private static final long serialVersionUID = 10L;

    private Long id;
    private Project project;
    private Employee employee;
    private Phase phase;
    private int hours;
    private String notes;

    private String errorMessage;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idTimeTracking")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "idProject")
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
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
    @JoinColumn(name = "idPhase")
    public Phase getPhase() {
        return phase;
    }

    public void setPhase(Phase phase) {
        this.phase = phase;
    }

    @Column(name = "hours")
    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Column(name = "notes")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Column(name = "errorMessage")
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TimeTracking that = (TimeTracking) o;

        if (!id.equals(that.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "TimeTracking{" +
                "id=" + id +
                ", project=" + project +
                ", employee=" + employee +
                ", phase=" + phase +
                ", hours=" + hours +
                ", notes='" + notes + '\'' +
                '}';
    }
}
