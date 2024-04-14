package com.example.statisticservice.repository;

import com.example.statisticservice.model.Vote;
import com.example.statisticservice.model.VoteStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface StatisticsRepository extends JpaRepository<Vote, Long> {
    @Query("SELECT new com.example.statisticservice.model.VoteStatistics(SUM(CASE WHEN v.selection = 'Cat' THEN 1 ELSE 0 END), SUM(CASE WHEN v.selection = 'Dog' THEN 1 ELSE 0 END)) FROM Vote v")
    Optional<VoteStatistics> countVotes(); 
}