package com.sunlab.helloworld.test;

import java.util.List;

import com.sunlab.helloworld.dao.IUserDao;
import com.sunlab.helloworld.model.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class UserDaoTest extends BaseTest {


  @Autowired
  private IUserDao userDao;

  @Test
  public void getById() {
    User user = userDao.selectUser(1);
    System.out.println(user.getUsername());
  }

}
