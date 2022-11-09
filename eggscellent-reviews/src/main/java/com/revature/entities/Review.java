package com.revature.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="reviews")
public class Review {
    @Id
    @Column(name="review_id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user_id;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String summary;

    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    private Movie movieId;

    public Review(){
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Movie getMovieId() {
        return movieId;
    }

    public void setMovieId(Movie movie_id) {
        this.movieId = movie_id;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id='" + id + '\'' +
                ", user_id=" + user_id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", movieId=" + movieId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return Objects.equals(id, review.id) && Objects.equals(user_id, review.user_id) && Objects.equals(title, review.title) && Objects.equals(summary, review.summary) && Objects.equals(movieId, review.movieId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user_id, title, summary, movieId);
    }
}
