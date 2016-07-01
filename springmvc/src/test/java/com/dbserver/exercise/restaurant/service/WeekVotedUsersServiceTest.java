package com.dbserver.exercise.restaurant.service;

import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;

public class WeekVotedUsersServiceTest {

    @Test
    public void testIsAlreadyDayVotedByUser() throws Exception {
        WeekVotedUsersService weekVotedUsersService  = new WeekVotedUsersService();
        weekVotedUsersService.registerUserVote(1L, Calendar.getInstance());
        Assert.assertTrue(weekVotedUsersService.isAlreadyDayVotedByUser(1L, Calendar.getInstance()));
    }
    @Test
    public void testIsNotAlreadyDayVotedByUser() throws Exception {
        WeekVotedUsersService weekVotedUsersService  = new WeekVotedUsersService();
        weekVotedUsersService.registerUserVote(2L, Calendar.getInstance());
        Assert.assertFalse(weekVotedUsersService.isAlreadyDayVotedByUser(1L, Calendar.getInstance()));
    }
    @Test
    public void testIsNotAlreadyDayVotedByUserOtherWeek() throws Exception {
        WeekVotedUsersService weekVotedUsersService  = new WeekVotedUsersService();
        Calendar semanaAnterior = Calendar.getInstance();
        semanaAnterior.add(Calendar.DATE, -7);
        weekVotedUsersService.registerUserVote(1L, semanaAnterior);
        Assert.assertFalse(weekVotedUsersService.isAlreadyDayVotedByUser(1L, Calendar.getInstance()));
    }

}