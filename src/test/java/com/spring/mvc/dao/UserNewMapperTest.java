/**
* ClassName : UserNewDaoTest.java
* Create on ：2016年10月16日
* Copyrights 2016 guanfl All rights reserved.
* Email : guanfl@foxmail.com
*/
package com.spring.mvc.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.mvc.entity.Group;
import com.spring.mvc.entity.UserNew;
import com.spring.mvc.entity.linked.UserNewLinked;
import com.spring.test.BaseTest;

public class UserNewMapperTest extends BaseTest{

    @Autowired
    private UserNewMapper userNewMapper;
    
    @Test
    public void testSelectByPrimaryKey(){
        UserNew user = userNewMapper.selectByPrimaryKey(1);
    
        System.out.println(user);
    }
    
    @Test
    public void testQueryUserAndGroups(){
        UserNew user =  new UserNew();
        user.setId(1);
        UserNewLinked userNew = (UserNewLinked)userNewMapper.queryUserAndGroups(user);
        System.out.println("ID " + userNew.getId());
        System.out.println("userName " + userNew.getName());
        System.out.println("password: " + userNew.getPassword());
        System.out.println("create_time" + userNew.getCreatetime());
        
        List<Group> groups = userNew.getGroups();
        for (Group group : groups) {
            System.out.println(group);
        }
    }
}
