package com.example.serviceprovider;

import com.example.bean.TestObjectMapperBean;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ObjectMapperTest {

    @Test
    public void testMap() throws IOException {
        String strTemp="abcdefg";
        int intTemp=100;
        Map<String,Object> mapTemp=new HashMap<>();
        mapTemp.put("intTemp",intTemp);
        mapTemp.put("strTemp",strTemp);

        ObjectMapper objectMapper=new ObjectMapper();
        String json=objectMapper.writeValueAsString(mapTemp);
        System.out.println("打印json到控制台："+json);

        Map<String,String> mapTemp2=objectMapper.readValue(json,new TypeReference<Map<String,String>>() {});
        int intTemp2=Integer.parseInt(mapTemp2.get("intTemp"));
        String strTemp2=mapTemp2.get("strTemp");
        System.out.println("打印mapTemp2中的两个值到控制台："+intTemp2+":"+strTemp2);
    }

    @Test
    public void testBean() throws IOException {
        TestObjectMapperBean tomb=new TestObjectMapperBean();
        tomb.setId(1001);
        tomb.setName("xjbd");

        ObjectMapper objectMapper=new ObjectMapper();
        String json=objectMapper.writeValueAsString(tomb);
        System.out.println("打印json到控制台："+json);

        TestObjectMapperBean tombTemp=objectMapper.readValue(json,TestObjectMapperBean.class);
        int id=tombTemp.getId();
        String name=tombTemp.getName();
        System.out.println("打印TestObjectMapperBean类中的两个属性到控制台："+id+":"+name);
    }
}
