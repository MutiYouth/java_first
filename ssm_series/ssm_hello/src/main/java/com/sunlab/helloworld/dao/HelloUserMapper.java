package com.sunlab.helloworld.dao;

import com.sunlab.helloworld.model.HelloUser;
import com.sunlab.helloworld.model.User;

import java.util.List;

public interface HelloUserMapper {

    public List<HelloUser> getAll() throws Exception;

}