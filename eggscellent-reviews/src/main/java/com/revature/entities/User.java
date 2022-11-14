package com.revature.entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="users")
public class User {

    @Id
    @Column(name = "user_id")
    private String userId;
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
//    @ManyToOne
//    private User moderator;
    //stretch goal views views_status

    public User(String id, String first, String last, String username, String password, Role role) {
        this.userId = id;
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

            this.userId = UUID.randomUUID().toString();

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

//    public User getModerator() {
//        return moderator;
//    }
//
//    public void setModerator(User moderator) {
//        this.moderator = moderator;
//    }
}
