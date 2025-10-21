package com.example.voting.util;

public class ValidationUtil {

    public static boolean isValidEmail(String email) {
        return email != null && email.matches("^\\S+@\\S+\\.\\S+$");
    }

    // Add more validation methods as needed
}
