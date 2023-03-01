package com.example.miniwebapp.Repository;

import com.example.miniwebapp.Models.Form.LogIn;
import com.example.miniwebapp.Models.Form.SignUp;

public interface UserInterface {
    Object signUpUser(SignUp signUp);
    Object signInUser(LogIn logIn);
}
