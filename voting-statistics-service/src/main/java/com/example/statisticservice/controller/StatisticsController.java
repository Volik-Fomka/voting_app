package com.example.statisticservice.controller;

import com.example.statisticservice.model.VoteStatistics;
import com.example.statisticservice.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatisticsController {

    private final StatisticsService statisticsService;

    @Autowired
    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping("/statistics")
    public VoteStatistics getStatistics() {
        return statisticsService.getVoteStatistics();
    }
}
