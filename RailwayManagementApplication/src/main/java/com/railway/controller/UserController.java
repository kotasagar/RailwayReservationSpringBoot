package com.railway.controller;

import com.railway.model.User;
import com.railway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class UserController {
    @Autowired
    private UserService userService;
    
    
    
    //seat availability

//    @PostMapping("/register")
 //   public ResponseEntity<User> register(@RequestBody User user) {
 //       return ResponseEntity.ok(userService.register(user));
 //   }

    // Additional methods for login and seat booking can be added here.
}
