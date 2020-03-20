package com.fsh.jcartadministrationback.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author Mr.Blake
 * @create 2020-03-20 18:00
 */
@Component
public class EmailUtil {


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JavaMailSender javaMailSender;

    @Async
    public void  send(String fromEmail,
                      String toEmail,
                      String title,
                      String content){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(toEmail);
        message.setSubject(title);
        message.setText(content);
        javaMailSender.send(message);

        logger.info("send email ended");
    }
}
