package com.revature.services;

import com.revature.entities.Reviews;
import com.revature.exceptions.RegisterException;
import com.revature.exceptions.ReviewNotFoundException;
import com.revature.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private ReviewRepository rr;

    @Autowired
    public ReviewService(ReviewRepository rr) { this.rr = rr; }
    public List<Reviews> getReviewsByMovieId(int id) {
        List<Reviews> reviews = rr.findReviewsByMovieId(id);
        if (reviews == null) {
            throw new ReviewNotFoundException();
        } else {
            return reviews;
        }
    }
}
