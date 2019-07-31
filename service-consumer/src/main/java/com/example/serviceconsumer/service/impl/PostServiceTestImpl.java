package com.example.serviceconsumer.service.impl;

import com.example.serviceconsumer.service.PostServiceTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PostServiceTestImpl implements PostServiceTest {
    private final static Logger log= LoggerFactory.getLogger(PostServiceTestImpl.class);
    @Override
    public void test1() {
        log.info("这是一个post请求的测试用例");
    }
}
