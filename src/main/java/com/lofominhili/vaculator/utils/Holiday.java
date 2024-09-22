package com.lofominhili.vaculator.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Utility class for handling holidays and weekends.
 * Provides methods to calculate and retrieve the list of holidays and weekends
 * within a specified date range.
 *
 * @author daniel
 */
public class Holiday {

    /**
     * Returns a list of holidays and weekends between the specified start and end dates.
     * The method includes predefined holidays (e.g., New Year's Day and Labor Day) and
     * identifies weekends (Saturdays and Sundays) in the date range.
     *
     * @param start The start date of the range.
     * @param end   The end date of the range.
     * @return A {@link List} of {@link LocalDate} objects representing holidays and weekends
     * within the specified date range.
     */
    public static List<LocalDate> getHolidaysAndWeekends(LocalDate start, LocalDate end) {
        List<LocalDate> holidaysAndWeekends = new ArrayList<>();

        List<LocalDate> holidays = Arrays.asList(
                LocalDate.of(start.getYear(), 1, 1),
                LocalDate.of(start.getYear(), 5, 1)
        );

        for (LocalDate date = start; !date.isAfter(end); date = date.plusDays(1)) {
            if (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY || holidays.contains(date)) {
                holidaysAndWeekends.add(date);
            }
        }

        return holidaysAndWeekends;
    }
}
