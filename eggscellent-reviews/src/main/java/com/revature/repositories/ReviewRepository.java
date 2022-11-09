package com.revature.repositories;

import com.revature.entities.Movie;
import com.revature.entities.Review;
import com.revature.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review,String> {

    Optional<List<Review>> findReviewsByMovieId(String id);

    List<Review> findByMovieId(Movie movie);

    List<Review> findByUserId(User user);
}
