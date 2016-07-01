package com.dbserver.exercise.restaurant.service;

import com.dbserver.exercise.restaurant.model.WeekChoosen;
import com.dbserver.exercise.restaurant.util.WeekUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class WeekChoosenService {

    private List<Long> weekChoosenRestaurants = new ArrayList<Long>();

    private List<WeekChoosen> weekChoosens;
    public WeekChoosenService() {
        weekChoosens = new ArrayList<WeekChoosen>();
    }

    private WeekChoosen createWeek(Calendar calendar) {
        List<Long> weekChoosenRestaurants = new ArrayList<Long>();

        return new WeekChoosen(weekChoosenRestaurants, calendar);
    }

    public Boolean isAlreadyWeekChoosen(Long restaurantId, Calendar calendar) {
        return findWeek(calendar).getWeekChoosenRestaurants().contains(restaurantId);
    }

    public void chooseWeek(Calendar week, Long idRestaurant){
        findWeek(week).addChoosenRestaurant(idRestaurant);
    }

    private WeekChoosen findWeek(Calendar calendar) {
        Optional<WeekChoosen> week = findExistingWeek(calendar);

        if(week.isPresent()){
            return week.get();
        }
        WeekChoosen newWeek = createWeek(calendar);
        weekChoosens.add(newWeek);
        return newWeek;
    }

    private Optional<WeekChoosen> findExistingWeek(Calendar calendar) {
        for(WeekChoosen week:weekChoosens) {
            if (WeekUtil.isEqualWeek(calendar, week.getWeek())){
                return Optional.of(week);
            }
        }
        return Optional.empty();
    }


}
