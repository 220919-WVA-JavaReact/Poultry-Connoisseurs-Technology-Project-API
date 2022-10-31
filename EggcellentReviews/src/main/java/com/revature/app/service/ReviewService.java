package com.revature.app.service;

import com.revature.app.dao.ReviewDAO;
import com.revature.app.dao.ReviewDAOimpl;
import com.revature.app.models.Review;

import java.util.List;

public class ReviewService {

    ReviewDAO rd = new ReviewDAOimpl();

    public List<Review> getReviews(int id){
        return rd.getReviewsByUserId(id);
    }

    public Review createReview(int userId, String title, String description){
        return rd.createReview(userId,title,description);
    }

}
