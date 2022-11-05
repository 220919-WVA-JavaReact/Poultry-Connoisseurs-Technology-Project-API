package com.revature.repositories;

import com.revature.entities.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Reviews,String> {

    List<Reviews> findReviewsByMovieId(int id);


}
