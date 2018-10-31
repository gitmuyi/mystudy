package com.yyc.rabbitmqsender;

import com.yyc.rabbitmqsender.send.DirectSender;
import com.yyc.rabbitmqsender.send.FanoutSender;
import com.yyc.rabbitmqsender.send.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqSenderApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private DirectSender helloSender;
    @Autowired
    TopicSender topicSender;

    @Autowired
    FanoutSender fanoutSender;

    @Test
    public void testRabbit() {
        helloSender.send();
    }

    @Test
    public void testRabbitUser() {
        for (int i = 0; i < 10; i++) {
            helloSender.sendUser();

        }
    }

    @Test
    public void testRabbitTopic() {
        topicSender.sendStr();
    }

    @Test
    public void testRabbitTopics() {
        for (int i = 0; i < 100; i++) {
            topicSender.sendStrs();

        }
    }

    @Test
    public void testRabbitFanout() {
        for (int i = 0; i < 100; i++) {
            fanoutSender.hello();

      }
    }
}
