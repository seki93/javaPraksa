package json.JUnitTest;

import json.entities.NonWorkingCalendar;
import json.mapper.GBMapper;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NonWorkingCalendarTest {


    @Test
    public void NonWorkingCalendarTestMethod() {

        List<NonWorkingCalendar> calendars = GBMapper.getAllNonWorkingCalendars();

        assertTrue(!calendars.isEmpty(), " NonWorkingCalendar - list is empty.");
        assertNotNull(calendars, " NonWorkingCalendar - returns null");
        assertEquals(3, calendars.size(), " NonWorkingCalendar - method should not return more than 3 countries.");

        for (int i = 0; i < calendars.size(); i++) {
            assertNotNull(calendars.get(i), " NonWorkingDay - " + i + " " + calendars.get(i).toString() + " returns null");
        }
        System.out.println("Test passed.");
    }
}
