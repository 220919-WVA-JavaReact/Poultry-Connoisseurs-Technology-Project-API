package com.revature.services;

import com.revature.dtos.ReviewDTO;
import com.revature.entities.Movie;
import com.revature.entities.Review;
import com.revature.exceptions.ReviewNotFoundException;
import com.revature.repositories.MovieRepository;
import com.revature.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    private ReviewRepository rr;
    private MovieRepository mr;

    @Autowired
    public ReviewService(ReviewRepository rr, MovieRepository mr) {
        this.rr = rr;
        this.mr = mr;
    }

    public List<Review> getAllReviews(){
        List<Review> reviews = rr.findAll();
        return reviews;
    }
    public List<ReviewDTO> getReviewsByMovieId(String id) {
        Optional<Movie> foundMovie = mr.findMovieById(id);

        if (foundMovie.isPresent()){
            Movie movie = foundMovie.get();

            List<Review> foundReviews = rr.findByMovieId(movie);
 //           List<ReviewDTO> parsedReviews = foundReviews.stream().map(x -> new ReviewDTO(x)).collect(Collectors.toList());
            List<ReviewDTO> parsedReviews = new ArrayList<>();
            for(Review review: foundReviews){
               parsedReviews.add(new ReviewDTO(review));
            }
            return parsedReviews;

        } else {
            throw new ReviewNotFoundException();
        }
    }

    public Review createReview(Review review){
        rr.save(review);
        return review;
    }

}
