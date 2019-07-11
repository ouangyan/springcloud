package com.example.serviceconsumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@RabbitListener(queues = "delayed.goods.order")
public class Rabbitmq_receiver {
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private final static Logger log= LoggerFactory.getLogger(Rabbitmq_receiver.class);
    private static List<Integer> lists=new ArrayList<>();

    @RabbitHandler
    public void process(String msg){
        log.info("接收时间:" + sdf.format(new Date()));
        log.info("消息内容:"+msg);
    }
}
