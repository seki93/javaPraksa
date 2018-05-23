package json.Scheduler;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class CronTrigger {

    public static void createTrigger() throws SchedulerException {
        JobDetail job = JobBuilder.newJob(TriggereedJob.class)
                .withIdentity("ThreadTrigger").build();

        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("ThreadTrigger")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 5 * * * ?"))   //"0 0 1 1 1 ?" - 1 jan 1:00
                .build();

        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        try {
            scheduler.start();
            scheduler.scheduleJob(job, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

}
