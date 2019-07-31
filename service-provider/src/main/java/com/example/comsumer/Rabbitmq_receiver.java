package com.example.comsumer;

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
    public ReceiverHandler receiverHandler = null;

    @RabbitHandler
    public void process(String msg){
        log.info("当前接收时间:" + sdf.format(new Date()));
        log.info("当前消息内容:"+msg);
        if(receiverHandler != null){
            this.receiverHandler.handle(msg);
        }
    }
}
