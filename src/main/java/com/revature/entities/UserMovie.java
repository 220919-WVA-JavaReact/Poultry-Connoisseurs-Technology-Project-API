package com.revature.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name= "users_movies")
public class UserMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User userId;

    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    private Movie movieId;

    public UserMovie(User userId, Movie movieId) {
        this.userId = userId;
        this.movieId = movieId;
    }

    public UserMovie() {

    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Movie getMovieId() {
        return movieId;
    }

    public void setMovieId(Movie movieId) {
        this.movieId = movieId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserMovie userMovie = (UserMovie) o;
        return Objects.equals(getUserId(), userMovie.getUserId()) && Objects.equals(getMovieId(), userMovie.getMovieId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getMovieId());
    }

    @Override
    public String toString() {
        return "UserMovie{" +
                "userId=" + userId +
                ", movieId=" + movieId +
                '}';
    }
}
