package com.example.serviceprovider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 *
 * RabbitMQ 生产者场景
 */
@Component
public class Rabbitmq_sender {
    private static Logger log= LoggerFactory.getLogger(Rabbitmq_sender.class);
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String msg){
        log.info("Hi! hyy1! 发送消息时间为："+sdf.format(new Date()));

        rabbitTemplate.convertAndSend("delayedec", "delayed.goods.order", msg, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                Random random=new Random();
                int randomNum=random.nextInt(3);
                int delayTime=2000;
                if(randomNum==1)
                    delayTime=5000;
                else if(randomNum==2)
                    delayTime=8000;
                message.getMessageProperties().setHeader("x-delay", delayTime);
                log.info("发送的消息延迟时间为："+delayTime+"毫秒!");
                return message;
            }
        });
    }
}
