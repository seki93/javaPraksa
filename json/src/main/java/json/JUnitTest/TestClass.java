package json.JUnitTest;

import json.entities.NonWorkingCalendar;
import json.mapper.GBMapper;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ErrorCollector;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestClass {

//    @Rule
//    private ErrorCollector collector = new ErrorCollector();

    @Test
    public void testMethod() {

        List<NonWorkingCalendar> calendars = GBMapper.getAllNonWorkingCalendars();

        assertTrue(!calendars.isEmpty(), "NonWorkingCalendar - list is empty.");
        System.out.println("Prosao test 2");
        assertTrue(calendars != null, "NonWorkingCalendar - returns null.");
        System.out.println("Prosao test 3");
        assertEquals(3, calendars.size(), "NonWorkingCalendar - method should not return more than 3 countries.");
        System.out.println("Prosao test 4");

        for (int i = 0; i < calendars.size(); i++) {
            assertTrue(calendars.get(i) != null, "NonWorkingDay - " + i + " " + calendars.get(i).toString() + " returns null");
        }
        System.out.println("Prosao test 5");
    }
}
