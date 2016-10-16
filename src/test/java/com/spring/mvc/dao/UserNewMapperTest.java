/**
* ClassName : UserNewDaoTest.java
* Create on ：2016年10月16日
* Copyrights 2016 guanfl All rights reserved.
* Email : guanfl@foxmail.com
*/
package com.spring.mvc.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.mvc.entity.UserNew;
import com.spring.test.BaseTest;

public class UserNewMapperTest extends BaseTest{

    @Autowired
    private UserNewMapper userNewMapper;
    
    @Test
    public void testSelectByPrimaryKey(){
        UserNew user = userNewMapper.selectByPrimaryKey(1);
    
        System.out.println(user);
    }
}
