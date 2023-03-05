package com.example.miniwebapp.Repository.Manager;

import com.example.miniwebapp.Models.Form.LogIn;
import com.example.miniwebapp.Models.Form.SignUp;
import com.example.miniwebapp.Models.User;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface IUser {
    Object signUpUser(SignUp signUp);
    Object signInUser(LogIn logIn);
}
