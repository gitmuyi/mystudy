package com.yyc.rabbitmqsender.send;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther: yangyongcui
 * @Date: 2018/10/30: 19:21
 * @Description:
 */
@Component
public class TopicSender {
    @Autowired
    private AmqpTemplate template;

    public void sendStr(){
        template.convertAndSend("exchange","topic.message","hello rabbitmq");
    }
    public void sendStrs(){
        template.convertAndSend("exchange","topic.messages","hello rabbitmqsssssss");
    }
}
