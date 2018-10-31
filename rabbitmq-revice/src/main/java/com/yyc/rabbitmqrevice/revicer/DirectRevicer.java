package com.yyc.rabbitmqrevice.revicer;

import com.yyc.common.entity.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Auther: yangyongcui
 * @Date: 2018/10/30: 16:20
 * @Description:
 */
@Component
public class DirectRevicer {
    @RabbitListener(queues = "queue")    //监听器监听指定的Queue
    public void processC(String str) {
        System.out.println("Receive:" + str);
    }
    @RabbitListener(queues = "queueUser")    //监听器监听指定的Queue
    public void processUser(User user) {
        System.out.println("Receive:" + user);
    }
    @RabbitListener(queues = "queueUser")    //监听器监听指定的Queue
    public void processUser1(User user) {
        System.out.println("Receive1111:" + user);
    }
}
