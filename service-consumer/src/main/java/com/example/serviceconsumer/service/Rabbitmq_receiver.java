package com.example.serviceconsumer.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Rabbitmq_receiver {

    @RabbitListener(queues = "hello")
    @RabbitHandler
    public void process(String hello){
        System.out.println(hello);
    }
}
