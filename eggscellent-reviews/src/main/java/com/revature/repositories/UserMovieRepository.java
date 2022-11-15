package com.revature.repositories;

import com.revature.entities.Movie;
import com.revature.entities.User;
import com.revature.entities.UserMovie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserMovieRepository extends JpaRepository<UserMovie, Long> {

    //method to get list of watched/favorites - need user id, returns list of usermovies
    // ( will route into movie repository to get list of movies)
    List<UserMovie> findByUserId(User user);



    Optional<UserMovie> findByMovieId(Movie movie);


}
