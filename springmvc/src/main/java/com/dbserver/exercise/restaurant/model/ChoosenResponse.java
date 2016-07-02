package com.dbserver.exercise.restaurant.model;

public class ChoosenResponse {
    private Boolean valid;
    private Restaurant restaurant;
    private String reason;

    public ChoosenResponse(Boolean valid, Restaurant restaurant, String reason) {
        this.valid = valid;
        this.restaurant = restaurant;
        this.reason = reason;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
