package com.padeoe.service;

import com.padeoe.pojo.User;

import java.util.List;

public interface IUserService {
    public User getUserById(int userId);

    public int saveUser(User user);

    public List<User> getUserByCondition(User condition);
}
