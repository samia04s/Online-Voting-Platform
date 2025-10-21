package com.example.voting.controller;

import com.example.voting.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/analytics")
    public ResponseEntity<?> getSystemAnalytics() {
        return ResponseEntity.ok(adminService.getAnalytics());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/users")
    public ResponseEntity<?> listUsers() {
        return ResponseEntity.ok(adminService.listUsers());
    }

    // Add more admin-specific endpoints as needed
}
