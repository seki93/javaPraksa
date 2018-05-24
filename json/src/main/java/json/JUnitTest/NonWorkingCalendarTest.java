package json.JUnitTest;

import json.entities.NonWorkingCalendar;
import json.mapper.GBMapper;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NonWorkingCalendarTest {


    @Test
    public void NonWorkingCalendarTestMethod() {

        List<NonWorkingCalendar> calendars = GBMapper.getAllNonWorkingCalendars();

        assertTrue(!calendars.isEmpty(), " NonWorkingCalendar - list is empty.");
        System.out.println("Prosao test 1");
        assertTrue(calendars != null, " NonWorkingCalendar - returns null.");
        System.out.println("Prosao test 2");
        assertEquals(3, calendars.size(), " NonWorkingCalendar - method should not return more than 3 countries.");
        System.out.println("Prosao test 3");

        for (int i = 0; i < calendars.size(); i++) {
            assertTrue(calendars.get(i) != null, " NonWorkingDay - " + i + " " + calendars.get(i).toString() + " returns null");
        }
        System.out.println("Prosao test 4");
    }
}
