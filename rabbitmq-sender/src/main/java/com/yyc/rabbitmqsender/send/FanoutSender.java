package com.yyc.rabbitmqsender.send;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther: yangyongcui
 * @Date: 2018/10/31: 13:23
 * @Description:
 */
@Component
public class FanoutSender {
    @Autowired
    AmqpTemplate amqpTemplate;

    public void hello(){
        amqpTemplate.convertAndSend("fanoutExchange","","hshshh");
    }

}
