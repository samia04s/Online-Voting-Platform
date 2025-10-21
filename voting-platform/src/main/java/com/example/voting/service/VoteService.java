package com.example.voting.service;

import com.example.voting.model.Candidate;
import com.example.voting.model.Poll;
import com.example.voting.model.User;
import com.example.voting.model.Vote;
import com.example.voting.payload.VoteRequest;
import com.example.voting.repository.CandidateRepository;
import com.example.voting.repository.PollRepository;
import com.example.voting.repository.UserRepository;
import com.example.voting.repository.VoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class VoteService {

    private final VoteRepository voteRepository;
    private final PollRepository pollRepository;
    private final CandidateRepository candidateRepository;
    private final UserRepository userRepository;

    public void castVote(VoteRequest voteRequest) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User voter = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Poll poll = pollRepository.findById(voteRequest.getPollId())
                .orElseThrow(() -> new RuntimeException("Poll not found"));

        if (voteRepository.findByPollIdAndVoterId(poll.getId(), voter.getId()).isPresent()) {
            throw new RuntimeException("User has already voted in this poll");
        }

        Candidate candidate = candidateRepository.findById(voteRequest.getCandidateId())
                .orElseThrow(() -> new RuntimeException("Candidate not found"));

        if (!candidate.getPoll().getId().equals(poll.getId())) {
            throw new RuntimeException("Candidate does not belong to the poll");
        }

        Vote vote = Vote.builder()
                .poll(poll)
                .candidate(candidate)
                .voter(voter)
                .voteTime(LocalDateTime.now())
                .build();

        voteRepository.save(vote);
    }
}
