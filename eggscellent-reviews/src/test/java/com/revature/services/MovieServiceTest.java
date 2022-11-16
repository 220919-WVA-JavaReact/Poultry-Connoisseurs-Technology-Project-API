package com.revature.services;

import com.revature.EggscellentReviewsApplication;
import com.revature.entities.Movie;
import com.revature.entities.User;
import com.revature.entities.UserMovie;
import com.revature.repositories.MovieRepository;
import com.revature.repositories.UserMovieRepository;
import com.revature.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = EggscellentReviewsApplication.class)
public class MovieServiceTest {

    @MockBean
    private MovieRepository mockMRepository;

    @MockBean
    private UserRepository mockURepository;

    @MockBean
    private UserMovieRepository mockUMRepository;

    @Autowired
    private MovieService sut;

    @Test
    public void findByMovieIdExists(){
    Movie returnedMovie = new Movie();
    returnedMovie.setId("25");
    returnedMovie.setRating(5f);
    returnedMovie.setTitle("title");
    returnedMovie.setRuntime(90);
    returnedMovie.setStars("5");
    Mockito.when(mockMRepository.findMovieById(returnedMovie.getId())).thenReturn(Optional.of(returnedMovie));

    Movie actual = sut.findByMovieId(returnedMovie.getId());

    assertEquals(returnedMovie, actual);

    }

    @Test
    public void toggleWatchedMovieByUserIdExists(){
        String id = "1";
        User ian = new User();
        ian.setUserId("1");
        Movie chicken = new Movie();
        chicken.setId("5");
        UserMovie returnedUM = new UserMovie();
        returnedUM.setUserId(ian);
        returnedUM.setMovieId(chicken);
        boolean expected = false;

        Mockito.when(mockURepository.findById("1")).thenReturn(Optional.of(ian));
        Mockito.when(mockUMRepository.findByUserIdAndMovieId(ian, chicken)).thenReturn(returnedUM);

        Boolean actual = sut.toggleWatchedMovieByUserId(id, chicken);

        assertEquals(expected, actual);
    }

}
