package com.weng.test_simple_app.serviceImpl;

import com.weng.test_simple_app.bean.UserBean;
import com.weng.test_simple_app.mapper.UserMapper;
import com.weng.test_simple_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  // 将DAO注入到Service层
  @Autowired UserMapper userMapper;

  @Override
  public UserBean login(String name, String password) {
    return userMapper.getInfo(name, password);
  }
}
