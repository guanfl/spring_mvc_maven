/**
* ClassName : TestIfElese.java
* Create on ：2016年11月8日
* Copyrights 2016 guanfl All rights reserved.
* Email : guanfl@foxmail.com
*/
package com.spring.mvc.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestIfElse {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestIfElse.class);
    @Test
    public void testif(){
        System.out.println(condition(null,3,5));
    }
    
    public String condition(Integer a, Integer b,Integer c){
        String result = null;
        if(a != null){
            result = "A";
        }else if(b != null){
            result = "BV"; 
        }else {
            result = "CX";
        }
        return result;
    } 
    
    @Test
    public void testArgs(){
        LOGGER.info("hello {}","first args");
    }
}
