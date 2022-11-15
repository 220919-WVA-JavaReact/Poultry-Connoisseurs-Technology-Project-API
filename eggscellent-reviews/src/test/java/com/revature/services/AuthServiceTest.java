package com.revature.services;

import com.revature.EggscellentReviewsApplication;
import com.revature.dtos.LoginDTO;
import com.revature.dtos.UserDTO;
import com.revature.entities.Role;
import com.revature.entities.User;
import com.revature.exceptions.LoginException;
import com.revature.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

//@SpringBootTest(classes = EggscellentReviewsApplication.class)
//public class AuthServiceTest {
//    @MockBean
//    private UserRepository mockRepository;
//
//    @Autowired
//    private AuthService sut;
//
//    @Test
//    public void authenticateUserValid(){
//        User returnedUser = new User();
//        returnedUser.setUserId("3");
//        returnedUser.setUsername("FoulFowl22");
//        returnedUser.setPassword("eggyboi24");
//        returnedUser.setRole(Role.CHICK);
//
//        UserDTO expected = new UserDTO();
//        expected.setId("3");
//        expected.setUsername("FoulFowl22");
//        expected.setRole(Role.CHICK);
//
//        LoginDTO login = new LoginDTO();
//        login.setUsername("FoulFowl22");
//        login.setPassword("eggyboi24");
//
//        Mockito.when(mockRepository.findUserByUsernameAndPassword("FoulFowl22", "eggyboi24")).thenReturn(Optional.of(returnedUser));
//
//        UserDTO actual = sut.authenticate(login);
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void authenticateUserInvalid(){
//        LoginDTO login = new LoginDTO();
//        login.setUsername("fakefowl");
//        login.setPassword("fakeegg");
//
//        Mockito.when(mockRepository.findUserByUsernameAndPassword("fakefowl", "fakeegg")).thenReturn(Optional.empty());
//
//        assertThrows(LoginException.class, () -> sut.authenticate(login));
//    }
//}
