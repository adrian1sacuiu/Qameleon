package com.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by adrian.sacuiu on 8/19/2014.
 */
@Entity
@Table(name = "employee")
@XmlRootElement
public class Employee implements Serializable {

    private static final long serialVersionUID = 4L;

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Date startDate;
    private String contractType;
    private String username;
    private String tags;
    private Allocation allocation;
    private List<Allocation> allocations;
    private List<CompetenceLevel> competences;
    private List<TimeTracking> timeTrackings;
    private List<Leave> leaves;

    private String errorMessage;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idEmployee")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "lastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "email", unique=true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "startDate")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Column(name = "contractType")
    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    @Column(name = "username", unique=true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "tags")
    public String getTag() {
        return tags;
    }

    public void setTag(String tags) {
        this.tags = tags;
    }

    @ManyToOne
    @JoinColumn(name = "idAllocation")
    public Allocation getAllocation() {
        return allocation;
    }

    public void setAllocation(Allocation allocation) {
        this.allocation = allocation;
    }

    @OneToMany(mappedBy = "employee")
    public List<CompetenceLevel> getCompetences() {
        return competences;
    }

    public void setCompetences(List<CompetenceLevel> competences) {
        this.competences = competences;
    }


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    public List<TimeTracking> getTimeTrackings() {
        return timeTrackings;
    }

    public void setTimeTrackings(List<TimeTracking> timeTrackings) {
        this.timeTrackings = timeTrackings;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    public List<Leave> getLeaves() {
        return leaves;
    }

    public void setLeaves(List<Leave> leaves) {
        this.leaves = leaves;
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

        Employee user = (Employee) o;

        if (!id.equals(user.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", allocation=" + allocation +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", startDate=" + startDate +
                ", contractType='" + contractType + '\'' +
                ", username='" + username + '\'' +
                ", tags='" + tags + '\'' +
                ", allocations=" + allocations +
                ", competences=" + competences +
                ", timeTrackings=" + timeTrackings +
                ", leavse=" + leaves +
                '}';
    }
}
