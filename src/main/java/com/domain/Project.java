package com.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by adrian.sacuiu on 8/19/2014.
 */

@Entity
@Table(name = "project")
@XmlRootElement
public class Project implements Serializable {

    private static final long serialVersionUID = 9L;

    private Long id;
    private String name;
    private Date startDate;
    private Date endDate;
    private double budgetValue;
    private String budgetType;
    private String type;
    private String description;
    private String tags;
    private Employee manager;
    private Phase phase;
    private Allocation allocation;
    private List<TimeTracking> timeTracking;

    private String errorMessage;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idProject")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name", unique=true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "startDate")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Column(name = "endDate")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Column(name = "budgetValue")
    public double getBudgetValue() {
        return budgetValue;
    }

    public void setBudgetValue(double budgetValue) {
        this.budgetValue = budgetValue;
    }

    @Column(name = "budgetType")
    public String getBudgetType() {
        return budgetType;
    }

    public void setBudgetType(String budgetType) {
        this.budgetType = budgetType;
    }

    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "tags")
    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @ManyToOne
    @JoinColumn(name = "idManager")
    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    @ManyToOne
    @JoinColumn(name = "idPhase")
    public Phase getPhase() {
        return phase;
    }

    public void setPhase(Phase phase) {
        this.phase = phase;
    }

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "project")
    public Allocation getAllocation() {
        return allocation;
    }

    public void setAllocation(Allocation allocation) {
        this.allocation = allocation;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    public List<TimeTracking> getTimeTracking() {
        return timeTracking;
    }

    public void setTimeTracking(List<TimeTracking> timeTracking) {
        this.timeTracking = timeTracking;
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

        Project project = (Project) o;

        if (!id.equals(project.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", budgetValue=" + budgetValue +
                ", budgetType='" + budgetType + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", tags='" + tags + '\'' +
                ", manager=" + manager +
                ", phase=" + phase +
                ", allocation=" + allocation +
                ", timeTracking=" + timeTracking +
                '}';
    }
}
