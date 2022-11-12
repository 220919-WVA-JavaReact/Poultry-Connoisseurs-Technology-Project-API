package com.revature.controllers;

import com.revature.dtos.ReviewDTO;
import com.revature.entities.Review;
import com.revature.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private ReviewService rs;

    @Autowired
    public ReviewController(ReviewService rs){
        System.out.println("ReviewController was instantiated");
        this.rs = rs;
    }

    @GetMapping("/{movieID}")
    public ResponseEntity<List<ReviewDTO>> getReviewsByMovieId(@PathVariable("movieID") String id) {
        List<ReviewDTO> reviews = rs.getReviewsByMovieId(id);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Review review){
        review = rs.createReview(review);
        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }
}
