package com.example.miniwebapp.Method;

import com.example.miniwebapp.Models.Form.LogIn;
import com.example.miniwebapp.Models.Form.SignUp;
import com.example.miniwebapp.Repository.Implementation.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController("authentication")
@RequestMapping(value="/auth")
@ResponseStatus(HttpStatus.CREATED)
public class Authentication {
    public static final UserRepository userRepository = UserRepository.getUserRepository();
    @PostMapping(value="signup")
    public Object signUp(@RequestBody SignUp signUp){
        return userRepository.signUpUser(signUp);
    }

    @PostMapping(value="login")
    public Object logIn(@RequestBody LogIn login){
        return userRepository.signInUser(login);
    }

    @GetMapping(value="get-all")
    public Object getAll(){
        return userRepository.getAllUser();
    }
}
