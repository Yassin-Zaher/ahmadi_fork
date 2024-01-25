package com.codewitharjun.fullstackbackend.controller;

import com.codewitharjun.fullstackbackend.model.AuthResponse;
import com.codewitharjun.fullstackbackend.model.LoginAuth;
import com.codewitharjun.fullstackbackend.model.RegisterAuth;
import com.codewitharjun.fullstackbackend.model.UserEntity;
import com.codewitharjun.fullstackbackend.repository.UserRepository;
import com.codewitharjun.fullstackbackend.security.TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
//@CrossOrigin("http://localhost:3000")
public class AuhentificationController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenGenerator tokenGenerator;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping("register")
    public String signupUSer(@RequestBody RegisterAuth registerAuth) {
        UserEntity username = userRepository.findByUsername(registerAuth.getEmail()).orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        if (username == null) {
            UserEntity user = new UserEntity();
            user.setName(registerAuth.getName());
            user.setEmail(registerAuth.getEmail());
            user.setUsername(registerAuth.getUsername());
            String encodedPassword = passwordEncoder.encode(registerAuth.getPassword());
            user.setPassword(encodedPassword);
            userRepository.save(user);
            return "welcome "+ registerAuth.getName();

        } else {
            return "user already taken ";
        }
    }
    @PostMapping("login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginAuth loginAuth){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginAuth.getUsername(),
                        loginAuth.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = tokenGenerator.generateToken(authentication);
        return new ResponseEntity<>(new AuthResponse(token), HttpStatus.OK);
    }
}





