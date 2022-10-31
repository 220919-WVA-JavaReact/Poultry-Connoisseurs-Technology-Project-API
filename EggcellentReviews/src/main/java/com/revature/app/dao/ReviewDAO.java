package com.revature.app.dao;

import com.revature.app.models.Review;

import java.util.List;

public interface ReviewDAO {

    Review createReview(Integer userId, String title, String description);

    List<Review> getAllReviews();

    List<Review> getReviewsByUserId(int id);

    boolean updateReview(Review review);
}
