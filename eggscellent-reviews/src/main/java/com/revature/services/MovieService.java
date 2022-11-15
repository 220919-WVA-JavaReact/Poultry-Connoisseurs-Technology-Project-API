package com.revature.services;

import com.revature.entities.Movie;
import com.revature.entities.User;
import com.revature.entities.UserMovie;
import com.revature.exceptions.MovieNotFoundException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.repositories.MovieRepository;
import com.revature.repositories.UserMovieRepository;
import com.revature.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieService {

    public MovieRepository mr;
    public UserRepository ur;
    public UserMovieRepository umr;

    @Autowired
    public MovieService(MovieRepository mr, UserRepository ur, UserMovieRepository umr) { this.mr = mr;this.ur = ur;this.umr = umr; }

    public Movie findByMovieId(String id) {
        Optional<Movie> foundMovie = mr.findMovieById(id);

        if(foundMovie.isPresent()){
            Movie movie = foundMovie.get();
            return movie;
        } else {
            throw new MovieNotFoundException();
        }
    }

    public List<Movie> getAllMovies() {
        List<Movie> movies = mr.findAll();

        if (movies == null) {
            throw new MovieNotFoundException();
        } else {
            return movies;
        }
    }

    public List <Movie> getWatchedMoviesByUserId(String userId) {
        User user = ur.findById(userId).orElseThrow(()-> new UserNotFoundException());

        List<UserMovie> userMovies = umr.findByUserId(user);

        if(userMovies == null){
            throw new MovieNotFoundException();
        } else{
            List<String> movieIds = userMovies.stream().map(x -> x.getMovieId().getId()).collect(Collectors.toList());
            List<Movie> foundMovies = mr.findByIdIn(movieIds);

            return foundMovies;
        }

    }


    public boolean toggleWatchedMovieByUserId(String id, Movie movie) {
        User user = ur.findById(id).orElseThrow(()-> new UserNotFoundException());
        UserMovie result = umr.findByUserIdAndMovieId(user, movie);

        if(result == null) {
            UserMovie watchedMovie = new UserMovie();
            watchedMovie.setUserId(user);
            watchedMovie.setMovieId(movie);
            umr.save(watchedMovie);
            return true;
        } else {
            umr.delete(result);
        }
        return false;
    }
}
