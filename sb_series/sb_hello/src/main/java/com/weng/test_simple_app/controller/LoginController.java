package com.weng.test_simple_app.controller;

import com.weng.test_simple_app.bean.UserBean;
import com.weng.test_simple_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

  // 将Service注入Web层
  @Autowired UserService userService;

  @RequestMapping("/login")
  public String show() {
    return "login";
  }

  @RequestMapping(value = "/loginIn", method = RequestMethod.POST)
  public String login(String name, String password) {
    UserBean userBean = userService.login(name, password);
    if (userBean != null) {
      return "success";
    } else {
      return "error";
    }
  }
}
