package com.dbserver.exercise.restaurant.service;

import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;

public class WeekRestaurantsServiceTest {

    @Test
    public void testIsValidId() throws Exception {
        WeekRestaurantsService weekRestaurantsService = new WeekRestaurantsService();
        Assert.assertTrue(weekRestaurantsService.isValidId(1L, Calendar.getInstance()));
    }

    @Test
    public void testIsInValidId() throws Exception {
        WeekRestaurantsService weekRestaurantsService = new WeekRestaurantsService();
        Assert.assertFalse(weekRestaurantsService.isValidId(-1L, Calendar.getInstance()));
    }
}