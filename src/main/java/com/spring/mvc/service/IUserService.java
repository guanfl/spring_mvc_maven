/**
* ClassName : IUserService.java
* Create on : 2016年8月16日
* Author : guanfl
* Email : guanfl@ifeng.com
* Copyright 2016 ifeng.com All Rights Reserved
*/
package com.spring.mvc.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvc.dao.IUserMapper;
import com.spring.mvc.entity.IUser;

@Service
public class IUserService {
    @Autowired
    private IUserMapper mapper;
    
    public void saveUser(){
        IUser user = new IUser();
        user.setCity(90);
        user.setCreatedate(new Date());
        user.setDescription("discription");
        user.setLastlogintime(new Date());
        user.setPassport("xxxx");
        user.setProvince(77);
        user.setPassword("xxxx");
        
        IUser user2 = new IUser();
        user2.setCity(89);
        user2.setCreatedate(new Date());
        user2.setDescription("discription");
        user2.setLastlogintime(new Date());
        user2.setPassport("AAAA");
        user2.setProvince(77);
        user2.setPassword("shishishishishihiewihfowhoheohwohfehohsohoehoshoheohsohfoehoshfoehsohfoehsohofheoshfoehsohfoeshofehso");
        mapper.insert(user);                //能够正常执行
        //mapper.updateByPrimaryKey(user);    //能够正常执行
        mapper.insertSelective(user2);      //有异常
        //预期一条都没有执行成功，master数据库中没有新增一条数据
    }
}
