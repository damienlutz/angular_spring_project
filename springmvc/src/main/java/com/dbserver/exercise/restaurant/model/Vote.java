package com.dbserver.exercise.restaurant.model;

public class Vote {
    private Long userId;

    public Vote(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
