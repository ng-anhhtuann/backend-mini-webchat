package com.example.miniwebapp.Method;

import com.example.miniwebapp.Models.Form.SignUp;
import com.example.miniwebapp.Repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController("authentication")
@RequestMapping(value="/signup")
@ResponseStatus(HttpStatus.CREATED)
public class Authentication {
    @PostMapping
    public Object signUp(@RequestBody SignUp signUp){
        UserRepository userRepository = UserRepository.getUserRepository();
        return userRepository.signUpUser(signUp);
    }
}
