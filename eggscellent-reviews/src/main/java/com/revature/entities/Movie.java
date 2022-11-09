package com.revature.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="movie")
public class Movie {

    @Id
    @Column(name = "id")
    private String id;

    @Column
    private String title;

    @Column
    private Integer runtime;

    @Column
    private String stars;

    @Column
    private Float rating;


    public Movie() {
    }

    public Movie(String id, String title, Integer runtime, String stars, Float rating) {
        this.id = id;
        this.title = title;
        this.runtime = runtime;
        this.stars = stars;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", runtime=" + runtime +
                ", stars='" + stars + '\'' +
                ", rating=" + rating +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movies = (Movie) o;
        return Objects.equals(id, movies.id) && Objects.equals(title, movies.title) && Objects.equals(runtime, movies.runtime) && Objects.equals(stars, movies.stars) && Objects.equals(rating, movies.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, runtime, stars, rating);
    }
}
