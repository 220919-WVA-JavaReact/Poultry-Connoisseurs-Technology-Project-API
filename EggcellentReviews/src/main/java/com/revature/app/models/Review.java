package com.revature.app.models;

import java.util.Objects;

public class Review {
    //variables
    private int reviewId;
    private int userId;
    private String title;
    private String description;
    //constructors
    public Review(int reviewId, int userId, String title, String description) {
        this.reviewId = reviewId;
        this.userId = userId;
        this.title = title;
        this.description = description;
    }

    public Review() {
    }
    //getters and setters

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //overrides
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return getReviewId() == review.getReviewId() && getUserId() == review.getUserId() && getTitle() == review.getTitle() && Objects.equals(getDescription(), review.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReviewId(), getUserId(), getTitle(), getDescription());
    }

    @Override
    public String toString() {
        return "Ticket number " +
                reviewId +
                "\nEmployeeId: " + userId +
                "\nAmount: " + title +
                "\nDescription: '" + description + '\'';

    }

}