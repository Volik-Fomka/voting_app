package com.example.statisticservice.repository;

import com.example.statisticservice.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticsRepository extends JpaRepository<Vote, Long> {
    @Query("SELECT COUNT(v) FROM Vote v WHERE v.selection = 'Cat'")
    long countCats();

    @Query("SELECT COUNT(v) FROM Vote v WHERE v.selection = 'Dog'")
    long countDogs();
}
