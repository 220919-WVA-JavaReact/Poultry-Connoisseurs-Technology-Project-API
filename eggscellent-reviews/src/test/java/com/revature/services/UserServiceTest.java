package com.revature.services;

import com.revature.EggscellentReviewsApplication;
import com.revature.dtos.UserDTO;
import com.revature.entities.Role;
import com.revature.entities.User;
import com.revature.exceptions.UserNotFoundException;
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
public class UserServiceTest {

    @MockBean
    private UserRepository mockRepository;

    @Autowired
    private UserService sut;

    @Test
    public void getUserByIdExists(){
        //A1
        User returnUser = new User();
        returnUser.setUserId("2");
        returnUser.setUsername("egglord");
        returnUser.setPassword("chicky");
        returnUser.setRole(Role.EGG);
        Mockito.when(mockRepository.findById("2")).thenReturn(Optional.of(returnUser));


        UserDTO expected = new UserDTO();
        expected.setId("2");
        expected.setUsername("egglord");
        expected.setRole(Role.EGG);

        //A2

        UserDTO actual = sut.getUserById("2");
        //A3

        assertEquals(expected, actual);
    }

    @Test
    public void getUserByIdDoesNotExist(){
        //A-1
        Mockito.when(mockRepository.findById("5000000")).thenReturn(Optional.empty());
        //A-3
        assertThrows(UserNotFoundException.class, () -> sut.getUserById("500000000"));
    }

    @Test
    public void getUserByUsernameExists(){
        // A-1
        User returnedUser = new User();
        returnedUser.setUserId("123456");
        returnedUser.setUsername("rooster-luvr69");
        returnedUser.setPassword("pass");
        returnedUser.setRole(Role.ROOSTER);
        Mockito.when(mockRepository.findUserByUsername("rooster-luvr69")).thenReturn(Optional.of(returnedUser));

        UserDTO expected = new UserDTO();
        expected.setId("123456");
        expected.setUsername("rooster-luvr69");
        expected.setRole(Role.ROOSTER);
        // A-2
        UserDTO actual = sut.getUserByUsername("rooster-luvr69");
        // A-3
        assertEquals(expected, actual);
    }

    @Test
    public void getUserByUsernameDoesNotExist(){
        Mockito.when(mockRepository.findUserByUsername("egg-sucker420")).thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class, () -> sut.getUserByUsername("egg-sucker420"));
    }

    @Test
    public void getAllUsers() {
        User testUser = new User();
        testUser.setUserId("5");
        List<User> returnedList = new ArrayList<>();
        returnedList.add(testUser);

        Mockito.when(mockRepository.findAll()).thenReturn(returnedList);

        UserDTO expectedUser = new UserDTO();
        expectedUser.setId("5");
        List<UserDTO> expected = new ArrayList<>();
        expected.add(expectedUser);

        List<UserDTO> actual = sut.getAllUsers();

        assertEquals(expected, actual);


    }

}
