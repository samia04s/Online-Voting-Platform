package com.example.voting.service;

import com.example.voting.model.User;
import com.example.voting.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final UserRepository userRepository;

    public List<User> listUsers() {
        return userRepository.findAll();
    }

    public Object getAnalytics() {
        // Implement system analytics logic here
        return "Analytics data placeholder";
    }
}
