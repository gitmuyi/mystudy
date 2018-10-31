package com.yyc.rabbitmqsender.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: yangyongcui
 * @Date: 2018/10/30: 16:16
 * @Description:
 */
@Configuration
public class SenderConfigDirect {

    @Bean
    public Queue queue() {
        return new Queue("queue");
    }
    @Bean
    public Queue queueUser() {
        return new Queue("queueUser");
    }


}
