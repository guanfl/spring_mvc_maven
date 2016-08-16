/**
* ClassName : IUserMapperTest.java
* Create on : 2016年8月16日
* Author : guanfl
* Email : guanfl@ifeng.com
* Copyright 2016 ifeng.com All Rights Reserved
*/
package com.spring.test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.mvc.dao.IUserMapper;
import com.spring.mvc.entity.IUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:applicationContext.xml")
public class IUserMapperTest /*extends BaseTest<IUserMapperTest>*/ {
    @Autowired
    private IUserMapper mapper;
    
    @Test
    public void testSelectByPrimaryKey(){
        IUser iuser = mapper.selectByPrimaryKey(65);
        System.out.println("==============>" + iuser);
    }
    
    @Test
    public void testInsertSelective(){
        IUser user = new IUser();
        user.setCity(90);
        user.setCreatedate(new Date());
        user.setDescription("discription");
        user.setLastlogintime(new Date());
        user.setPassport("xxxx");
        user.setProvince(77);
        user.setPassword("xxxx");
        mapper.insertSelective(user);
    }
}
