package com.example.loanservice_us1.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserRegistrationRequest {
    private String id;
    private String userName;
    private String email;
    private String password;

    @Override
    public String toString() {
        return "UserRegistrationRequest{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
