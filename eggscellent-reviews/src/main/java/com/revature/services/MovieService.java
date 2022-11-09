package com.revature.services;

import com.revature.entities.Movie;
import com.revature.exceptions.MovieNotFoundException;
import com.revature.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    public MovieRepository mr;

    @Autowired
    public MovieService(MovieRepository mr) { this.mr = mr; }

    public Movie getMovieById(int id) {
        Movie movie = mr.findById(id);
        if (movie == null) {
            throw new MovieNotFoundException();
        } else {
            return movie;
        }
    }
}
