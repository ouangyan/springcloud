package com.example.serviceconsumer.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Rabbitmq_consumerConfig {

    @Bean
    public Queue config(){
        return new Queue("delayed.goods.order");
    }
}
