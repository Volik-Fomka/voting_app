package com.example.statisticservice.model;

public class VoteStatistics {
    private final long cats;
    private final long dogs;

    public VoteStatistics(long cats, long dogs) {
        this.cats = cats;
        this.dogs = dogs;
    }

    public long getCats() {
        return cats;
    }

    public long getDogs() {
        return dogs;
    }
}
