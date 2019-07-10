package com.example.serviceprovider;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 *
 * RabbitMQ 生产者场景
 */
@Component
public class Rabbitmq_sender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String content="Hello RabbitMQ! This is my first message! create DateTime:"+new Date();
        this.amqpTemplate.convertAndSend("hello",content);
    }
}
