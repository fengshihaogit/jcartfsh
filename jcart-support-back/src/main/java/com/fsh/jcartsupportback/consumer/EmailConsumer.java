package com.fsh.jcartsupportback.consumer;

import com.fsh.jcartsupportback.mq.EmailEvent;
import com.fsh.jcartsupportback.util.EmailUtil;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


/**
 * @author Mr.Blake
 * @create 2020-03-23 21:18
 */
@Service
//@RocketMQMessageListener(topic = "SendPwdResetByEmail", consumerGroup = "jcart-support-group01")
public class EmailConsumer implements RocketMQListener<EmailEvent> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EmailUtil emailUtil;

    @Value("${spring.mail.username}")
    private String fromEmail;

    @Override
    public void onMessage(EmailEvent emailEvent) {
        logger.info("{}",emailEvent);
        emailUtil.send(fromEmail,emailEvent.getToEmail(),emailEvent.getTitle(),
                emailEvent.getContent());
    }
}
