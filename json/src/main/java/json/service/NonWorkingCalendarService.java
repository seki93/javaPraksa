package json.service;


import json.entities.NonWorkingCalendar;
import json.mapper.GBMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NonWorkingCalendarService {

    public static void createThread() {
        Thread thread = new Thread(() -> {
            List<NonWorkingCalendar> listOfallCountries = GBMapper.getAllNonWorkingCalendars();
            System.out.println(listOfallCountries);
            try { Thread.sleep(100); } catch (InterruptedException e) {e.printStackTrace();}
        });

        //delete this
        System.out.println("Da li sam ja zapravo pozvan?!");

        thread.start();
    }
}
