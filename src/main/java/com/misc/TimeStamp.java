package com.misc;

import com.domain.Employee;

import java.util.Date;

/**
 * Created by adrian.sacuiu on 8/19/2014.
 */
public class TimeStamp {
    private Employee user;
    private Date date;

    public Employee getUser() {
        return user;
    }

    public void setUser(Employee user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TimeStamp timeStamp = (TimeStamp) o;

        if (date != null ? !date.equals(timeStamp.date) : timeStamp.date != null) return false;
        if (user != null ? !user.equals(timeStamp.user) : timeStamp.user != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TimeStamp{" +
                "user=" + user +
                ", date=" + date +
                '}';
    }
}
