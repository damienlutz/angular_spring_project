package com.dbserver.exercise.restaurant.util;

import java.util.Calendar;

public class WeekUtil {
    public static boolean isEqualWeek(Calendar calendar, Calendar week) {
        return calendar.get(calendar.YEAR) == week.get(calendar.YEAR) &&
                calendar.get(calendar.WEEK_OF_YEAR) == week.get(calendar.WEEK_OF_YEAR);
    }
}
