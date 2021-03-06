package com.dbserver.exercise.restaurant.service;

import com.dbserver.exercise.restaurant.exception.RestaurantException;
import com.dbserver.exercise.restaurant.model.Restaurant;
import com.dbserver.exercise.restaurant.model.VoteSum;
import com.dbserver.exercise.restaurant.model.WeekRestaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VotesSumService {


    private List<VoteSum> voteSum;

    public VotesSumService(List<Restaurant> restaurants) {
        reset(restaurants);
    }

    public void reset(List<Restaurant> restaurants) {
        voteSum = new ArrayList<VoteSum>();
        for(Restaurant r : restaurants){
            voteSum.add(new VoteSum(r.getId(),0));
        }
    }

    public Long getChoosenRestaurantId() {

        Optional<Long> maxId = Optional.empty();
        Integer maxVotes = 0;
        for (VoteSum v : voteSum){
            if(maxVotes < v.getTotal()){
                maxVotes = v.getTotal();
                maxId = Optional.of(v.getRestaurantId());
            }
        }
        if(!maxId.isPresent()){
            throw  new RestaurantException("Não foi encontrado restaurante mais votado.");
        }
        return maxId.get();
    }

    public void vote(Long restaurantId) {
        VoteSum voteSum = findVoteSum(restaurantId);
        voteSum.setTotal(voteSum.getTotal() + 1);
    }

    private VoteSum findVoteSum(Long restaurantId) {
        for(VoteSum v:voteSum){
            if(restaurantId.equals(v.getRestaurantId())){
                return v;
            }
        }
        throw  new RestaurantException("Inesperado: Não foi encontrado vote para o restaurante");
    }

}
