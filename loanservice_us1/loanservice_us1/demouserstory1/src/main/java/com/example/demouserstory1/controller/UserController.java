package com.example.demouserstory1.controller;

import com.example.demouserstory1.dto.UserRegistrationRequest;
import com.example.demouserstory1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
        private UserService userService;
        @Autowired
        public UserController(UserService userService){
            this.userService=userService;
        }
        @PostMapping("/register")
        public ResponseEntity<?> register(@RequestBody UserRegistrationRequest registrationRequest)
        {
            try {
                userService.registerUser(registrationRequest);
                return new ResponseEntity<>(HttpStatus.CREATED);
            }catch (Exception e)
            {
                return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
            }
        }

    }
