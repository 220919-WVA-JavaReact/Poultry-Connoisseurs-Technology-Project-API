package com.revature.controllers;

import com.revature.entities.Movie;
import com.revature.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public MovieController(MovieService ms){
        System.out.println("Movie Controller was instantiated");
        this.ms = ms;
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("movieId") String id) {
        Movie movie = ms.findByMovieId(id);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

}
