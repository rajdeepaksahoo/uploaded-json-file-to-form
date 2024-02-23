package com.scheduler.schedule;

import com.scheduler.service.MailService;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@AllArgsConstructor
public class ScheduleConfig {
    private static final Logger log = LoggerFactory.getLogger(ScheduleConfig.class);
    private MailService mailConfig;
    @Scheduled(fixedRate = 5000)
//    @Scheduled(cron = "0 01 22 * * *")
    public void schedule() throws MessagingException {
        log.info("The current time is {}",new Date());
        mailConfig.sendMail("sahooramakrushna37@gmail.com","Testing","The current time is "+new Date());
    }
}
