package com.revature.controllers;

import com.revature.annotations.RoleFilter;
import com.revature.dtos.CreateReviewDTO;
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

    @CrossOrigin
    @RoleFilter(rolesAllowed = {"HEN", "ROOSTER"})
    @GetMapping
    public ResponseEntity<List<ReviewDTO>> getAllReviews(){
        List<ReviewDTO> reviews = rs.getAllReviews();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }
    @CrossOrigin
    @RoleFilter(rolesAllowed = {"CHICK", "HEN", "ROOSTER"})
    @GetMapping("/users/{userID}")
    public ResponseEntity<List<ReviewDTO>> getReviewByUserId(@PathVariable("userID") String id){
        List<ReviewDTO> reviews = rs.getReviewsByUserId(id);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @GetMapping("/{movieID}")
    public ResponseEntity<List<ReviewDTO>> getReviewsByMovieId(@PathVariable("movieID") String id) {
        List<ReviewDTO> reviews = rs.getReviewsByMovieId(id);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }
    @CrossOrigin
    @RoleFilter(rolesAllowed = {"CHICK", "HEN", "ROOSTER"}) // NEED TO ADD 'Role' field to header in postman from now on until we implement JWT
    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody CreateReviewDTO review){
        Review result = rs.createReview(review);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    @CrossOrigin
    @RoleFilter(rolesAllowed = {"HEN", "ROOSTER"}) // NEED TO ADD 'Role' field to header in postman from now on until we implement JWT
    @DeleteMapping("/{reviewID}")
    public ResponseEntity<Boolean> deleteReview(@PathVariable("reviewID") String id) {
        String success = rs.deleteReviewById(id);
        System.out.println(success);
        return new ResponseEntity<>(true, HttpStatus.I_AM_A_TEAPOT);
    }
}
