package com.yyc.rabbitmqrevice.revicer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Auther: yangyongcui
 * @Date: 2018/10/31: 13:25
 * @Description:
 */
@Component
public class FanoutRevicer {
    @RabbitListener(queues = "fanout.A")
    public void processA(String str1) {
        System.out.println("ReceiveA:" + str1);
    }

    @RabbitListener(queues = "fanout.B")
    public void processB(String str) {
        System.out.println("ReceiveB:" + str);
    }

    @RabbitListener(queues = "fanout.C")
    public void processC(String str) {
        System.out.println("ReceiveC:" + str);
    }
}
