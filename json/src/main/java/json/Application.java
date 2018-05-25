package json;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import json.Scheduler.CronTrigger;
import org.quartz.SchedulerException;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        try {
            CronTrigger.createTrigger();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
