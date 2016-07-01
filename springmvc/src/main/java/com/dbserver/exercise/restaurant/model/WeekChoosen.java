package com.dbserver.exercise.restaurant.model;

import java.util.Calendar;
import java.util.List;

public class WeekChoosen {
    private List<Long> weekChoosenRestaurants;
    private Calendar week;

    public WeekChoosen(List<Long> weekChoosenRestaurants, Calendar week) {
        this.weekChoosenRestaurants = weekChoosenRestaurants;
        this.week = week;
    }

    public List<Long> getWeekChoosenRestaurants() {
        return weekChoosenRestaurants;
    }

    public void setWeekChoosenRestaurants(List<Long> weekChoosenRestaurants) {
        this.weekChoosenRestaurants = weekChoosenRestaurants;
    }

    public Calendar getWeek() {
        return week;
    }

    public void setWeek(Calendar week) {
        this.week = week;
    }

    public void addChoosenRestaurant(Long idRestaurant) {
        weekChoosenRestaurants.add(idRestaurant);
    }
}
