package com.example.demouserstory1.service;

import com.example.demouserstory1.dto.UserRegistrationRequest;
import com.example.demouserstory1.entity.UserEntity;
import com.example.demouserstory1.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserService {
    @Autowired
        private UserRepository userRepository;

        public void registerUser(UserRegistrationRequest userRegistrationRequest) {
            //validate the user
            if (userRegistrationRequest.getPassword().length() < 6) {
                throw new IllegalArgumentException("password must be at least 6 characters");
            }
            //CHECK IF THE EMAIL ALREADY USED
            if (userRepository.findByEmail(userRegistrationRequest.getEmail()) != null) {
                throw new IllegalArgumentException("Email already in use");
            }

            //create a new user entity

            UserEntity userEntity=new UserEntity();
            userEntity.setUserName(userRegistrationRequest.getUserName());
            userEntity.setEmail(userRegistrationRequest.getEmail());
            userEntity.setPassword(userRegistrationRequest.getPassword());
             userRepository.save(userEntity);
        }



    }
