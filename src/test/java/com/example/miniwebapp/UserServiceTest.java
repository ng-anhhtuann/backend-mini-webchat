package com.example.miniwebapp;

import com.example.miniwebapp.Config.Database;
import com.example.miniwebapp.Models.Response;
import com.example.miniwebapp.Models.Form.SignUp;
import com.example.miniwebapp.Repository.UserRepository;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class userRepositoryTest {

    @InjectMocks
    UserRepository userRepository = UserRepository.getUserRepository();

    @BeforeAll
    public static void setUp() {
        Database.getDatabase();
    }

    @Test
    public void testInsertSignUpUser() {
        // Create a new user object with valid data
        SignUp signUp = new SignUp("john.doe", "John Doe", "", "johndoe15650@gmail.com");

        // Call the signUpUser method and check the response
        Response response = (Response) userRepository.signUpUser(signUp);
        Assertions.assertEquals("Fill all the cells",response.getMessage());
    }
    @Test
    public void testInsertSignUpExistedUser(){
        SignUp signUp = new SignUp("john.doe","asdfasdasd","asdr325sdf23r","johndoe15650@gmail.com");
        
        Response response = (Response) userRepository.signUpUser(signUp);
        Assertions.assertEquals("Username or Mail existed",response.getMessage());
    }
}

