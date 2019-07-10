package com.example.bussend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Sender {
    private static final Logger log= LoggerFactory.getLogger(Sender.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String phone="139";
        Random random=new Random();
        for(int i=0;i<8;i++){
            phone+=random.nextInt(10);
        }
        log.info("发送手机号【"+phone+"】到bus-receive！");
        // 调用convertSendAndReceive 方法时会使用 MessageConvert 进行消息的序列化
        // 声明为"phone"的队列
        Object obj=this.amqpTemplate.convertSendAndReceive("phone",phone);
        log.info("收到bus-receive返回的注册码【"+obj.toString()+"】");
    }
}

