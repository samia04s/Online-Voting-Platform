package com.example.voting.payload;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class PollRequest {
    private String title;
    private String description;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private List<String> candidateNames;  // Candidate names in the poll
}
