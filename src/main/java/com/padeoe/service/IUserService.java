package com.padeoe.service;

import com.padeoe.pojo.User;

import java.util.List;

public interface IUserService {
    public User getUserByName(String username);

    public void saveUser(User user);

    public List<User> getUserByCondition(User condition);
}
