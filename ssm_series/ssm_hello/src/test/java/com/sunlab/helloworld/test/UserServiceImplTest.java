package com.sunlab.helloworld.test;


import com.sunlab.helloworld.model.User;
import com.sunlab.helloworld.service.IUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class UserServiceImplTest extends UserDaoTest {
  @Autowired
  IUserService userService;

  @Test
  public void getById() {
    User user = userService.selectUser(1);
    System.out.println(user.getUsername());
  }
}
