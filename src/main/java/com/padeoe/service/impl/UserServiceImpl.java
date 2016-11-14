package com.padeoe.service.impl;

import javax.annotation.Resource;

import com.padeoe.service.IUserService;
import org.springframework.stereotype.Service;

import com.padeoe.dao.IUserDao;
import com.padeoe.pojo.User;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource
	private IUserDao userDao;
	private static AtomicInteger id = new AtomicInteger();
	private static Map<Integer, User> userMap = new HashMap<>();
	@Override
	public User getUserById(int userId) {
		/*
		// TODO Auto-generated method stub
		// 为了糊弄加入静态变量
		return this.userDao.selectByPrimaryKey(userId);
		*/
		return userMap.get(userId);
	}
	@Override
	public User getUserByName(String UserName) {
		for (Map.Entry<Integer, User> entry : userMap.entrySet())
			if (entry.getValue().getUserName().equals(UserName))
				return entry.getValue();
		return null;
	}
	@Override
	public void saveUser(User user){
		int userId = id.getAndIncrement();
		user.setId(userId);
		userMap.put(userId, user);
	}
}
