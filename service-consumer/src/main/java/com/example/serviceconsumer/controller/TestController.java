package com.example.serviceconsumer.controller;

import com.example.serviceconsumer.service.PostServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.MediaType.*;

@RequestMapping(value = "/controller")
@RestController
public class TestController {
    @Autowired
    private PostServiceTest postServiceTest;

    @RequestMapping(value = "test",method = RequestMethod.POST/*,produces = APPLICATION_JSON_VALUE*/)
    public void test(){
        this.postServiceTest.test1();
    }
}
