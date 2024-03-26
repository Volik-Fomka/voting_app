package com.example.votingservice.controller;

import com.example.votingservice.model.Vote;
import com.example.votingservice.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VoteController {

    @Autowired
    private VoteRepository voteRepository;

    // Ensure this matches the KafkaTemplate bean defined in KafkaProducerConfig
    @Autowired
    private KafkaTemplate<String, Vote> kafkaTemplate;

    @PostMapping("/vote")
    public Vote castVote(@RequestBody Vote vote) {
        Vote savedVote = voteRepository.save(vote);
        kafkaTemplate.send("votes", savedVote);
        return savedVote;
    }
}
