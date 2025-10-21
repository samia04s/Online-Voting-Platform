package com.example.voting.payload;

import lombok.Data;

@Data
public class VoteRequest {
    private Long pollId;
    private Long candidateId;
}
