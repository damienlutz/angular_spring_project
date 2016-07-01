package com.dbserver.exercise.restaurant.util;

import java.util.Calendar;

public class WeekUtil {
    public static boolean isEqualWeek(Calendar calendar, Calendar week) {
        return calendar.get(Calendar.YEAR) == week.get(Calendar.YEAR) &&
                calendar.get(Calendar.WEEK_OF_YEAR) == week.get(Calendar.WEEK_OF_YEAR);
    }
}
