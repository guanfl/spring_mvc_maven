/**
* ClassName : UserNewService.java
* Create on ：2016年10月16日
* Copyrights 2016 guanfl All rights reserved.
* Email : guanfl@foxmail.com
*/
package com.spring.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvc.dao.UserNewMapper;
import com.spring.mvc.entity.UserNew;

@Service
public class UserNewService {
    @Autowired
    private UserNewMapper mapper;
    
    public UserNew getUserNew(Integer id){
        return mapper.selectByPrimaryKey(id);
    }
}
