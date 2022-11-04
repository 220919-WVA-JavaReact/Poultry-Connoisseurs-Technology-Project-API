package com.revature.entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    @Column(name = "first_name", nullable = false)
    private String first;
    @Column(name = "last_name", nullable = false)
    private String last;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    //do our relationships

    //stretch goal views views_status

    public User(int id, String first, String last, String username, String password, Role role) {
        this.user_id = id;
        this.first = first;
        this.last = last;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User(String first, String last, String username, String password, Role role) {
        this.first = first;
        this.last = last;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User() {
    }

    public int getId() {
        return user_id;
    }

    public void setId(int id) {
        this.user_id = id;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(user_id, user.user_id) && Objects.equals(first, user.first) && Objects.equals(last, user.last) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, first, last, username, password, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + user_id + '\'' +
                ", first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
