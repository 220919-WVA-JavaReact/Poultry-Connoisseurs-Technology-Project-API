package com.revature.services;

import com.revature.EggscellentReviewsApplication;
import com.revature.dtos.ReviewDTO;
import com.revature.entities.Movie;
import com.revature.entities.Review;
import com.revature.entities.User;
import com.revature.exceptions.ReviewNotFoundException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.repositories.MovieRepository;
import com.revature.repositories.ReviewRepository;
import com.revature.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
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
public class ReviewServiceTest {

    @MockBean
    private ReviewRepository mockReviewRepository;

    @MockBean
    private MovieRepository mockMovieRepository;

    @MockBean
    private UserRepository mockUserRepository;

    @Autowired
    public ReviewService sut;

    @Test
    public void getReviewsByUserIdExists(){
        //Arrange
        User ian = new User();
        Movie chicken = new Movie();
        ian.setUserId("5");
        ian.setUsername("ianbnel");
        chicken.setId("2");

        Review review1 = new Review();
        review1.setId("1");
        review1.setUserId(ian);
        review1.setSummary("Summary");
        review1.setTitle("title");
        review1.setMovieId(chicken);
        List<Review> returned = new ArrayList<>();
        returned.add(review1);

        Mockito.when(mockUserRepository.findById(ian.getUserId())).thenReturn(Optional.of(ian));
        Mockito.when(mockReviewRepository.findByUserId(ian)).thenReturn(returned);

        ReviewDTO expectedDTO = new ReviewDTO();
        expectedDTO.setId("1");
        expectedDTO.setUserId("5");
        expectedDTO.setAuthorUsername("ianbnel");
        expectedDTO.setTitle("title");
        expectedDTO.setSummary("Summary");
        expectedDTO.setMovieId("2");

        List<ReviewDTO> expected = new ArrayList<>();
        expected.add(expectedDTO);

        List<ReviewDTO> actual = sut.getReviewsByUserId(ian.getUserId());

        assertEquals(expected, actual);
    }

    @Test
    public void getReviewsByUserIdDoesNotExist(){
        Mockito.when(mockUserRepository.findById("3000")).thenReturn(Optional.empty());
        assertThrows(UserNotFoundException.class, () -> sut.getReviewsByUserId("3000"));
    }

    @Test
    public void getReviewsByMovieIdExists(){
        Movie chicken = new Movie();
        User ian = new User();
        ian.setUsername("ianbnel");
        ian.setUserId("3");
        chicken.setId("1");
        Review sampleReview = new Review();
        sampleReview.setId("2");
        sampleReview.setUserId(ian);
        sampleReview.setTitle("title");
        sampleReview.setSummary("summary");
        sampleReview.setMovieId(chicken);
        List<Review> returned = new ArrayList<>();
        returned.add(sampleReview);

        ReviewDTO expectedDTO = new ReviewDTO();
        expectedDTO.setId("2");
        expectedDTO.setTitle("title");
        expectedDTO.setSummary("summary");
        expectedDTO.setAuthorUsername("ianbnel");
        expectedDTO.setUserId(ian.getUserId());
        expectedDTO.setAuthorUsername(ian.getUsername());
        List<ReviewDTO> expected = new ArrayList<>();
        expected.add(expectedDTO);


        Mockito.when(mockMovieRepository.findMovieById(chicken.getId())).thenReturn(Optional.of(chicken));
        Mockito.when(mockReviewRepository.findByMovieId(chicken)).thenReturn(returned);

        List<ReviewDTO> actual = sut.getReviewsByMovieId(chicken.getId());

        assertEquals(expected, actual);
    }

    @Test
    public void getReviewsByMovieIdDoesNotExist() {
        Mockito.when(mockMovieRepository.findMovieById("4000")).thenReturn(Optional.empty());
        assertThrows(ReviewNotFoundException.class, () -> sut.getReviewsByMovieId("4000"));
    }

}
