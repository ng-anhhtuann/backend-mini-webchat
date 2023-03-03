package com.example.miniwebapp;

import com.example.miniwebapp.Config.Database;
import com.example.miniwebapp.Models.Form.LogIn;
import com.example.miniwebapp.Models.Response;
import com.example.miniwebapp.Models.Form.SignUp;
import com.example.miniwebapp.Repository.Implementation.UserRepository;
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
        SignUp signUp = new SignUp("john.doe", "John Doe", "", "johndoe15650@gmail.com");
        Response response = (Response) userRepository.signUpUser(signUp);
        Assertions.assertEquals("Fill all the cells",response.getMessage());
    }

    @Test
    public void testInsertSignUpExistedUser(){
        SignUp signUp = new SignUp("john.doe","asdfasdasd","asdr325sdf23r","johndoe15650@gmail.com");
        Response response = (Response) userRepository.signUpUser(signUp);
        Assertions.assertEquals("Username or Mail existed",response.getMessage());
    }

    @Test
    public void testLoginSuccess(){
        LogIn logIn = new LogIn("chienbinh156","vipproluxury");
        Response response = (Response) userRepository.signInUser(logIn);
        Assertions.assertEquals("Login successfully!",response.getMessage());
    }

    @Test
    public void testLoginFail(){
        LogIn logIn = new LogIn("chienbinh156","vipprolasduxury");
        Response response = (Response) userRepository.signInUser(logIn);
        Assertions.assertEquals("Wrong password!",response.getMessage());
    }
}

