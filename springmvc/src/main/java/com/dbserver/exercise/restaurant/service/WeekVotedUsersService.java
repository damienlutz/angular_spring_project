package com.dbserver.exercise.restaurant.service;

import com.dbserver.exercise.restaurant.model.WeekVotedUser;
import com.dbserver.exercise.restaurant.util.WeekUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class WeekVotedUsersService {
    private List<WeekVotedUser> weekVotedUsers;
    public WeekVotedUsersService(){
        weekVotedUsers = new ArrayList<WeekVotedUser>();
    }

    private WeekVotedUser createWeek(Calendar week){

        List<Long> weekVotedUserIds = new ArrayList<Long>();

        return new WeekVotedUser(weekVotedUserIds, week);
    }

    public void registerUserVote(Long userId, Calendar week) {
        findWeek(week).addUserVote(userId);
    }

    public Boolean isAlreadyDayVotedByUser(Long userId, Calendar week) {
        return findWeek(week).getUserId().contains(userId);
    }

    public List<Long> getWeekVotedUsers(Calendar week) {
        return findWeek(week).getUserId();
    }


    private WeekVotedUser findWeek(Calendar calendar) {
        Optional<WeekVotedUser> week = findExistingWeek(calendar);

        if(week.isPresent()){
            return week.get();
        }
        WeekVotedUser newWeek = createWeek(calendar);
        weekVotedUsers.add(newWeek);
        return newWeek;
    }

    private Optional<WeekVotedUser> findExistingWeek(Calendar calendar) {
        for(WeekVotedUser week:weekVotedUsers) {
            if (WeekUtil.isEqualWeek(calendar, week.getWeek())){
                return Optional.of(week);
            }
        }
        return Optional.empty();
    }
}
