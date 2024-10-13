package com.railway.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import org.springframework.web.bind.annotation.*;

import com.railway.model.User;
import com.railway.service.UserService;

@RestController
@RequestMapping()
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        userService.register(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
    	try {
    		Authentication authentication = authenticationManager
    				.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
    		if(authentication.isAuthenticated()) {
    			return "Loggedin";
    		}
    		else {
    			return "Login Failed";
    		}
    		}
    		catch(Exception e) {
    			return "Login Failed";
    		}
    }
}
