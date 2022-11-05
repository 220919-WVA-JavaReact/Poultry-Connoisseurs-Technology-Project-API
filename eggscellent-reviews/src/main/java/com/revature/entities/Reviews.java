package com.revature.entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name="reviews")
public class Reviews {
    @Id
    @Column(name="review_id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user_id;

    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    private Movies movieId;

    public Reviews(){
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public Movies getMovie_id() {
        return movieId;
    }

    public void setMovie_id(Movies movie_id) {
        this.movieId = movie_id;
    }

    @Override
    public String toString() {
        return "Reviews{" +
                "id='" + id + '\'' +
                ", user_id=" + user_id +
                ", movie_id=" + movieId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reviews reviews = (Reviews) o;
        return Objects.equals(id, reviews.id) && Objects.equals(user_id, reviews.user_id) && Objects.equals(movieId, reviews.movieId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user_id, movieId);
    }
}
