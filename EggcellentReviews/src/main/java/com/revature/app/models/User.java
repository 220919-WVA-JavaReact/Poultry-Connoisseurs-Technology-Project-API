package com.revature.app.models;

import java.util.Objects;

public class User {
    //variables
    private int userId;
    private String first;
    private String last;
    private String username;
    private String password;
    private boolean manager;
    //constructors
    public User(int userId, String first, String last, String username, String password, Boolean manager) {
        this.userId = userId;
        this.first = first;
        this.last = last;
        this.username = username;
        this.password = password;
        this.manager = manager;
    }

    public User(int employeeId) {
        this.userId = userId;
    }
    //getters and setters


    public int getUserId() {
        return userId;
    }

    public void setEmployeeId(int employeeId) {
        this.userId = userId;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isManager() {
        return manager;
    }

    public void setManager(boolean manager) {
        this.manager = manager;
    }
    //overrides
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getUserId() == user.getUserId() && isManager() == user.isManager() && Objects.equals(getFirst(), user.getFirst()) && Objects.equals(getLast(), user.getLast()) && Objects.equals(getUsername(), user.getUsername()) && Objects.equals(getPassword(), user.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getFirst(), getLast(), getUsername(), getPassword(), isManager());
    }

    @Override
    public String toString() {
        return "Employee number " +
                userId +
                ": first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", manager=" + manager;
    }
}
