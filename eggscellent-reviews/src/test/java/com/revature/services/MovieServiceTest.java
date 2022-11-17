package com.revature.services;

import com.revature.EggscellentReviewsApplication;
import com.revature.entities.Movie;
import com.revature.entities.User;
import com.revature.entities.UserMovie;
import com.revature.exceptions.MovieNotFoundException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.repositories.MovieRepository;
import com.revature.repositories.UserMovieRepository;
import com.revature.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    public void findByMovieIdDoesNotExist(){
        Mockito.when(mockMRepository.findMovieById("3000")).thenReturn(Optional.empty());
        assertThrows(MovieNotFoundException.class, () -> sut.findByMovieId("3000"));
    }

    @Test
    public void findAllMoviesExist() {
        Movie testMovie = new Movie();
        testMovie.setId("7");
        List<Movie> returnList = new ArrayList<>();
        returnList.add(testMovie);

        Mockito.when(mockMRepository.findAll()).thenReturn(returnList);

        Movie expectedMovie = new Movie();
        expectedMovie.setId("7");
        List<Movie> expected = new ArrayList<>();
        expected.add(expectedMovie);

        List<Movie> actual = sut.getAllMovies();

        assertEquals(expected, actual);
    }

    @Test
    public void toggleWatchedMovieByUserIdAdd(){
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

    @Test
    public void toggleWatchedMovieByUserIdRemove(){
        String id = "1";
        User ian = new User();
        ian.setUserId("1");
        Movie chicken = new Movie();
        chicken.setId("5");

        boolean expected = true;

        Mockito.when(mockURepository.findById("1")).thenReturn(Optional.of(ian));
        Mockito.when(mockUMRepository.findByUserIdAndMovieId(ian, chicken)).thenReturn(null);

        Boolean actual = sut.toggleWatchedMovieByUserId(id, chicken);

        assertEquals(expected, actual);
    }

    @Test
    public void toggleWatchedMovieByUserIdDoesNotExist(){
        Mockito.when(mockURepository.findById("5038f")).thenReturn(Optional.empty());
        Movie testMovie = new Movie();

        assertThrows(UserNotFoundException.class, () -> sut.toggleWatchedMovieByUserId("5083f", testMovie));
    }

}
