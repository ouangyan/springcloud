package com.example.servicezuul.application;

import com.alibaba.fastjson.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@EnableZuulProxy
@SpringBootApplication
public class ServiceZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceZuulApplication.class, args);
    }

//    @Bean
//    public FallbackProvider fallBackProvider() {
//        return new FallbackProvider() {
//
//            @Override
//            public String getRoute() {
//                return null;
//            }
//
//            @Override
//            public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
//                return new ClientHttpResponse() {
//                    @Override
//                    public HttpHeaders getHeaders() {
//                        return null;
//                    }
//                    @Override
//                    public InputStream getBody() throws IOException {
//                        JSONObject json =new JSONObject();
//                        json.put("state","600");
//                        json.put("msg","服务器请求繁忙，请稍后...");
//                        return new ByteArrayInputStream(json.toJSONString().getBytes("UTF-8")); //返回前端的内容
//                    }
//
//                    @Override
//                    public String getStatusText() throws IOException {
//                        // TODO Auto-generated method stub
//                        return "Service Down";
//                    }
//
//                    @Override
//                    public HttpStatus getStatusCode() throws IOException {
//                        // TODO Auto-generated method stub
//                        return HttpStatus.OK;
//                    }
//
//                    @Override
//                    public int getRawStatusCode() throws IOException {
//                        // TODO Auto-generated method stub
//                        return 200;
//                    }
//
//                    @Override
//                    public void close() {
//                        // TODO Auto-generated method stub
//
//                    }
//                };
//            }
//        };
//    }
}
