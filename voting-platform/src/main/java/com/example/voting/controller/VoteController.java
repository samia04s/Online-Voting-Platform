package com.example.voting.controller;

import com.example.voting.payload.VoteRequest;
import com.example.voting.service.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/votes")
@RequiredArgsConstructor
public class VoteController {

    private final VoteService voteService;

    @PreAuthorize("hasRole('VOTER')")
    @PostMapping
    public ResponseEntity<?> castVote(@RequestBody VoteRequest voteRequest) {
        voteService.castVote(voteRequest);
        return ResponseEntity.ok("Vote cast successfully");
    }
}
