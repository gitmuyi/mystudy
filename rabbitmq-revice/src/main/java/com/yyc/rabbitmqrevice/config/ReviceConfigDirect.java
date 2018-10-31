package com.yyc.rabbitmqrevice.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Auther: yangyongcui
 * @Date: 2018/10/30: 16:19
 * @Description:
 */
@Configuration
public class ReviceConfigDirect {
    @Bean
    public Queue queue() {
        return new Queue("queue");
    }

    @Bean
    public Queue queueUser() {
        return new Queue("queueUser");
    }
}
