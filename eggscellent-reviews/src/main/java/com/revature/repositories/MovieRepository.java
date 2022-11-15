package com.revature.repositories;

import com.revature.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, String> {

    Optional<Movie> findMovieById(String id);

    List<Movie> findByIdIn(List<String> movieIdList);

}
