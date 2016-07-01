package com.dbserver.exercise.restaurant.model;

import java.util.Calendar;
import java.util.List;

public class WeekVotedUser {
    private Calendar week;
    private List<Long> userId;

    public WeekVotedUser( List<Long> userId, Calendar week) {
        this.week = week;
        this.userId = userId;
    }

    public Calendar getWeek() {
        return week;
    }

    public void setWeek(Calendar week) {
        this.week = week;
    }

    public List<Long> getUserId() {
        return userId;
    }

    public void setUserId(List<Long> userId) {
        this.userId = userId;
    }

    public void addUserVote(Long userId) {
        this.userId.add(userId);
    }
}
