package com.dbserver.exercise.restaurant.controller;

import com.dbserver.exercise.restaurant.exception.RestaurantException;
import com.dbserver.exercise.restaurant.model.AdminInput;
import com.dbserver.exercise.restaurant.model.Restaurant;
import com.dbserver.exercise.restaurant.model.VoteInput;
import com.dbserver.exercise.restaurant.model.VoteResponse;
import com.dbserver.exercise.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
            restaurantService.voteRestaurant(Long.valueOf(id.getRestaurantId()), Long.valueOf(id.getUserId()), getWeek(id.getWeek()));
        }catch (RestaurantException e){
            System.out.println(e + ",\n"+ e.getMessage());
            return new VoteResponse(false, e.getMessage());
        }
        return new VoteResponse(true, "");
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping(value = "/getChoosenRestaurant", method = RequestMethod.POST)
    public Restaurant getChoosenRestaurant(@RequestBody AdminInput admin) {
        return restaurantService.getChoosenRestaurant(getWeek(admin.getWeek()));
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping(value = "/reset", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void reset() {
        restaurantService.reset();
    }


    public Calendar getWeek(String id) {
        Calendar week = Calendar.getInstance();
        Integer weekNumber = Integer.valueOf(id);
        week = sumWeeks(week, weekNumber);
        return week;
    }

    public Calendar sumWeeks(Calendar week, Integer weekNumber) {
        week.add(Calendar.DATE, 7 * weekNumber);
        return week;
    }

}