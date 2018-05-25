package json.scheduler;

import json.service.NonWorkingCalendarService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

public class TriggereedJob implements Job {

    @Autowired
    NonWorkingCalendarService nonWorkingCalendarService;

    public void execute(JobExecutionContext context) throws JobExecutionException {
        nonWorkingCalendarService.createThread();
    }
}
