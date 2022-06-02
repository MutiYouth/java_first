package com.sunlab.helloweb.service;

import com.sunlab.helloweb.bean.UserBean;

public interface UserService {

    UserBean login(String name, String password);

}
