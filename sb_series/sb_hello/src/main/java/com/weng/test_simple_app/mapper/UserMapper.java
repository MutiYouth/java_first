package com.weng.test_simple_app.mapper;
import com.weng.test_simple_app.bean.UserBean;

public interface UserMapper {

    UserBean getInfo(String name, String password);

}
