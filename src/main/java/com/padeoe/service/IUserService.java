package com.padeoe.service;

import com.padeoe.pojo.User;

import java.util.List;

public interface IUserService {
    public User getUserByName(String username);

    public void saveUser(User user);

    /**
     *
     * @param condition 将搜索的条件输入User中，各个条件为并集。
     * @return
     */
    public List<User> getUserByCondition(User condition);
}
