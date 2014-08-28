package com.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by adrian.sacuiu on 8/19/2014.
 */
@Entity
@Table(name = "leaving")
public class Leave implements Serializable {

    private static final long serialVersionUID = 5L;

    private Long id;
    private Employee employee;
    private LeaveType leaveType;
    private int numberOfDays;
    private String leaveStatus;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idLeave")
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
    @JoinColumn(name = "idLeaveType")
    public LeaveType getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(LeaveType leaveType) {
        this.leaveType = leaveType;
    }

    @Column(name = "numberOfDays")
    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    @Column(name = "leaveStatus")
    public String getLeaveStatus() {
        return leaveStatus;
    }

    public void setLeaveStatus(String leaveStatus) {
        this.leaveStatus = leaveStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Leave leave = (Leave) o;

        if (!id.equals(leave.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Leave{" +
                "id=" + id +
                ", employee=" + employee +
                ", leaveType=" + leaveType +
                ", numberOfDays=" + numberOfDays +
                ", leaveStatus='" + leaveStatus + '\'' +
                '}';
    }
}
