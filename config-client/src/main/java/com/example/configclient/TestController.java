package com.example.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class TestController {
    @Value("${profile}")
    String profile;
    @Value("${version}")
    String version;

    @RequestMapping(value="/hi")
    public String init(){
        return this.profile;
    }

    @RequestMapping(value="/hi2")
    public String init2(){
        return this.version;
    }
}
