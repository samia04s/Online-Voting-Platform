package com.example.voting.controller;

import com.example.voting.model.Poll;
import com.example.voting.payload.PollRequest;
import com.example.voting.service.PollService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/polls")
@RequiredArgsConstructor
public class PollController {

    private final PollService pollService;

    @GetMapping
    public ResponseEntity<List<Poll>> getAllPolls() {
        return ResponseEntity.ok(pollService.getAllPolls());
    }

    @GetMapping("/{pollId}")
    public ResponseEntity<Poll> getPollById(@PathVariable Long pollId) {
        return ResponseEntity.ok(pollService.getPollById(pollId));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Poll> createPoll(@RequestBody PollRequest pollRequest) {
        Poll poll = pollService.createPoll(pollRequest);
        return ResponseEntity.ok(poll);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{pollId}")
    public ResponseEntity<Poll> updatePoll(@PathVariable Long pollId, @RequestBody PollRequest pollRequest) {
        Poll poll = pollService.updatePoll(pollId, pollRequest);
        return ResponseEntity.ok(poll);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{pollId}")
    public ResponseEntity<?> deletePoll(@PathVariable Long pollId) {
        pollService.deletePoll(pollId);
        return ResponseEntity.ok("Poll deleted successfully");
    }
}
