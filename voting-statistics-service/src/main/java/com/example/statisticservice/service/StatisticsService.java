package com.example.statisticservice.service;

import com.example.statisticservice.model.VoteStatistics;
import com.example.statisticservice.repository.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class StatisticsService {

    private final StatisticsRepository statisticsRepository;

    @Autowired
    public StatisticsService(StatisticsRepository statisticsRepository) {
        this.statisticsRepository = statisticsRepository;
    }

    @Cacheable("voteStatistics")
    public VoteStatistics getVoteStatistics() {
        return statisticsRepository.countVotes().orElse(new VoteStatistics(0, 0)); // Return default values if no data found
    }
}
