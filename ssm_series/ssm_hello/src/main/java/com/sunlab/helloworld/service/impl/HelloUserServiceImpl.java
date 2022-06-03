package com.sunlab.helloworld.service.impl;

import com.sunlab.helloworld.dao.HelloUserMapper;
import com.sunlab.helloworld.model.HelloUser;
import com.sunlab.helloworld.service.IHelloUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelloUserServiceImpl implements IHelloUserService {

    @Autowired
    private HelloUserMapper userMapper;

    @Override
    public List<HelloUser> getAll() throws Exception {
        List<HelloUser> list = userMapper.getAll();
        return list;
    }
}