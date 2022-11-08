package com.revature.dtos;

import com.revature.entities.Role;
import com.revature.entities.User;

import java.util.Objects;

public class UserDTO {
    private int id;
    private String username;
    private Role role;

    private String first;

    private String last;
    //rooster/manager id
    public UserDTO(){
    }
    public UserDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.role = user.getRole();
        this.first = user.getFirst();
        this.last = user.getLast();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", role=" + role +
                ", first='" + first + '\'' +
                ", last='" + last + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return id == userDTO.id && Objects.equals(username, userDTO.username) && role == userDTO.role && Objects.equals(first, userDTO.first) && Objects.equals(last, userDTO.last);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, role, first, last);
    }
}
