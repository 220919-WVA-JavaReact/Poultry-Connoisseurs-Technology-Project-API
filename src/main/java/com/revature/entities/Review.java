package com.revature.entities;

import com.revature.dtos.CreateReviewDTO;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name="reviews")
public class Review {
    @Id
    @Column(name="review_id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User userId;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String summary;

    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    private Movie movieId;

    public Review(User userId, String title, String summary, Movie movieId) {
        this.id = UUID.randomUUID().toString();
        this.userId = userId;
        this.title = title;
        this.summary = summary;
        this.movieId = movieId;
    }
    public Review(){
        this.id = UUID.randomUUID().toString();
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
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

    public void setMovieId(Movie movieId) {
        this.movieId = movieId;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id='" + id + '\'' +
                ", user_id=" + userId +
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
        return Objects.equals(id, review.id) && Objects.equals(userId, review.userId) && Objects.equals(title, review.title) && Objects.equals(summary, review.summary) && Objects.equals(movieId, review.movieId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, title, summary, movieId);
    }
}
