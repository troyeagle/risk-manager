package com.padeoe.service;

import com.padeoe.pojo.User;

public interface IUserService {
    public User getUserById(int userId);

    public User getUserByName(String UserName);

    public int saveUser(User user);
}
