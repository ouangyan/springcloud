package com.example.busreceive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;


@Component
public class Receiver {
    private static final Logger log= LoggerFactory.getLogger(Receiver.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * @RabbitHandler 与 @RabbitListener一起使用，当@RabbitListener接收到消息时交给@RabbitListener的方法处理(具体交给哪个方法根据MessageConverter转换后的参数类型)
     * @param phone
     */
    @RabbitListener(queues="phone")
    @RabbitHandler
    public String getCodeByPhone(String phone){
        log.info("来自bus-send,手机号为【"+phone+"】需要注册码！");
        Random random=new Random();
        String code="";
        for(int i=0;i<5;i++){
            code+=random.nextInt(10);
        }
        log.info("返回到bus-send的注册码【"+code+"】");
        return code;
    }
}
