package com.sunlab.helloworld.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSpringBootController {

    @RequestMapping("/")
    public String Say(){
        return "hello spring boot. 20.4.19 17:05";
    }
}
