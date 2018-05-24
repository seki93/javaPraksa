package json.JUnitTest;

import json.entities.NonWorkingCalendar;
import json.entities.NonWorkingDay;
import json.mapper.GBMapper;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
            assertNotNull(calendars.get(i), " NonWorkingDay - " + i + " " + calendars.get(i) + " returns null");
        }

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy");
        LocalDateTime timeNow = LocalDateTime.now();
        String currentYear = dtf.format(timeNow);

        for (int i = 0; i < calendars.size(); i++) {
            for (int j = 0; j < calendars.get(i).getNonWorkingDays().size(); j++) {
                assertTrue(GBMapper.compareDates(calendars.get(i).getNonWorkingDays().get(j).getNonWorkDate(), currentYear) == true, " Date is not supposed to be older than current year.");
            }
        }
        System.out.println("Test passed.");
    }
}
