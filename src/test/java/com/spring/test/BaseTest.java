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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:applicationContext.xml")
public abstract class BaseTest<T> {
    //subclass's class info
    @SuppressWarnings("unused")
    private Class<?> clazz = this.getClass();
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @SuppressWarnings("unchecked")
    public BaseTest(){
        ParameterizedType parameterizedType = (ParameterizedType)this.getClass().getGenericSuperclass();
        clazz = (Class<T>)parameterizedType.getActualTypeArguments()[0];
    }
}
