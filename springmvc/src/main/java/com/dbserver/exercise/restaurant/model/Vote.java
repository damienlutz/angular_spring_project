package com.dbserver.exercise.restaurant.model;

public class Vote {
    private Long restaurantId;
    private Long userId;

    public Vote(Long restaurantId, Long userId) {
        this.restaurantId = restaurantId;
        this.userId = userId;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
