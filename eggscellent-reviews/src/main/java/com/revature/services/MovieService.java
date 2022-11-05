package com.revature.services;

import com.revature.entities.Movies;
import com.revature.exceptions.MovieNotFoundException;
import com.revature.exceptions.RegisterException;
import com.revature.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    public MovieRepository mr;

    @Autowired
    public MovieService(MovieRepository mr) { this.mr = mr; }

    public Movies getMovieById(int id) {
        Movies movie = mr.findById(id);
        if (movie == null) {
            throw new MovieNotFoundException();
        } else {
            return movie;
        }
    }
}
