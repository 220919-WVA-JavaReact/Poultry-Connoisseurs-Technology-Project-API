package com.revature.services;

import com.revature.EggscellentReviewsApplication;
import com.revature.EggscellentReviewsApplicationTests;
import com.revature.dtos.UserDTO;
import com.revature.entities.Role;
import com.revature.entities.User;
import com.revature.exceptions.UserNotFoundException;
import com.revature.repositories.UserRepository;
import com.revature.services.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
@SpringBootTest(classes = EggscellentReviewsApplicationTests.class )
public class UserServiceTest {

    @MockBean
    private UserRepository mockRepository;

    @Autowired
    private UserService sut;

    @Test
    public void getUserByIdExists(){
        //A1
        User returnUser = new User();
        returnUser.setId(2);
        returnUser.setUsername("egglord");
        returnUser.setPassword("chicky");
        returnUser.setRole(Role.EGG);
        Mockito.when(mockRepository.findById("2")).thenReturn(Optional.of(returnUser));


        UserDTO expected = new UserDTO();
        expected.setId(2);
        expected.setUsername("egglord");
        expected.setRole(Role.EGG);

        //A2

        UserDTO actual = sut.getUserById("1");
        //Assert

        assertEquals(expected, actual);
    }

    @Test
    public void getUserByIdDoesNotExist(){
        //A-1
        Mockito.when(mockRepository.findById("5000000")).thenReturn(Optional.empty());
        //A-3
        assertThrows(UserNotFoundException.class, () -> sut.getUserById("500000000"));
    }

//    @Test
//    public void getUserByUsernameExists(){
//        // A-1
//        User returnedUser = new User();
//        returnedUser.setId(1);
//        returnedUser.setUsername("rooster-luvr69");
//        returnedUser.setPassword("eggy");
//        returnedUser.setRole(Role.ROOSTER);
//        Mockito.when(mockRepository.findUserByUsername("rosster-luvr69")).thenReturn(Optional.ofNullable(returnedUser));
//
//        UserDTO expected = new UserDTO();
//        expected.setId(1);
//        expected.setUsername("rooster-luvr69");
//        expected.setRole(Role.ROOSTER);
//
//        UserDTO actual = sut.getUserByUsername()
//
//    }
}
