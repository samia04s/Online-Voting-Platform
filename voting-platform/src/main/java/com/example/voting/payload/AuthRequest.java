package com.example.voting.payload;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
    private String email;  // required for registration, optional for login
}
