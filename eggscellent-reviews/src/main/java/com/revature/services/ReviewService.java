package com.revature.services;

import com.revature.dtos.CreateReviewDTO;
import com.revature.dtos.ReviewDTO;
import com.revature.entities.Movie;
import com.revature.entities.Review;
import com.revature.entities.User;
import com.revature.exceptions.MovieNotFoundException;
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
import java.util.stream.Collectors;

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

    public List<ReviewDTO> getAllReviews(){
        List<Review> reviews = rr.findAll();
        List<ReviewDTO> parsedReviews = reviews.stream().map(x -> new ReviewDTO(x)).collect(Collectors.toList());
        return parsedReviews;
    }

    public List<ReviewDTO> getReviewsByUserId(String id){
        User u = ur.findById(id).orElseThrow(() -> new UserNotFoundException());
        List<Review> reviews = rr.findByUserId(u);
        List<ReviewDTO> parsedReviews = reviews.stream().map(x -> new ReviewDTO(x)).collect(Collectors.toList());
        return parsedReviews;
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
                testDTO.setMovieId(movie.getId());

                parsedReviews.add(testDTO);
            }
            return parsedReviews;

        } else {
            throw new ReviewNotFoundException();
        }
    }

    public Review createReview(CreateReviewDTO review){
        Optional<Movie> foundMovie = mr.findMovieById(review.getMovieId());
        Optional<User> foundUser = ur.findUserByUserId(review.getUserId());

        if (foundMovie.isPresent() && foundUser.isPresent()){
            Movie movie = foundMovie.get();
            User user = foundUser.get();
            Review newReview = new Review(user, review.getTitle(), review.getSummary(), movie);

        rr.save(newReview);
        return newReview;} else{
            throw new MovieNotFoundException();
        }
    }

    public String deleteReviewById(String id) {
        rr.deleteById(id);
        return id;
    }


}
