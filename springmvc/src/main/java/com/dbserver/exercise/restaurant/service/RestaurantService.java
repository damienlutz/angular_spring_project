package com.dbserver.exercise.restaurant.service;


import com.dbserver.exercise.restaurant.exception.RestaurantException;
import com.dbserver.exercise.restaurant.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Component
public class RestaurantService {
    public static final String RESTAURANTE_JA_VOTADO_OU_INEXISTENTE = "Restaurante já votado, já escolhido na semana ou inexistente";


    private VotesSumService votesSumService;
    @Autowired
    private WeekVotedUsersService weekVotedUsersService;

    @Autowired
    private WeekChoosenService weekChoosenService;

    @Autowired
    private WeekRestaurantsService weekRestaurantsService;

    public ArrayList<Restaurant> getRestaurants(Calendar week) {
        return weekRestaurantsService.getWeekRestaurants(week);
    }
    public void voteRestaurant(Long restaurantId, Long userId, Calendar week){

        validateVote(userId, restaurantId, week);
        weekVotedUsersService.registerUserVote(userId, week);
        getVotesSumService(week).vote(restaurantId);
    }

    private void validateVote(Long vote, Long restaurantId, Calendar week) {
        if(!weekRestaurantsService.isValidId(restaurantId, week) ||
                weekChoosenService.isAlreadyWeekChoosen(restaurantId, week) ||
                weekVotedUsersService.isAlreadyDayVotedByUser(vote, week)){
            throw new RestaurantException(RESTAURANTE_JA_VOTADO_OU_INEXISTENTE);
        }
    }


    public List<Long> getWeekVotedUsers(Calendar week) {
        return weekVotedUsersService.getWeekVotedUsers(week);
    }

    public VotesSumService getVotesSumService(Calendar week) {
        if(votesSumService == null){
            votesSumService = new VotesSumService(weekRestaurantsService.getWeekRestaurants(week));
        }
        return votesSumService;
    }

    public void setWeekChoosenService(WeekChoosenService weekChoosenService) {
        this.weekChoosenService = weekChoosenService;
    }

    public void setWeekVotedUsersService(WeekVotedUsersService weekVotedUsersService) {
        this.weekVotedUsersService = weekVotedUsersService;
    }

    public void setWeekRestaurantsService(WeekRestaurantsService weekRestaurantsService) {
        this.weekRestaurantsService = weekRestaurantsService;
    }
}