package com.dbserver.exercise.restaurant.service;

import com.dbserver.exercise.restaurant.exception.RestaurantException;
import com.dbserver.exercise.restaurant.model.Restaurant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;

@Service
public class WeekRestaurantsService {
    private ArrayList<Restaurant> restaurants;
    public WeekRestaurantsService() {
    }
    public ArrayList<Restaurant> getWeekRestaurants(Calendar week) {
        restaurants = new ArrayList<Restaurant>();
        restaurants.add(new Restaurant(1L,"Apple Bees"));
        restaurants.add(new Restaurant(2L,"OutBack"));
        restaurants.add(new Restaurant(3L,"Pampa Burguer"));
        return restaurants;
    }

    public Boolean isValidId(Long restaurantId, Calendar week) {
        for(Restaurant restaurant : getWeekRestaurants(week)){
            if(restaurantId.equals(restaurant.getId())){
                return true;
            }
        }
        return false;
    }


    private Restaurant findRestaurantById(Long restaurantId, Calendar week) {
        for(Restaurant r : getWeekRestaurants(week)){
            if(restaurantId.equals(r.getId())){
                return  r;
            }
        }
        throw new RestaurantException("Inesperado:  Restaurante não encontrado");
    }
}
