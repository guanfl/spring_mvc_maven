/**
* ClassName : JacksonUnWrappedTest.java
* Create on ：2016年9月28日
* Copyrights 2016 guanfl All rights reserved.
* Email : guanfl@163.com
*/
package com.spring.mvc.jackson;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.mvc.entity.ChinaArea;
import com.spring.mvc.entity.linked.StudentLinked;

public class JacksonUnWrappedTest {
    private ObjectMapper objectMapper;

    @Before
    public void before(){
        objectMapper = new ObjectMapper();
    }
    @Test
    public void jsonUnWrapped() throws JsonProcessingException{
        StudentLinked student = new StudentLinked ();
        student.setArea("100030");
        student.setId(1);
        student.setBrithday(new Date());
        student.setName("zhangsan");
        student.setScore(19.37);
        
        ChinaArea ca = new ChinaArea();
        ca.setCityCode("11330");
        ca.setCityName("cityName");
        ca.setCountry("cn");
        ca.setLevel(1);
        ca.setName("name");
        ca.setCode("code");
        ca.setProvinceCode("provinceCode");
        ca.setProvinceName("provinceName");
        student.setChinaArea(ca);
        
        String jsonStr = objectMapper.writeValueAsString(student);
        System.out.println(jsonStr);
    }
    
    @Test
    public void testJsonUnWrappedDeSerialized() throws Exception{
        String jsonStr = "{\"id\":1,\"name\":\"zhangsan\",\"brithday\":1475072213400,\"score\":19.37,\"area\":\"100030\",\"code\":\"code\",\"name\":\"name\",\"cityCode\":\"11330\",\"cityName\":\"cityName\",\"provinceCode\":\"provinceCode\",\"provinceName\":\"provinceName\",\"country\":\"cn\",\"level\":1}";
        StudentLinked sl = objectMapper.readValue(jsonStr, StudentLinked.class);
        System.out.println(sl.getName());
        ChinaArea chinaArea = sl.getChinaArea();
        System.out.println(chinaArea);
    }
    
    
    
}
