package com.dbserver.exercise.restaurant.service;

import com.dbserver.exercise.restaurant.RestaurantException;
import org.junit.Assert;
import org.junit.Test;

public class RestaurantServiceTest {

    @Test
    public void testVoteRestaurantInvalidRestoId() throws Exception {
        RestaurantService restaurantService = new RestaurantService();
        try {
            restaurantService.voteRestaurant(0L, 0L);
        }catch (RestaurantException e){
            Assert.assertEquals(RestaurantService.RESTAURANTE_JA_VOTADO_OU_INEXISTENTE, e.getMessage());
            return;
        }
        Assert.fail();
    }
    @Test
    public void testVoteRestaurantOk() throws Exception {
        RestaurantService restaurantService = new RestaurantService();

        restaurantService.voteRestaurant(1L, 0L);

        Assert.assertTrue(new Long(1L).equals(restaurantService.getVotesService().getChoosenRestaurantId()));
    }

}