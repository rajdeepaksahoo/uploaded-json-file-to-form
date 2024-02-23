package com.scheduler.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Configuration
@RequiredArgsConstructor
@Service
public class MailService {
    private final JavaMailSender mailSender;
    public void sendMail(String to, String sub,String body) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject(sub);
        mimeMessageHelper.setFrom("dropofvitalfluid@gmail.com");
        mimeMessageHelper.setText(body);
        mailSender.send(mimeMessage);
    }
}
