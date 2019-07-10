package com.example.serviceprovider;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Rabbitmq_senderTest {

    @Autowired
    private Rabbitmq_sender rabbitmq_sender;

    @Test
    public void senderTest(){
        this.rabbitmq_sender.send();
    }
}
