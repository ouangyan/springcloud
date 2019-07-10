package com.example.busreceive;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    // 声明队列
    @Bean
    public Queue queueAdd3(){
        return new Queue("phone");
    }
}
