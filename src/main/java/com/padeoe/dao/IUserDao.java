package com.padeoe.dao;

import com.padeoe.pojo.User;

import java.util.List;

public interface IUserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectByCondition(User query);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}