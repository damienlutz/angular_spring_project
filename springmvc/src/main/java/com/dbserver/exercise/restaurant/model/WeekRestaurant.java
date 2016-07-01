package com.dbserver.exercise.restaurant.model;

import java.util.Calendar;
import java.util.List;

public class WeekRestaurant {
    private List<Restaurant> restaurants;
    private Calendar week;

    public WeekRestaurant(List<Restaurant> restaurants, Calendar week) {
        this.restaurants = restaurants;
        this.week = week;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public Calendar getWeek() {
        return week;
    }

    public void setWeek(Calendar week) {
        this.week = week;
    }
}
