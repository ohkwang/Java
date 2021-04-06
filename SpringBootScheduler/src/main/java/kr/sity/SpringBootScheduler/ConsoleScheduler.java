package kr.sity.SpringBootScheduler;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ConsoleScheduler {
	
	@Scheduled(cron = "*/10 * * * * *")
    public void printDate () {
        System.out.println(new Date().toString());
    }

}
