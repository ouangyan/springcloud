package com.example.bussend;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusSendApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private Sender sender;

    @Test
    public void test1() throws Exception{
        this.sender.send();
    }

}
