package com.example.loanservice_us1.service;

import com.example.loanservice_us1.dto.LoanRecordDTO;
import com.example.loanservice_us1.dto.UserRegistrationRequest;
import com.example.loanservice_us1.entity.LoanEntity;
import com.example.loanservice_us1.entity.UserEntity;
import com.example.loanservice_us1.repository.LoanRepository;
import com.example.loanservice_us1.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

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

        UserEntity user = new UserEntity();
        user.setUserName(userRegistrationRequest.getUserName());
        user.setEmail(userRegistrationRequest.getEmail());
        user.setPassword(userRegistrationRequest.getPassword());
        userRepository.save(user);
    }
    public List<LoanEntity> {
        // Implement logic to retrieve current loans for the user
        return

    }

    public boolean hasExceededLoanLimit(UserRegistrationRequest userRegistrationRequest) {
        List<LoanEntity> currentLoans = getCurrentLoansForUser(user);
        int maxLoanLimit = user.getMaxLoanLimit();

        return currentLoans.size() >= maxLoanLimit;
    }

      }







