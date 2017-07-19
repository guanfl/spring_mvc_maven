/**
* ClassName : SysUserMapperTest.java
* Create on ：2017年5月4日
* Copyrights 2017 guanfl All rights reserved.
* Email : guanfl@foxmail.com
*/
package com.spring.mvc.dao;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.mvc.entity.SysUser;
import com.spring.test.BaseTest;

public class SysUserMapperTest extends BaseTest {
    @Autowired
    private SysUserMapper mapper;
    
    @Test
    public void testInsert(){
        SysUser u = new SysUser();
        u.setAccount("admin");
        u.setPassword("password");
        u.setEmail("123@163.com");
        u.setCreateBy(1);
        u.setToken("b0b56d6fee4150567afbdd859a07b42d");
        u.setUpdateTime(new Date());
        u.setUserName("中文名称");
        u.setUpdateTime(new Date());
        u.setEnable(true);
        u.setGender(true);
        mapper.insertSelective(u);
    }
}
