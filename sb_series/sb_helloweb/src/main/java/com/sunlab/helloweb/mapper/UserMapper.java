package com.sunlab.helloweb.mapper;
import com.sunlab.helloweb.bean.UserBean;

public interface UserMapper {

    UserBean getInfo(String name, String password);

}
