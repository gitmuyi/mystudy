package com.yyc.rabbitmqsender.send;

import com.yyc.common.entity.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther: yangyongcui
 * @Date: 2018/10/30: 16:17
 * @Description:
 */
@Component
public class DirectSender {
    @Autowired
    private AmqpTemplate template;

    public void send() {
        template.convertAndSend("queue", "hello,rabbit~");
    }

    public void sendUser() {
        User user = new User();
        user.setAge(10);
        user.setName("杨永翠");
        template.convertAndSend("queueUser", user);
    }

}
