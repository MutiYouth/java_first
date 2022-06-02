package com.sunlab.helloweb.serviceImpl;

import com.sunlab.helloweb.bean.UserBean;
import com.sunlab.helloweb.mapper.UserMapper;
import com.sunlab.helloweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  // 将DAO注入到Service层
  @Autowired
  private UserMapper userMapper;

  @Override
  public UserBean login(String name, String password) {
    return userMapper.getInfo(name, password);
  }
}
