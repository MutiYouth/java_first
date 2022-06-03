package com.sunlab.helloworld.service;

import com.sunlab.helloworld.model.User;

public interface IUserService {

    public User selectUser(long userId);
}