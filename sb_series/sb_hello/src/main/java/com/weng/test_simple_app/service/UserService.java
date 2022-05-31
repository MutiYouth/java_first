package com.weng.test_simple_app.service;

import com.weng.test_simple_app.bean.UserBean;

public interface UserService {

    UserBean login(String name, String password);

}
