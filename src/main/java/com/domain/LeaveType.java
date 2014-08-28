package com.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by adrian.sacuiu on 8/20/2014.
 */
@Entity
@Table(name = "leaveType")
public class LeaveType implements Serializable {

    private static final long serialVersionUID = 6L;

    private Long id;
    private String name;
    private boolean requiresApproval;
    private List<Leave> leaves;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idLeaveType")
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

    @Column(name = "requiresApproval")
    public boolean isRequiresApproval() {
        return requiresApproval;
    }

    public void setRequiresApproval(boolean requiresApproval) {
        this.requiresApproval = requiresApproval;
    }

    @OneToMany(mappedBy = "leaveType")
    public List<Leave> getLeaves() {
        return leaves;
    }

    public void setLeaves(List<Leave> leaves) {
        this.leaves = leaves;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LeaveType leaveType = (LeaveType) o;

        if (!id.equals(leaveType.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "LeaveType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", requiresApproval=" + requiresApproval +
                ", leaves=" + leaves +
                '}';
    }
}
