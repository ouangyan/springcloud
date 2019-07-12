package com.example.serviceprovider;

import com.example.comsumer.Rabbitmq_receiver;
import com.example.comsumer.ReceiverHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Rabbitmq_sender_countDownLatchTest {

    @Autowired
    private Rabbitmq_sender rabbitmq_sender;
    @Autowired
    private Rabbitmq_receiver rabbitmq_receiver;

    @Test
    public void senderTest() throws InterruptedException, TimeoutException {
        int totalCount = 10;
        CountDownLatch countDownLatch = new CountDownLatch(totalCount);
        ReceiverHandler handler = new ReceiverHandler() {
            @Override
            public void handle(String message) {
                countDownLatch.countDown();
            }
        };
        rabbitmq_receiver.receiverHandler = handler;
        for(int j=1;j<=totalCount;j++){
            this.rabbitmq_sender.send("你好 hyy1!这是第"+j+"条消息！");
        }

        if(!countDownLatch.await(60, TimeUnit.SECONDS)){
            throw new TimeoutException();
        }
    }
}
