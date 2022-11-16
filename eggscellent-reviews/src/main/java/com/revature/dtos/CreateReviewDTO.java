package com.revature.dtos;

import java.util.Objects;

public class CreateReviewDTO {

    private String userId;
    private String title;
    private String summary;
    private String movieId;

    public CreateReviewDTO() {
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
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

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateReviewDTO that = (CreateReviewDTO) o;
        return Objects.equals(getUserId(), that.getUserId()) && Objects.equals(getTitle(), that.getTitle()) && Objects.equals(getSummary(), that.getSummary()) && Objects.equals(getMovieId(), that.getMovieId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getTitle(), getSummary(), getMovieId());
    }

    @Override
    public String toString() {
        return "CreateReviewDTO{" +
                "userId='" + userId + '\'' +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", movieId='" + movieId + '\'' +
                '}';
    }
}
