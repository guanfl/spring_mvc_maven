/**
* ClassName : BaseTest.java
* Create on : 2016年8月16日
* Author : guanfl
* Email : guanfl@ifeng.com
* Copyright 2016 ifeng.com All Rights Reserved
*/
package com.spring.test;

import java.lang.reflect.ParameterizedType;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:applicationContext.xml")
public abstract class BaseTest<T> {
    private Class<T> clazz;
    //protected Logger logger = LoggerFactory.getLogger(clazz);
    
    @SuppressWarnings("unchecked")
    public BaseTest(){
        ParameterizedType parameterizedType = (ParameterizedType)this.getClass().getGenericSuperclass();
        clazz = (Class<T>)parameterizedType.getActualTypeArguments()[0];
    }
}
