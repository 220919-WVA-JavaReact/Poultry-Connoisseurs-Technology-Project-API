package com.revature.services;

import com.revature.entities.Movie;
import com.revature.exceptions.MovieNotFoundException;
import com.revature.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieService {

    public MovieRepository mr;

    @Autowired
    public MovieService(MovieRepository mr) { this.mr = mr; }

    public Movie findByMovieId(String id) {
        Optional<Movie> foundMovie = mr.findMovieById(id);

        if(foundMovie.isPresent()){
            Movie movie = foundMovie.get();
            return movie;
        } else {
            throw new MovieNotFoundException();
        }
    }
}
