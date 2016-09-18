/**
* ClassName : IUserMapperTest.java
* Create on : 2016年8月16日
* Author : guanfl
* Email : guanfl@ifeng.com
* Copyright 2016 ifeng.com All Rights Reserved
*/
package com.spring.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.spring.mvc.dao.IUserMapper;
import com.spring.mvc.entity.IUser;
import com.spring.mvc.service.IUserService;

public class IUserMapperTest extends BaseTest<IUserMapperTest> {
    @Autowired
    private IUserMapper mapper;
    @Autowired
    private IUserService userService;
    
    @Test
    public void testSelectByPrimaryKey(){
        IUser iuser = mapper.selectByPrimaryKey(65);
        System.out.println("==============>" + iuser);
    }
    
    @Test
    public void testSelectAllIUsers(){
        List<IUser> list = mapper.selectAllIUsers();
        for(IUser user : list){
            System.out.println("==============>" + user);
        }
    }
    
    @SuppressWarnings("rawtypes")
    @Test
    public void selectIUserByPager(){
        PageHelper.startPage(1, 10);
        List<IUser> list = mapper.selectAllIUsers();
        System.out.println(list.size());
        
        long total = ((Page)list).getTotal();
        System.out.println(total);
        
        //devide pages with pageInfo
        PageInfo<IUser> info = new PageInfo<IUser>(list);
        System.out.println("PageNum>>" + info.getPageNum());
        System.out.println("PageSize" + info.getPageSize());
        System.out.println("EndRow>>" + info.getEndRow());
        System.out.println("Total>>" + info.getTotal());
        List<IUser> uList= info.getList();
        for(IUser user : uList){
            System.out.println(user);
        }
        System.out.println();
    }
    //properties?,settings?,typeAliases?,typeHandlers?,objectFactory?,objectWrapperFactory?,plugins?,environments?,databaseIdProvider?,mappers?)
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
    
    @Test
    public void testIUserServiceRollback(){
        userService.saveUser();
    }
}
