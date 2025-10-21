package com.example.voting.service;

import com.example.voting.model.Candidate;
import com.example.voting.model.Poll;
import com.example.voting.payload.PollRequest;
import com.example.voting.repository.CandidateRepository;
import com.example.voting.repository.PollRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PollService {

    private final PollRepository pollRepository;
    private final CandidateRepository candidateRepository;

    public Poll createPoll(PollRequest pollRequest) {
        Poll poll = Poll.builder()
                .title(pollRequest.getTitle())
                .description(pollRequest.getDescription())
                .startTime(pollRequest.getStartTime())
                .endTime(pollRequest.getEndTime())
                .build();

        final Poll savedPoll = pollRepository.save(poll);

        List<Candidate> candidates = pollRequest.getCandidateNames()
                .stream()
                .map(name -> Candidate.builder().name(name).poll(savedPoll).build())
                .collect(Collectors.toList());


        candidateRepository.saveAll(candidates);

        poll.setCandidates(candidates);
        return poll;
    }

    public List<Poll> getAllPolls() {
        return pollRepository.findAll();
    }

    public Poll getPollById(Long pollId) {
        return pollRepository.findById(pollId)
                .orElseThrow(() -> new RuntimeException("Poll not found"));
    }

    public Poll updatePoll(Long pollId, PollRequest pollRequest) {
        Poll poll = getPollById(pollId);
        poll.setTitle(pollRequest.getTitle());
        poll.setDescription(pollRequest.getDescription());
        poll.setStartTime(pollRequest.getStartTime());
        poll.setEndTime(pollRequest.getEndTime());

        candidateRepository.deleteAll(poll.getCandidates());

        List<Candidate> updatedCandidates = pollRequest.getCandidateNames()
                .stream()
                .map(name -> Candidate.builder().name(name).poll(poll).build())
                .collect(Collectors.toList());

        candidateRepository.saveAll(updatedCandidates);

        poll.setCandidates(updatedCandidates);
        return pollRepository.save(poll);
    }

    public void deletePoll(Long pollId) {
        Poll poll = getPollById(pollId);
        pollRepository.delete(poll);
    }
}
