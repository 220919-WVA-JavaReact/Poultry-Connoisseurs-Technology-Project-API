package com.revature.dtos;

import com.revature.entities.Movie;
import com.revature.entities.Review;
import com.revature.entities.User;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ReviewDTO{

    private String id;

    private UserDTO userId;
    private String title;
    private String summary;

    private Movie movieId;

    public ReviewDTO(Review review) {
        this.id = review.getId();
        this.userId = new UserDTO(review.getUserId());
        this.title = review.getTitle();
        this.summary = review.getSummary();
        this.movieId = review.getMovieId();
    }
}
