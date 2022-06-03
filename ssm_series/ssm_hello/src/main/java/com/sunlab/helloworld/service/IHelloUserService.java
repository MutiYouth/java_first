package com.sunlab.helloworld.service;

import com.sunlab.helloworld.model.HelloUser;

import java.util.List;

public interface IHelloUserService {

    public List<HelloUser> getAll() throws Exception;


}