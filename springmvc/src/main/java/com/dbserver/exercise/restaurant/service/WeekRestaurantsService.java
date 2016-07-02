package com.dbserver.exercise.restaurant.service;

import com.dbserver.exercise.restaurant.exception.RestaurantException;
import com.dbserver.exercise.restaurant.model.Restaurant;
import com.dbserver.exercise.restaurant.model.WeekRestaurant;
import com.dbserver.exercise.restaurant.util.WeekUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class WeekRestaurantsService {

    private List<WeekRestaurant> weekRestaurants;
    public WeekRestaurantsService() {
        weekRestaurants = new ArrayList<WeekRestaurant>();
    }
    public Boolean isValidId(Long restaurantId, Calendar week) {
        for(Restaurant restaurant : findWeek(week).getRestaurants()){
            if(restaurantId.equals(restaurant.getId())){
                return true;
            }
        }
        return false;
    }


    private WeekRestaurant createWeek(Calendar calendar) {
        List<Restaurant> weekChoosenRestaurants = new ArrayList<Restaurant>();
        weekChoosenRestaurants.add(new Restaurant(1L,"Apple Bees"));
        weekChoosenRestaurants.add(new Restaurant(2L,"OutBack"));
        weekChoosenRestaurants.add(new Restaurant(3L,"Pampa Burguer"));

        return new WeekRestaurant(weekChoosenRestaurants, calendar);
    }


    private WeekRestaurant findWeek(Calendar calendar) {
        Optional<WeekRestaurant> week = findExistingWeek(calendar);

        if(week.isPresent()){
            return week.get();
        }
        WeekRestaurant newWeek = createWeek(calendar);
        weekRestaurants.add(newWeek);
        return newWeek;
    }

    private Optional<WeekRestaurant> findExistingWeek(Calendar calendar) {
        for(WeekRestaurant week:weekRestaurants) {
            if (WeekUtil.isEqualWeek(calendar, week.getWeek())){
                return Optional.of(week);
            }
        }
        return Optional.empty();
    }

    public List<Restaurant> getWeekRestaurants(Calendar week) {
        return findWeek(week).getRestaurants();
    }

    public Restaurant findRestaurant(Calendar week, Long choosenRestaurantId) {
        for(Restaurant r : findWeek(week).getRestaurants()){
            if(choosenRestaurantId.equals(r.getId())){
                return r;
            }
        }
        throw  new RestaurantException("Inesperado: Restaurante não encontrado na semana.");
    }
}
