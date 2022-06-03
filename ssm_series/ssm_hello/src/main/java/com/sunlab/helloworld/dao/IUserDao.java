package com.sunlab.helloworld.dao;


import com.sunlab.helloworld.model.User;

public interface IUserDao {

    User selectUser(long id);
}
