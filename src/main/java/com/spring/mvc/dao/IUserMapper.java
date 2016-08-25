package com.spring.mvc.dao;

import java.util.List;

import com.spring.mvc.entity.IUser;

public interface IUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IUser record);

    int insertSelective(IUser record);

    IUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IUser record);

    int updateByPrimaryKey(IUser record);
    
    List<IUser> selectAllIUsers();
}