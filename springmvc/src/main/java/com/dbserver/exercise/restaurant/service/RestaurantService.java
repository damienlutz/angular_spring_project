package com.dbserver.exercise.restaurant.service;


import com.dbserver.exercise.restaurant.exception.RestaurantException;
import com.dbserver.exercise.restaurant.model.Restaurant;
import com.dbserver.exercise.restaurant.model.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Component
public class RestaurantService {
    public static final String RESTAURANTE_JA_VOTADO_OU_INEXISTENTE = "Restaurante já votado, já escolhido na semana ou inexistente";

    private ArrayList<Restaurant> restaurants;
    private List<Vote> votes;

    private VotesService votesService;

    @Autowired
    private WeekChoosenService weekChoosenService;

    public RestaurantService(){
        votes = new ArrayList<Vote>();

        restaurants = new ArrayList<Restaurant>();
        restaurants.add(new Restaurant(1L,"Apple Bees"));
        restaurants.add(new Restaurant(2L,"OutBack"));
        restaurants.add(new Restaurant(3L,"Pampa Burguer"));

        votesService = new VotesService(restaurants);
    }

    public ArrayList<Restaurant> getRestaurants() {
        return restaurants;
    }
    public void voteRestaurant(Long restaurantId, Long userId, Calendar week){
        Vote vote = new Vote(restaurantId, userId);
        validateVote(vote, week);
        votes.add(vote);
        votesService.vote(restaurantId);
    }

    private void validateVote(Vote vote, Calendar week) {
        if(!isValidId(vote.getRestaurantId()) ||
                weekChoosenService.isAlreadyWeekChoosen(vote.getRestaurantId(), week) ||
                isAlreadyDayVotedByUser(vote.getUserId())){
            throw new RestaurantException(RESTAURANTE_JA_VOTADO_OU_INEXISTENTE);
        }
    }

    private Boolean isAlreadyDayVotedByUser(Long userId) {

        for(Vote v : votes){
            if(v.getUserId().equals(userId)){
                return true;
            }
        }
        return false;
    }

    private Boolean isValidId(Long restaurantId) {
        for(Restaurant restaurant : restaurants){
            if(restaurantId.equals(restaurant.getId())){
                return true;
            }
        }
        return false;
    }


    private Restaurant findRestaurantById(Long restaurantId) {
        for(Restaurant r : restaurants){
            if(restaurantId.equals(r.getId())){
                return  r;
            }
        }
        throw new RestaurantException("Inesperado:  Restaurante não encontrado");
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public VotesService getVotesService() {
        return votesService;
    }

    public void setWeekChoosenService(WeekChoosenService weekChoosenService) {
        this.weekChoosenService = weekChoosenService;
    }
}