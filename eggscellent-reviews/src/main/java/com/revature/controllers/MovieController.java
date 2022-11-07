package com.revature.controllers;

import com.revature.entities.Movie;
import com.revature.services.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private MovieService ms;

    @GetMapping("/{movieId}")
    public ResponseEntity<Movie> getById(@PathVariable("id") int id) {
        Movie movie = ms.getMovieById(id);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

}
