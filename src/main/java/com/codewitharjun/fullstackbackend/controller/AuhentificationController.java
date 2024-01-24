package com.codewitharjun.fullstackbackend.controller;

import com.codewitharjun.fullstackbackend.model.User;
import com.codewitharjun.fullstackbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
public class SignupController {
    @Autowired
    private UserRepository userRepository;
    @RequestMapping("/Signup")
    public String signupUSer(User user) {
        User username = userRepository.findByUsername(user.getUsername());
        if (username != null) {
            return "user already taken ";
        } else {
            userRepository.save(user);
            return "welcome "+user.getName();
        }
    }

}
