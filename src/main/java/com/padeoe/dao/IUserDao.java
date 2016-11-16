package com.padeoe.dao;

import com.padeoe.pojo.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IUserDao {
    int deleteByPrimaryKey(String username);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String username);

    List<User> selectByCondition(User query);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}