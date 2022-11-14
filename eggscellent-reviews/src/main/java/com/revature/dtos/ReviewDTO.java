package com.revature.dtos;

import com.revature.entities.Movie;
import com.revature.entities.Review;
import com.revature.entities.User;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Objects;

public class ReviewDTO{

    //editing review DTO on 11/12 to no longer include UserDTO and Movie obj
    private String id;


    private String userId;

    private String authorUsername;

   // private UserDTO userId;

    private String title;

    private String summary;


    //private Movie movieId;



    public ReviewDTO(Review review) {
        this.id = review.getId();
        this.title = review.getTitle();
        this.summary = review.getSummary();
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAuthorUsername() {
        return authorUsername;
    }

    public void setAuthorUsername(String authorUsername) {
        this.authorUsername = authorUsername;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReviewDTO reviewDTO = (ReviewDTO) o;
        return Objects.equals(id, reviewDTO.id) && Objects.equals(userId, reviewDTO.userId) && Objects.equals(authorUsername, reviewDTO.authorUsername) && Objects.equals(title, reviewDTO.title) && Objects.equals(summary, reviewDTO.summary);    
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, authorUsername, title, summary);
    }

    @Override
    public String toString() {
        return "ReviewDTO{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", authorUsername='" + authorUsername + '\'' +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }
}

