package com.dbserver.exercise.restaurant.model;

public class VoteSum {
    private Long restaurantId;
    private Integer total;

    public VoteSum(Long restaurantId, Integer total) {
        this.restaurantId = restaurantId;
        this.total = total;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
