package com.padeoe.service.impl;

import com.padeoe.dao.IUserDao;
import com.padeoe.pojo.User;
import com.padeoe.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;
    //	private static AtomicInteger id = new AtomicInteger();
//	private static Map<Integer, User> userMap = new HashMap<>();
    @Override
    public User getUserById(int userId) {
		/*
		// TODO Auto-generated method stub
		// 为了糊弄加入静态变量
		return this.userDao.selectByPrimaryKey(userId);
		*/
        return userDao.selectByPrimaryKey(userId);
    }
    @Override
    public List<User> getUserByCondition(User user) {
        List<User> result = userDao.selectByCondition(user);
        return result;
    }

    @Override
    public int saveUser(User user){
        return userDao.insert(user);
    }
}
