package com.revature.services;

import com.revature.dtos.ReviewDTO;
import com.revature.entities.Movie;
import com.revature.entities.Review;
import com.revature.entities.User;
import com.revature.exceptions.ReviewNotFoundException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.repositories.MovieRepository;
import com.revature.repositories.ReviewRepository;
import com.revature.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    private ReviewRepository rr;
    private MovieRepository mr;

    private UserRepository ur;

    @Autowired
    public ReviewService(ReviewRepository rr, MovieRepository mr, UserRepository ur) {
        this.rr = rr;
        this.mr = mr;
        this.ur = ur;
    }

    public List<Review> getAllReviews(){
        List<Review> reviews = rr.findAll();
        return reviews;
    }

    public List<Review> getReviewsByUserId(String id){
        User u = ur.findById(id).orElseThrow(() -> new UserNotFoundException());
        List<Review> reviews = rr.findByUserId(u);

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
                ReviewDTO testDTO = new ReviewDTO();

                testDTO.setUserId(review.getUserId().getUserId());
                testDTO.setAuthorUsername(review.getUserId().getUsername());
                testDTO.setId(review.getId());
                testDTO.setTitle(review.getTitle());
                testDTO.setSummary(review.getSummary());

                parsedReviews.add(testDTO);
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

    public String deleteReviewById(String id) {
        rr.deleteById(id);
        return id;
    }

    public List<Review> getReviewsByUserId(String id){
        User u = ur.findById(id).orElseThrow(() -> new UserNotFoundException());
        List<Review> reviews = rr.findByUserId(u);

        return reviews;
    }

}
