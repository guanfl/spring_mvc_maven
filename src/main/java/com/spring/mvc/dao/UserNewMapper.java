package com.spring.mvc.dao;

import com.spring.mvc.entity.UserNew;

public interface UserNewMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserNew record);

    UserNew selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserNew record);
}