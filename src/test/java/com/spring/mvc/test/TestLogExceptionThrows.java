/**
* ClassName : TestLogExceptionThrows.java
* Create on ：2016年11月8日
* Copyrights 2016 guanfl All rights reserved.
* Email : guanfl@foxmail.com
*/
package com.spring.mvc.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLogExceptionThrows {
    private static Logger logger = LoggerFactory.getLogger(TestLogExceptionThrows.class);
    
    @Test
    public void testException(){
        try {
            System.out.println("xxxxxxxxxxxxxxx");
            throw new IllegalArgumentException("illegalArgument...");
        } catch (Exception e) {
            //e.printStackTrace();
            logger.error("logge message ....", e);
        }
    }
    
}
