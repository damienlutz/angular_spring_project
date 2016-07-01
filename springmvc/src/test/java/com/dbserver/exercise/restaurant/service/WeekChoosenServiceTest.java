package com.dbserver.exercise.restaurant.service;

import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;

public class WeekChoosenServiceTest {

    @Test
    public void testIsAlreadyWeekChoosen() throws Exception {
        WeekChoosenService weekChoosenService = new WeekChoosenService();
        weekChoosenService.chooseRestaurant(Calendar.getInstance(), 1L);
        Assert.assertTrue(weekChoosenService.isAlreadyWeekChoosen(1L, Calendar.getInstance()));
    }

    @Test
    public void testIsNotAlreadyWeekChoosen() throws Exception {
        WeekChoosenService weekChoosenService = new WeekChoosenService();
        weekChoosenService.chooseRestaurant(Calendar.getInstance(), 1L);
        Assert.assertFalse(weekChoosenService.isAlreadyWeekChoosen(2L, Calendar.getInstance()));
    }

}