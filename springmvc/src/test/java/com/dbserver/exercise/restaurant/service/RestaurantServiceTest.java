package com.dbserver.exercise.restaurant.service;

import com.dbserver.exercise.restaurant.exception.RestaurantException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;

public class RestaurantServiceTest {

    private Calendar week = Calendar.getInstance();

    @Test
    public void testVoteRestaurantInvalidRestoId(){
        RestaurantService restaurantService = getRestaurantService();
        try {
            restaurantService.voteRestaurant(0L, 0L, week);
        }catch (RestaurantException e){
            Assert.assertEquals(RestaurantService.RESTAURANTE_JA_VOTADO_OU_INEXISTENTE, e.getMessage());
            return;
        }
        Assert.fail();
    }
    @Test
    public void testVoteRestaurantOk()  {
        RestaurantService restaurantService = getRestaurantService();

        restaurantService.voteRestaurant(1L, 0L, week);

        Assert.assertTrue(new Long(1L).equals(restaurantService.getVotesService().getChoosenRestaurantId()));
    }
    @Test
    public void testVoteRestaurantDifferentRestaurantSameUser() {
        RestaurantService restaurantService = getRestaurantService();
        restaurantService.voteRestaurant(1L, 0L, week);
        try {
            restaurantService.voteRestaurant(2L, 0L, week);
        } catch(RestaurantException e) {
            Assert.assertEquals(RestaurantService.RESTAURANTE_JA_VOTADO_OU_INEXISTENTE, e.getMessage());
            return;
        }
        Assert.fail();
    }
    @Test
    public void testVoteRestaurantDifferentRestaurantDifUser() {

        RestaurantService restaurantService = getRestaurantService();

        restaurantService.voteRestaurant(1L, 0L, week);
        restaurantService.voteRestaurant(1L, 1L, week);

        Assert.assertTrue(new Long(1L).equals(restaurantService.getVotesService().getChoosenRestaurantId()));
    }

    private RestaurantService getRestaurantService() {
        RestaurantService restaurantService = new RestaurantService();
        restaurantService.setWeekChoosenService(new WeekChoosenService());
        return restaurantService;
    }

    @Test
    public void testVoteRestaurantDifferentRestaurantDifUserResto2() {

        RestaurantService restaurantService = getRestaurantService();

        restaurantService.voteRestaurant(1L, 1L, week);
        restaurantService.voteRestaurant(2L, 2L, week);
        restaurantService.voteRestaurant(2L, 3L, week);

        Assert.assertTrue(new Long(2L).equals(restaurantService.getVotesService().getChoosenRestaurantId()));
    }

}