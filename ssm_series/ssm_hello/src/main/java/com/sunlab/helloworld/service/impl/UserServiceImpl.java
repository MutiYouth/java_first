package com.sunlab.helloworld.service.impl;

import com.sunlab.helloworld.dao.IUserDao;
import com.sunlab.helloworld.model.User;
import com.sunlab.helloworld.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    public User selectUser(long userId) {
        return userDao.selectUser(userId);
    }
}