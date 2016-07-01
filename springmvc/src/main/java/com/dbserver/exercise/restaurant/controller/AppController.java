package com.dbserver.exercise.restaurant.controller;

import com.dbserver.exercise.restaurant.exception.RestaurantException;
import com.dbserver.exercise.restaurant.model.Restaurant;
import com.dbserver.exercise.restaurant.model.VoteInput;
import com.dbserver.exercise.restaurant.model.VoteResponse;
import com.dbserver.exercise.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@RestController
public class AppController {

    @Autowired
    private RestaurantService restaurantService;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/hello")
    public String printHello() {
        return "";
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping(value = "/restaurants", method = RequestMethod.POST)
    public List<Restaurant> restaurants() {
        return restaurantService.getRestaurants(Calendar.getInstance());
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping(value = "/voteRestaurant", method = RequestMethod.POST)
    public VoteResponse voteRestaurant(@RequestBody VoteInput id) {
        try{
            restaurantService.voteRestaurant(Long.valueOf(id.getRestaurantId()), Long.valueOf(id.getUserId()), Calendar.getInstance());
        }catch (RestaurantException e){
            System.out.println(e + ",\n"+ e.getMessage());
            return new VoteResponse(false, e.getMessage());
        }
        return new VoteResponse(true, "");
    }

}