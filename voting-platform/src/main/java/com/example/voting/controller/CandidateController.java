package com.example.voting.controller;

import com.example.voting.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/candidates")
@RequiredArgsConstructor
public class CandidateController {

    private final CandidateService candidateService;

    @PreAuthorize("hasRole('CANDIDATE')")
    @GetMapping("/results")
    public ResponseEntity<?> getCandidateResults() {
        return ResponseEntity.ok(candidateService.getCandidateResults());
    }

    // Additional candidate endpoints as needed
}
