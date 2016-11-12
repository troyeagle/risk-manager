package com.padeoe.service.impl;

import javax.annotation.Resource;

import com.padeoe.service.IUserService;
import org.springframework.stereotype.Service;

import com.padeoe.dao.IUserDao;
import com.padeoe.pojo.User;
import com.padeoe.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource
	private IUserDao userDao;
	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return this.userDao.selectByPrimaryKey(userId);
	}

}
