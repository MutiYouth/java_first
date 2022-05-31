package com.weng.test_simple_app;

import com.weng.test_simple_app.bean.UserBean;
import com.weng.test_simple_app.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestSimpleAppApplicationTests {

  @Autowired
  UserService userService;

  @Test
  void contextLoads() {
    UserBean userBean = userService.login("weng", "2019");
    System.out.println("该用户的ID为："+ userBean.getId());

  }
}
