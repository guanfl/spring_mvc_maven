package com.spring.mvc.dao;

import com.spring.mvc.entity.Group;

public interface GroupMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Group record);

    Group selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Group record);
}