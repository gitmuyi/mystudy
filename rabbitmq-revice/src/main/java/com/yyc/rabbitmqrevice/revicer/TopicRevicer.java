package com.yyc.rabbitmqrevice.revicer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Auther: yangyongcui
 * @Date: 2018/10/30: 19:16
 * @Description:
 */
@Component
public class TopicRevicer {
    @RabbitListener(queues="topic.message")    //监听器监听指定的Queue
    public void process1(String str) {
        System.out.println("message:"+str);
    }


    @RabbitListener(queues="topic.messages")    //监听器监听指定的Queue
    public void process2(String str) {
        System.out.println("messages:"+str);
    }

    @RabbitListener(queues="topic.messages")    //监听器监听指定的Queue
    public void process3(String str) {
        System.out.println("messages333:"+str);
    }

}
